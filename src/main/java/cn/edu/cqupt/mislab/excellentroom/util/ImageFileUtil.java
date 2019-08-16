package cn.edu.cqupt.mislab.excellentroom.util;

/**
 * @Author HanSiyue
 * @Date 2019/8/14 下午10:36
 */
import net.coobird.thumbnailator.Thumbnails;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.multipart.MultipartFile;
import org.w3c.dom.stylesheets.LinkStyle;

import java.io.*;
import java.lang.reflect.Field;
import java.nio.channels.*;
import java.util.*;

public class ImageFileUtil {

    private static final String BASIC_DIR = System.getProperty("user.dir") + File.separator + "static" + File.separator;
    //存放图片的目录
    private static final String IMAGE_DIR = BASIC_DIR + "image" + File.separator;
    //存放已经删除了的图片
    private static final String DESTROY_DIR = BASIC_DIR + "destroy" + File.separator;

    private static Logger logger = LoggerFactory.getLogger(ImageFileUtil.class);

    static {
        //对文件目录进行正确性校验
        File imageDir = new File(IMAGE_DIR);
        if (!imageDir.exists()) {
            boolean mkdir = imageDir.mkdirs();
            if (!mkdir) {
                throw new RuntimeException("存放图片的文件夹创建失败！");
            }
        }
        File destroyDir = new File(DESTROY_DIR);
        if (!destroyDir.exists()) {
            boolean mkdir = destroyDir.mkdir();
            if (!mkdir) {
                throw new RuntimeException("存放图片的文件夹创建失败！");
            }
        }
    }

    public static enum ImageFileSize {

        empty(0, "empty"),//空图片
        mini(10 * 1024, "mini"),//迷你图片，0-10KB
        small(50 * 1024, "small"),//小图，10-50KB
        middle(100 * 1024, "middle"),//中等图，50-100KB
        big(500 * 1024, "big"),//大图，100-500KB
        original(-1, "original"),
        ;//原图，0-10MB

        ImageFileSize(long fileSize, String sizeName) {
            this.fileSize = fileSize;
            this.sizeName = sizeName;
        }

        private long fileSize;
        private String sizeName;

        public long getFileSize() {
            return fileSize;
        }

        public String getSizeName() {
            return sizeName;
        }
    }

    @SuppressWarnings("ResultOfMethodCallIgnored")
    static class ImageHelper {

        private static final Map<String, Field> filedMap = ReflectUtil.resolveClassFieldMap(ImageHelper.class);

        //默认的压缩比
        public static final Double defaultScale = 0.5;

        /*
        图片链接的格式标识
         */
        private boolean mini;//迷你图片，0-10KB
        private boolean small;//小图，10-50KB
        private boolean middle;//中等图，50-100KB
        private boolean big;//大图，100-500KB
        private boolean original;//原图，0-10MB
        /*
        图片文件格式标识
        */
        private String fileFormat;//文件格式
        /*
        其他数据
         */
        private String fileName;//生成的文件名称

        private File concurrentFile;//处理的数据
        private Long concurrentFileSize;//文件大小

        public String process(MultipartFile imageFile) throws Exception {

            //获取文件格式
            getFileFormat(imageFile.getOriginalFilename());
            //检查文件格式
            if (checkFileFormat()) {
                //生成文件名称
                generateFileName();
                System.out.println(this.fileName);

                logger.info("开始存储图片文件：{}", this.fileName);

                //存储文件并生成原始连接
                storageFile(imageFile);
                //开始自适应压缩处理
                adaptiveCompression();

                return getFileUrl();
            }

            return null;
        }

        private String getFileUrl() {
            StringBuilder finalFileName = new StringBuilder();
            finalFileName.append(this.fileName);
            if (original) {
                finalFileName.append("_original");
            }
            if (big) {
                finalFileName.append("_big");
            }
            if (middle) {
                finalFileName.append("_middle");
            }
            if (small) {
                finalFileName.append("_small");
            }
            if (mini) {
                finalFileName.append("_mini");
            }
            finalFileName.append(this.fileFormat);

            String toString = finalFileName.toString();

            logger.info("成功存储图片文件：{}", toString);

            return toString;
        }

        private void adaptiveCompression() throws IOException, IllegalAccessException {
            //处理成大文件
            processBig();
            //处理成中文件
            processMiddle();
            //处理成小文件
            processSmall();
            //处理成迷你文件
            processMini();
        }

        private void processMini() throws IOException, IllegalAccessException {
            process(ImageFileSize.mini, ImageFileSize.empty, "mini");
        }

        private void processSmall() throws IOException, IllegalAccessException {
            process(ImageFileSize.small, ImageFileSize.mini, "small");
        }

        private void processMiddle() throws IOException, IllegalAccessException {
            process(ImageFileSize.middle, ImageFileSize.small, "middle");
        }

        private void processBig() throws IOException, IllegalAccessException {

            process(ImageFileSize.big, ImageFileSize.middle, "big");
        }

        private void process(ImageFileSize up, ImageFileSize down, String step) throws IOException, IllegalAccessException {

            //只有文件大小大于了下限才会进行存储或者压缩
            if (this.concurrentFileSize > down.fileSize) {

                //需要存储的文件的文件名称
                String fileName = IMAGE_DIR + this.fileName + "_" + step + this.fileFormat;

                //需要存储的最终的文件位置
                File toFile = new File(fileName);

                //如果文件大于了大图片的大小上限将会被压缩
                if (this.concurrentFileSize > up.fileSize) {

                    double scale = defaultScale;

                    //进行压缩
                    Thumbnails.of(this.concurrentFile)
                            .scale(scale)
                            .outputQuality(1.0)//保质压缩
                            .toFile(toFile);

                    //判断是否还需要进行压缩
                    while (toFile.length() > up.fileSize) {

                        //创建一个临时文件
                        File temp = new File(toFile.getParentFile(), System.nanoTime() + this.fileFormat);

                        //进行压缩
                        Thumbnails.of(toFile)
                                .scale(scale)
                                .outputQuality(1.0)
                                .toFile(temp);

                        //删除原来的文件，这个文件是源文件第一次压缩的产物
                        toFile.delete();

                        //指向压缩后的文件
                        toFile = temp;
                    }

                    //对文件重命名
                    toFile.renameTo(new File(fileName));

                    //该阶段解析完毕
                    Field stepField = filedMap.get(step);

                    stepField.setBoolean(this, true);

                    //用于下阶段的处理，只有压缩后的数据刚刚好在范围内的时候才会改，否则不改
                    if (toFile.length() > down.fileSize) {

                        this.concurrentFile = toFile;
                        this.concurrentFileSize = toFile.length();
                    }
                } else {

                    //直如果文件刚刚好是在这个阶段的文件大小内，直接进行存储
                    try (
                            FileChannel fromChannel = new FileInputStream(this.concurrentFile).getChannel();
                            FileChannel toChannel = new FileOutputStream(toFile).getChannel()
                    ) {
                        fromChannel.transferTo(
                                0,
                                fromChannel.size(),
                                toChannel
                        );
                    }

                    //该阶段解析完毕
                    Field stepField = filedMap.get(step);

                    stepField.setBoolean(this, true);

                    //用于下阶段的处理
                    this.concurrentFile = toFile;
                    this.concurrentFileSize = toFile.length();
                }
            }
        }

        private void storageFile(MultipartFile imageFile) throws IOException {

            //记录当前文件的大小
            this.concurrentFileSize = imageFile.getSize();

            //将文件转到内存
            File toFile = new File(IMAGE_DIR + this.fileName + "_original" + this.fileFormat);

            //存储文件
            imageFile.transferTo(toFile);

            //原始文件存储完毕
            this.original = true;

            //记录下一步需要处理的文件
            this.concurrentFile = toFile;
        }

        private void generateFileName() {
            this.fileName = "" + System.nanoTime() + Thread.currentThread().getId();
        }

        private boolean checkFileFormat() {
            return ".jpg".equalsIgnoreCase(this.fileFormat) || ".png".equalsIgnoreCase(this.fileFormat) || ".jpeg".equalsIgnoreCase(this.fileFormat);
        }

        private void getFileFormat(String fileName) {
            this.fileFormat = ImageFileUtil.getFileFormat(fileName);
        }
    }

    /**
     * 存储文件，返回的是文件的一个文件名称，可以通过这个名称直接访问连接，这个特殊的连接的连接由以下字段组成：
     * 1、文件名称_original_[big]_[middle]_[small]_[mini]_.[文件格式/jpg/jpeg/png]
     * 2、例如：1235698775885_original_big_middle_small_mini.jpg
     * 2.1、源文件格式为jpg，表示以下链接均存在图片：
     * 1、1235698775885_original.jpg
     * 2、1235698775885_big.jpg
     * 3、1235698775885_middle.jpg
     * 4、1235698775885_small.jpg
     * 5、1235698775885_mini.jpg
     * 3、例如：1235698775885_original_middle_small_mini.png
     * 3.1、源文件格式为png，表示以下链接均存在图片：
     * 1、1235698775885_original.png
     * 3、1235698775885_middle.png
     * 4、1235698775885_small.png
     * 5、1235698775885_mini.png
     *
     * @param imageFile：需要存储的文件
     * @return ：一个特色的连接地址
     */
    public static String storageImage(MultipartFile imageFile) {

        try {
            return new ImageHelper().process(imageFile);

        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    public static void deleteImage(String imageFileUrl) {

        try {

            String fileFormat = getFileFormat(imageFileUrl);

            List<String> fileNames = getFileNames(imageFileUrl, fileFormat);

            File fromFile = new File(IMAGE_DIR + fileNames.get(0));
            File toFile = new File(DESTROY_DIR + fileNames.get(0));

            try (FileChannel fromChannel = new FileInputStream(fromFile).getChannel();
                 FileChannel toChannel = new FileOutputStream(toFile).getChannel();) {

                fromChannel.transferTo(
                        0,
                        fromChannel.size(),
                        toChannel
                );
            } catch (IOException e) {
                e.printStackTrace();
            }

            try {

                //在存在一个通道指向这个文件的时候是不能够删除掉这个文件的！！！
                fromFile.delete();

                fileNames.stream().skip(1).forEach(fileName -> {
                    new File(IMAGE_DIR + fileName).delete();
                });

            } catch (Exception ignore) {
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static String getFileFormat(String fileName) {
        return fileName.substring(fileName.lastIndexOf(".")).toLowerCase();
    }

    private static List<String> getFileNames(String imageUrl, String fileFormat) {

        List<String> result = new ArrayList<>();

        String[] strings = imageUrl.split("_");

        int length = strings.length;

        for (int i = 1; i < length - 1; i++) {

            result.add(strings[0] + "_" + strings[i] + fileFormat);
        }

        result.add(strings[0] + "_" + strings[length - 1]);

        return result;
    }
}

package cn.edu.cqupt.mislab.excellentroom.util;

import java.io.File;
import java.io.IOException;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.multipart.MultipartFile;
/**
 * @Author HanSiyue
 * @Date 2019/8/17 下午12:21
 */
public class FileUtil {

    public static boolean upload(MultipartFile file, String path){
        try {
            String fileName = file.getOriginalFilename();
            // 生成新的文件名
            String realPath = path + "/" + FileNameUtil.getFileName(fileName);

            //使用原文件名
            // String realPath = path + "/" + fileName;

            File dest = new File(realPath);

            //判断文件父目录是否存在
            if(!dest.getParentFile().exists()){
                dest.getParentFile().mkdir();
            }
            //保存文件
            file.transferTo(dest);
            return true;
        } catch (IllegalStateException e) {
            e.printStackTrace();
            return false;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }

    }

    public static String fileUrl(MultipartFile file, String path){
        String fileName = file.getOriginalFilename();
        // 生成新的文件名
        String realPath = path + "/" + FileNameUtil.getFileName(fileName);

        return realPath;
    }

}

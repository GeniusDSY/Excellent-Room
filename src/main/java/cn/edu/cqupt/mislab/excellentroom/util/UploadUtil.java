package cn.edu.cqupt.mislab.excellentroom.util;

import cn.edu.cqupt.mislab.excellentroom.constant.ResultEnum;
import cn.edu.cqupt.mislab.excellentroom.exception.MyException;

import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;

/**
 * @program: Excellent-Room-sl-dev
 * @description: 上传工具
 * @author: 宋丽
 * @create: 2019-08-23 13:50
 **/
public class UploadUtil {
    public static String pic(MultipartFile file, HttpServletRequest request) throws MyException {
        //项目代号
        String projectId = GetUtil.getProjectId(request);
        //文件名+后缀
        String fileName = file.getOriginalFilename();
        //储存路径
        String url = "";
        try {
            if(file.isEmpty()){
                throw new  MyException(ResultEnum.ISNULL);
            }
            if (fileName == null || "".equals(fileName)){
                throw new  MyException(ResultEnum.ISNULL);
            }
            //文件储存位置
            String realPath = request.getSession().getServletContext().getRealPath("/")+projectId+"\\pic";
            url = realPath+"\\"+fileName;
            //文件目录不存在，就创建一个
            File dir = new File(realPath);
            if (!dir.isDirectory()) {
                dir.mkdirs();
            }
            //获取文件夹路径
            File file1 = new File(realPath);
            //将图片存入文件夹
            File targetFile = new File(file1,fileName);
            //将上传的文件写到服务器上指定的文件。
            file.transferTo(targetFile);
            return url;
        } catch (Exception e) {
            e.printStackTrace();
            throw new MyException(ResultEnum.ERROR);
        }
    }

    public static String video(MultipartFile file, HttpServletRequest request) throws MyException {
        //项目代号
        String projectId = GetUtil.getProjectId(request);
        //文件名+后缀
        String fileName = file.getOriginalFilename();
        //储存路径
        String url = "";
        try {
            if(file.isEmpty()){
                throw new  MyException(ResultEnum.ISNULL);
            }
            if (fileName == null || "".equals(fileName)){
                throw new  MyException(ResultEnum.NOTEXIST);
            }
            //文件储存位置
            String realPath = request.getSession().getServletContext().getRealPath("/")+projectId+"\\video";
            url = realPath+"\\"+fileName;
            //文件目录不存在，就创建一个
            File dir = new File(realPath);
            if (!dir.isDirectory()) {
                dir.mkdirs();
            }
            //获取文件夹路径
            File file1 = new File(realPath);
            //将图片存入文件夹
            File targetFile = new File(file1,fileName);
            //将上传的文件写到服务器上指定的文件。
            file.transferTo(targetFile);
            return url;
        } catch (Exception e) {
            e.printStackTrace();
            throw new MyException(ResultEnum.ERROR);
        }
    }

}

package cn.edu.cqupt.mislab.excellentroom.util;

import org.apache.ibatis.annotations.Param;

import cn.edu.cqupt.mislab.excellentroom.util.UUIDUtil;
/**
 * @Author HanSiyue
 * @Date 2019/8/17 下午12:13
 */
public class FileNameUtil {
    /**
     *@param fileName 文件名
     *@return 后缀名
     */
    public static String getSuffix(@Param("fileName") String fileName){
        return fileName.substring(fileName.lastIndexOf("."));
    }

    /**
     *@param fileOriginName 源文件名
     *@return 新文件名
     */
    public static String getFileName(String fileOriginName){
        return UUIDUtil.getUUID() + FileNameUtil.getSuffix(fileOriginName);
    }
}

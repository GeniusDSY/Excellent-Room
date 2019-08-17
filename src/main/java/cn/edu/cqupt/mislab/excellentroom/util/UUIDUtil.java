package cn.edu.cqupt.mislab.excellentroom.util;

import java.util.UUID;

/**
 * @Author HanSiyue
 * @Date 2019/8/17 下午12:19
 */

public class UUIDUtil {

    public static String getUUID(){
        return UUID.randomUUID().toString().replace("-", "");
    }
}

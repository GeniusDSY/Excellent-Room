package cn.edu.cqupt.mislab.excellentroom.util;

import java.rmi.ServerException;

/**
 * @Author HanSiyue
 * @Date 2019/8/22 下午1:10
 */
public class SqlExcecuteUtil {
    public static void SqlExcecute(boolean... flags) throws ServerException {
        for (boolean flag : flags) {
            if (! flag){
                throw new ServerException("服务器错误");
            }
        }
    }
}

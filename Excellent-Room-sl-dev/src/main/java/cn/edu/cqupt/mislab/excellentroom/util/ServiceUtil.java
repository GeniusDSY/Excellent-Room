package cn.edu.cqupt.mislab.excellentroom.util;

import cn.edu.cqupt.mislab.excellentroom.constant.ResultEnum;
import cn.edu.cqupt.mislab.excellentroom.exception.MyException;

import java.util.List;

/**
 * @program: Excellent-Room-sl-dev
 * @description: 业务逻辑工具
 * @author: 宋丽
 * @create: 2019-08-28 15:41
 **/
public class ServiceUtil {

    /**
     * update业务逻辑工具
     * @param flag
     * @throws MyException
     */
    public static void updateSuccess(boolean flag) throws MyException {
        if(!flag){
            throw new MyException(ResultEnum.UPDATE_ERROR);
        }
    }

    /**
     * delete业务逻辑工具
     * @param flag
     * @throws MyException
     */
    public static void deleteSuccess(boolean flag) throws MyException {
        if(!flag){
            throw new MyException(ResultEnum.DELETE_ERROR);
        }
    }

    /**
     * insert业务逻辑工具
     * @param flag
     * @throws MyException
     */
    public static void insertSuccess(boolean flag) throws MyException {
        if(!flag){
            throw new MyException(ResultEnum.ADD_ERROR);
        }
    }


}

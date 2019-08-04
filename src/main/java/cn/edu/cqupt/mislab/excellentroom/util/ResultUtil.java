package cn.edu.cqupt.mislab.excellentroom.util;

import cn.edu.cqupt.mislab.excellentroom.domain.entity.ResultJson;
import cn.edu.cqupt.mislab.excellentroom.constant.ResultEnum;

public class ResultUtil {
    /**
     * 状态码记录
     * 0----成功
     * 1----参数错误
     * 2----无对应内容
     * 3----已存在
     * 4----参数为空
     */

    public static ResultJson success(Object object) {
        ResultJson resultJson = new ResultJson();
        resultJson.setStatus(ResultEnum.SUCCESS.getStatus());
        resultJson.setMsg(ResultEnum.SUCCESS.getMsg());
        resultJson.setData(object);
        return resultJson;
    }

    public static ResultJson success() {
        return success(null);
    }

    public static ResultJson error() {
        ResultJson resultJson = new ResultJson();
        resultJson.setStatus(ResultEnum.ERROR.getStatus());
        resultJson.setMsg(ResultEnum.ERROR.getMsg());
        return resultJson;
    }

    public static ResultJson isNull() {
        ResultJson resultJson = new ResultJson();
        resultJson.setStatus(ResultEnum.ISNULL.getStatus());
        resultJson.setMsg(ResultEnum.ISNULL.getMsg());
        return resultJson;
    }

    public static ResultJson isExist() {
        ResultJson resultJson = new ResultJson();
        resultJson.setStatus(ResultEnum.ISEXIST.getStatus());
        resultJson.setMsg(ResultEnum.ISEXIST.getMsg());
        return resultJson;
    }

    public static ResultJson notExist() {
        ResultJson resultJson = new ResultJson();
        resultJson.setStatus(ResultEnum.NOTEXIST.getStatus());
        resultJson.setMsg(ResultEnum.NOTEXIST.getMsg());
        return resultJson;
    }
}

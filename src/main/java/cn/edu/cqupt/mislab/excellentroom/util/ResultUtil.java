package cn.edu.cqupt.mislab.excellentroom.util;

import cn.edu.cqupt.mislab.excellentroom.domain.entity.ResultJson;
import cn.edu.cqupt.mislab.excellentroom.constant.ResultEnum;
import java.util.Map;

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
        resultJson.setStatus(ResultEnum.success.getStatus());
        resultJson.setMsg(ResultEnum.success.getMsg());
        resultJson.setData(object);
        return resultJson;
    }

    public static ResultJson success() {
        return success(null);
    }

    public static ResultJson error(int status, String msg) {
        ResultJson resultJson = new ResultJson();
        resultJson.setStatus(status);
        resultJson.setMsg(msg);
        return resultJson;
    }
}

package cn.edu.cqupt.mislab.excellentroom.util;

import cn.edu.cqupt.mislab.excellentroom.constant.ResultEnum;
import cn.edu.cqupt.mislab.excellentroom.domain.po.Result;
import cn.edu.cqupt.mislab.excellentroom.domain.entity.ResultJson;

public class ResultUtil {

    /**成功且带数据**/
    public static Result success(Object object){
        Result result = new Result();
        result.setCode(ResultEnum.SUCCESS.getCode());
        result.setMsg(ResultEnum.SUCCESS.getMsg());
        result.setData(object);
        return result;
    }
    /**成功但不带数据**/
    public static Result success(){

        return success(null);
    }
    /**失败**/
    public static Result error(Integer code,String msg){
        Result result = new Result();
        result.setCode(code);
        result.setMsg(msg);
        return result;
    }

    /**失败使用枚举**/
    public static Result error(ResultEnum resultEnum){
        Result result = new Result();
        result.setCode(resultEnum.getCode());
        result.setMsg(resultEnum.getMsg());
        return result;
    }
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

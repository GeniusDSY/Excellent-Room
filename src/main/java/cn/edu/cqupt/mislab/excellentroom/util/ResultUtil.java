package cn.edu.cqupt.mislab.excellentroom.util;

import cn.edu.cqupt.mislab.excellentroom.constant.ResultEnum;
import cn.edu.cqupt.mislab.excellentroom.domain.po.Result;

public class ResultUtil {

    /**成功且带数据**/
    public static Result success(Object object){
        Result result = new Result();
        result.setStatus(ResultEnum.SUCCESS.getStatus());
        result.setMsg(ResultEnum.SUCCESS.getMsg());
        result.setData(object);
        return result;
    }
    /**成功但不带数据**/
    public static Result success(){

        return success(null);
    }
    /**失败**/
    public static Result error(Integer Status,String msg){
        Result result = new Result();
        result.setStatus(Status);
        result.setMsg(msg);
        return result;
    }

    /**失败使用枚举**/
    public static Result error(ResultEnum resultEnum){
        Result result = new Result();
        result.setStatus(resultEnum.getStatus());
        result.setMsg(resultEnum.getMsg());
        return result;
    }


    public static Result error() {
        Result result = new Result();
        result.setStatus(ResultEnum.ERROR.getStatus());
        result.setMsg(ResultEnum.ERROR.getMsg());
        return result;
    }

    public static Result isNull() {
        Result result = new Result();
        result.setStatus(ResultEnum.ISNULL.getStatus());
        result.setMsg(ResultEnum.ISNULL.getMsg());
        return result;
    }

    public static Result isExist() {
        Result result = new Result();
        result.setStatus(ResultEnum.ISEXIST.getStatus());
        result.setMsg(ResultEnum.ISEXIST.getMsg());
        return result;
    }

    public static Result notExist() {
        Result result = new Result();
        result.setStatus(ResultEnum.NOTEXIST.getStatus());
        result.setMsg(ResultEnum.NOTEXIST.getMsg());
        return result;
    }
}

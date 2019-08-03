package cn.edu.cqupt.mislab.excellentroom.constant;

import lombok.Data;

import java.util.Map;


public enum ResultEnum {
    /**
     * 状态码记录
     * 0----成功
     * 1----失败
     * 2----不存在
     * 3----已存在
     * 4----参数为空
     */

    success(0,"成功"),
    error(1,"失败"),
    notExist(2,"不存在"),
    isExist(3,"已存在"),
    isNull(4,"参数为空"),
    ;
    private Integer status;
    private String msg;

    ResultEnum(int status,String msg){
        this.status=status;
        this.msg=msg;
    }

    public Integer getStatus() {
        return status;
    }

    public String getMsg() {
        return msg;
    }
}

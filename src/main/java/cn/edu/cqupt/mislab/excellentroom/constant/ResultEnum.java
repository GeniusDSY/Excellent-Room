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

    UNKNOWN_ERROR(-1,"未知错误"),
    SUCCESS(200,"成功"),
    ADD_ERROR(401,"项目已存在，新增失败"),
    UPDATE_ERROR(402,"无匹配项，更新失败"),
    DELETE_ERROR(403,"无匹配项，删除失败"),
    SEARCH_ERROR(405,"无匹配项，查询失败"),
    SUCCESS(0,"成功"),
    ERROR(1,"失败"),
    NOTEXIST(2,"不存在"),
    ISEXIST(3,"已存在"),
    ISNULL(4,"参数为空"),
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
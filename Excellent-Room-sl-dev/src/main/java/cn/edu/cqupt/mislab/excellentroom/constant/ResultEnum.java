package cn.edu.cqupt.mislab.excellentroom.constant;


public enum ResultEnum {
    //这里是可以自己定义的，方便与前端交互即可
    UNKNOWN_ERROR(-1,"未知错误"),
    SUCCESS(200,"成功"),
    PPRJECT_EXISTED(401,"项目已存在"),
    UPDATE_ERROR(402,"更新失败"),
    DELETE_ERROR(403,"删除失败"),
    ;
    private Integer code;
    private String msg;

    ResultEnum(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public Integer getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }
}
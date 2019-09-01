package cn.edu.cqupt.mislab.excellentroom.constant;


public enum ResultEnum {
    //这里是可以自己定义的，方便与前端交互即可
    UNKNOWN_ERROR(-1,"未知错误"),
    SUCCESS(200,"成功"),
    ADD_ERROR(401,"项目已存在，新增失败"),
    UPDATE_ERROR(402,"无匹配项，更新失败"),
    DELETE_ERROR(403,"无匹配项，删除失败"),
    SEARCH_ERROR(405,"无匹配项，查询失败")
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
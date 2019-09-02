package cn.edu.cqupt.mislab.excellentroom.domain.po;

import lombok.Data;

@Data
public class Result<T> {
    private Integer Status;
    private String msg;
    private T data;

    public Result() {
        super();
    }

    public Result(Integer Status, String msg, T data) {
        this.Status = Status;
        this.msg = msg;
        this.data = data;
    }

    public Integer getStatus() {
        return Status;
    }

    public void setStatus(Integer Status) {
        this.Status = Status;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }


}

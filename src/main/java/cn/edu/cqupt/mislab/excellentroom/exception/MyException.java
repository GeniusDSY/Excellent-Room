package cn.edu.cqupt.mislab.excellentroom.exception;

import cn.edu.cqupt.mislab.excellentroom.constant.ResultEnum;

/**
 * @program: Excellent-Room-sl-dev
 * @description: 自定义异常类
 * @author: 宋丽
 * @create: 2019-08-05 00:25
 **/
public class MyException extends Exception {

    private int Status;
    private String message;

    public MyException(int Status) {
        super();
        this.Status = Status;
    }
    public MyException(ResultEnum resultEnum){
        super();
        this.Status = resultEnum.getStatus();
        this.message = resultEnum.getMsg();
    }

    @Override
    public String toString() {
        return "MyException{" +
                "Status=" + Status +
                ", message='" + message + '\'' +
                '}';
    }

    public MyException(int Status, String message) {
        super();
        this.Status = Status;
        this.message = message;
    }

    public MyException() {
        super();
    }

    public int getStatus() {
        return Status;
    }

    public void setStatus(int Status) {
        this.Status = Status;
    }

    @Override
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }


}

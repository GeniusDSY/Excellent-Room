package cn.edu.cqupt.mislab.excellentroom.exception;

import cn.edu.cqupt.mislab.excellentroom.constant.ResultEnum;

/**
 * @program: Excellent-Room-sl-dev
 * @description: 自定义异常类
 * @author: 宋丽
 * @create: 2019-08-05 00:25
 **/
public class MyException extends Exception {

    private int code;
    private String message;

    public MyException(int code) {
        super();
        this.code = code;
    }
    public MyException(ResultEnum resultEnum){
        super();
        this.code = resultEnum.getCode();
        this.message = resultEnum.getMsg();
    }

    @Override
    public String toString() {
        return "MyException{" +
                "code=" + code +
                ", message='" + message + '\'' +
                '}';
    }

    public MyException(int code, String message) {
        super();
        this.code = code;
        this.message = message;
    }

    public MyException() {
        super();
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    @Override
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }


}

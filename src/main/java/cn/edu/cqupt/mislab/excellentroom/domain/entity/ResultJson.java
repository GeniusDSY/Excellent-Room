package cn.edu.cqupt.mislab.excellentroom.domain.entity;

import lombok.Data;

import java.util.Map;
@Data
public class ResultJson<T> {


    private Integer status;
    private String msg;
    private T data;

}

package cn.edu.cqupt.mislab.excellentroom.domain.entity;

import lombok.Data;

/**
 * @Author HanSiyue
 * @Date 2019/8/25 下午10:06
 */

@Data
public class ClientWant {
    private String projectId;
    private Integer id;
    private String tel;
    private Integer price;
    private Integer type;
}

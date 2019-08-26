package cn.edu.cqupt.mislab.excellentroom.domain.entity;

import lombok.Data;

/**
 * @Author HanSiyue
 * @Date 2019/8/26 下午2:48
 */

@Data
public class RoomType {
    private String projectId;
    private Integer id;
    private Integer type;
    private String layoutUrl;
    private String panoramaUrl;
    private String simplePicUrl;

}

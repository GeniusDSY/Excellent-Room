package cn.edu.cqupt.mislab.excellentroom.domain.dto;

import org.springframework.data.annotation.Id;

/**
 * @program: Excellent-Room-sl-dev
 * @description: 传入项目代号
 * @author: 宋丽
 * @create: 2019-08-16 06:50
 **/

public class ProjectId {
    @Id
    private String id;

    public ProjectId(String projectId) {
        this.id = projectId;
    }

    public String getProjectId() {
        return id;
    }

    public void setProjectId(String projectId) {
        this.id = projectId;
    }

    @Override
    public String toString() {
        return "ProjectId{" +
                "projectId='" + id + '\'' +
                '}';
    }
}

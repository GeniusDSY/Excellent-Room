package cn.edu.cqupt.mislab.excellentroom.domain.dto;

/**
 * @program: Excellent-Room-sl-dev
 * @description: 传入项目代号
 * @author: 宋丽
 * @create: 2019-08-16 06:50
 **/
public class ProjectId {

    private String projectId;

    public ProjectId(String projectId) {
        this.projectId = projectId;
    }

    public String getProjectId() {
        return projectId;
    }

    public void setProjectId(String projectId) {
        this.projectId = projectId;
    }

    @Override
    public String toString() {
        return "ProjectId{" +
                "projectId='" + projectId + '\'' +
                '}';
    }
}

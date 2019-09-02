package cn.edu.cqupt.mislab.excellentroom.domain.entity;

import lombok.Data;
import org.apache.tomcat.jni.File;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.annotation.Id;
/**
 *项目的实体类
 *
 * @author 宋丽
 * @date 2019/8/4
 */
@Data
public class Project {
    @Id
    private String projectId;
    private String province;
    private String district;
    private String name;
    private String tel;
    private String QRStatusName;


    public Project(){}

    public Project(String projectId,String province, String district, String name, String tel, String QRStatusName) {
        this.projectId = projectId;
        this.province = province;
        this.district = district;
        this.name = name;
        this.tel = tel;
        this.QRStatusName = QRStatusName;
    }

    public String getProjectId() {
        return projectId;
    }

    public void setProjectId(String projectId) {
        this.projectId = projectId;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getQRStatusName() {
        return QRStatusName;
    }

    public void setQRStatusName(String QRStatusName) {
        this.QRStatusName = QRStatusName;
    }

    @Override
    public String toString() {
        return "Project{" +
                "projectId='" + projectId + '\'' +
                ", province='" + province + '\'' +
                ", district='" + district + '\'' +
                ", name='" + name + '\'' +
                ", tel='" + tel + '\'' +
                ", QRStatusName='" + QRStatusName + '\'' +
                '}';
    }
}

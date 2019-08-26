package cn.edu.cqupt.mislab.excellentroom.domain.entity;

import org.apache.tomcat.jni.File;
import org.springframework.boot.autoconfigure.domain.EntityScan;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 *项目的实体类
 *
 * @author 宋丽
 * @date 2019/8/4
 */
@Entity
public class Project {
    @Id
    @GeneratedValue
    private String projectId;
    private String province;
    private String district;
    private String name;
    private String tel;
    private String QRcodeName;

    public Project(){}

    public Project(String projectId,String province, String district, String name, String tel, String QRcodeName) {
        this.projectId = projectId;
        this.province = province;
        this.district = district;
        this.name = name;
        this.tel = tel;
        this.QRcodeName = QRcodeName;
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

    public String getQRcodeName() {
        return QRcodeName;
    }

    public void setQRcodeName(String QRcodeName) {
        this.QRcodeName = QRcodeName;
    }

    @Override
    public String toString() {
        return "Project{" +
                "projectId='" + projectId + '\'' +
                ", province='" + province + '\'' +
                ", district='" + district + '\'' +
                ", name='" + name + '\'' +
                ", tel='" + tel + '\'' +
                ", QRcodeName='" + QRcodeName + '\'' +
                '}';
    }
}

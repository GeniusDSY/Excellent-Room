package cn.edu.cqupt.mislab.excellentroom.domain.po;

import java.util.List;

/**
 * @program: Excellent-Room-sl-dev
 * @description: 对应项目的企业相关信息输出，用于企业简介处
 * @author: 宋丽
 * @create: 2019-08-16 06:55
 **/
public class CompanyProfiles {

    private String Bkground;
    private String text;
    private String video;

    public CompanyProfiles() {
    }

    public CompanyProfiles(String bkground, String text, String video) {
        Bkground = bkground;
        this.text = text;
        this.video = video;
    }

    public String getBkground() {
        return Bkground;
    }

    public void setBkground(String bkground) {
        Bkground = bkground;
    }

    public String getVideo() {
        return video;
    }

    public void setVideo(String video) {
        this.video = video;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }


    @Override
    public String toString() {
        return "CompanyProfiles{" +
                "Bkground='" + Bkground + '\'' +
                ", text='" + text + '\'' +
                ", video='" + video + '\'' +
                '}';
    }

}

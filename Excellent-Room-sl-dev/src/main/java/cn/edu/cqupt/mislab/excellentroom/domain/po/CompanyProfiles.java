package cn.edu.cqupt.mislab.excellentroom.domain.po;

import java.util.List;

/**
 * @program: Excellent-Room-sl-dev
 * @description: 对应项目的企业相关信息输出，用于企业简介处
 * @author: 宋丽
 * @create: 2019-08-16 06:55
 **/
public class CompanyProfiles {

    private String title;
    private String text;
    private String video;
    private List<String> pic;

    public CompanyProfiles() {
    }

    public CompanyProfiles(String title,String text, String video, List<String> pic) {
        this.title = title;
        this.text = text;
        this.video = video;
        this.pic = pic;
    }


    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getViedio() {
        return video;
    }

    public void setViedio(String viedio) {
        this.video = viedio;
    }

    public List<String> getPic() {
        return pic;
    }

    public void setPic(List<String> pic) {
        this.pic = pic;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}

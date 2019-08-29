package cn.edu.cqupt.mislab.excellentroom.domain.po;

/**
 * @program: Excellent-Room-sl-dev
 * @description: 企业文化
 * @author: 宋丽
 * @create: 2019-08-28 04:58
 **/
public class Culture {

    private String title;
    private String text;

    public Culture(String title, String text) {
        this.title = title;
        this.text = text;
    }

    public Culture() {
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}

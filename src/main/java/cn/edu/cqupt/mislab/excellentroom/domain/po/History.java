package cn.edu.cqupt.mislab.excellentroom.domain.po;

/**
 * @program: Excellent-Room-sl-dev
 * @description: 发展历程
 * @author: 宋丽
 * @create: 2019-08-28 13:39
 **/
public class History {

    private String id;
    private String pic;
    private String time;
    private String simple;
    private String text;

    @Override
    public String toString() {
        return "History{" +
                "id='" + id + '\'' +
                ", pic='" + pic + '\'' +
                ", time='" + time + '\'' +
                ", simple='" + simple + '\'' +
                ", text='" + text + '\'' +
                '}';
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public History() {
    }

    public History(String pic, String time, String simple, String text,String id) {
        this.id = id;
        this.pic = pic;
        this.time = time;
        this.simple = simple;
        this.text = text;
    }

    public String getPic() {
        return pic;
    }

    public void setPic(String pic) {
        this.pic = pic;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getSimple() {
        return simple;
    }

    public void setSimple(String simple) {
        this.simple = simple;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

}

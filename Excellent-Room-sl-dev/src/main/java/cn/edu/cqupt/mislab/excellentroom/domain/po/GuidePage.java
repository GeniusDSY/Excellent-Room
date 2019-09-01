package cn.edu.cqupt.mislab.excellentroom.domain.po;

/**
 * @program: Excellent-Room-sl-dev
 * @description: 引导页底部信息，开放商、地址和服务热线
 * @author: 宋丽
 * @create: 2019-08-30 04:22
 **/
public class GuidePage {
    private String developer;
    private String address;
    private String telephone;

    @Override
    public String toString() {
        return "GuidePage{" +
                "developer='" + developer + '\'' +
                ", adress='" + address + '\'' +
                ", telephone='" + telephone + '\'' +
                '}';
    }


    public GuidePage(String developer, String address, String telephone) {
        this.developer = developer;
        this.address = address;
        this.telephone = telephone;
    }

    public String getDeveloper() {
        return developer;
    }

    public void setDeveloper(String developer) {
        this.developer = developer;
    }

    public String getAdress() {
        return address;
    }

    public void setAdress(String address) {
        this.address = address;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public GuidePage() {
    }
}

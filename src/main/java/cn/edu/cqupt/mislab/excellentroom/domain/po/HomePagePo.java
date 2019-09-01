package cn.edu.cqupt.mislab.excellentroom.domain.po;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.ToString;

/**
 * @Author HanSiyue
 * @Date 2019/8/14 下午10:25
 */
@ApiModel
@Data
@ToString
public class HomePagePo {
    @ApiModelProperty(name = "homePageBkgroundUrl",value = "首页背景图片地址",dataType = "string")
    private String homePageBkgroundUrl;
    @ApiModelProperty(name = "homePageLogoUrl",value = "首页Logo地址",dataType = "string")
    private String homePageLogoUrl;
    @ApiModelProperty(name = "homePageIconUrl",value = "首页Icon地址",dataType = "string")
    private String homePageIconUrl;
}

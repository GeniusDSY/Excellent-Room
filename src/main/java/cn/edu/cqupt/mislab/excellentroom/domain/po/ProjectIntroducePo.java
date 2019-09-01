package cn.edu.cqupt.mislab.excellentroom.domain.po;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.ToString;

/**
 * @Author HanSiyue
 * @Date 2019/8/24 下午3:25
 */

@ApiModel
@Data
@ToString
public class ProjectIntroducePo {
    @ApiModelProperty(name = "projectIntroduceBkgroundUrl",value = "项目介绍背景图片地址",dataType = "string")
    private String projectIntroduceBkgroundUrl;
    @ApiModelProperty(name = "projectIntroduceText", value = "项目介绍文字描述", dataType = "string")
    private String projectIntroduceText;
    @ApiModelProperty(name = "projectIntroduceTitel", value = "项目介绍标题", dataType = "string")
    private String projectIntroduceTitle;
}

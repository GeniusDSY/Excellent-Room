package cn.edu.cqupt.mislab.excellentroom.domain.po;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.ToString;

@ApiModel
@Data
@ToString
public class UserPo {

    @ApiModelProperty(name = "id",value = "管理员ID",dataType = "integer")
    private Integer id;
    @ApiModelProperty(name = "userName",value = "管理员名字",dataType = "string")
    private String userName;

}

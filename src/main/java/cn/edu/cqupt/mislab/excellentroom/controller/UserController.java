package cn.edu.cqupt.mislab.excellentroom.controller;

import cn.edu.cqupt.mislab.excellentroom.constant.ResultEnum;
import cn.edu.cqupt.mislab.excellentroom.domain.dto.UserDto;
import cn.edu.cqupt.mislab.excellentroom.domain.entity.ResultJson;
import cn.edu.cqupt.mislab.excellentroom.service.UserService;
import cn.edu.cqupt.mislab.excellentroom.util.ResultUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("userSystem")
@Api("登陆文档接口")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("login")
    @ApiOperation("用户登陆")
    public ResultJson login(@RequestBody UserDto userDto) {
        try {
            if ("".equals(userDto.getUserName()) || "".equals(userDto.getPassword()) || "".equals(userDto
                    .getVerifyCode())) {
                return ResultUtil.error(4, "参数为空");
            }

        } catch (Exception e) {
            return ResultUtil.error(1, e.getMessage());
        }
        return ResultUtil.success();
    }


    @PostMapping("add")
    @ApiOperation("添加管理员")
    public ResultJson add(@RequestBody UserDto userDto){
        Boolean result = userService.add(userDto);
        try {
            if ("".equals(userDto.getUserName()) && "".equals(userDto.getPassword())&& "".equals(userDto
                    .getVerifyCode())) {
                return ResultUtil.error(4, "参数为空");
            }
        } catch (Exception e) {
            return ResultUtil.error(1, e.getMessage());
        }
        return ResultUtil.success();
    }

    @DeleteMapping("delete")
    @ApiOperation("删除管理员")
    @ApiImplicitParam(name = "userName",value = "用户名",dataType = "string",required = true)
    public ResultJson delete(String userName) {
        try {
            if ("".equals(userName)) {
                return ResultUtil.error(ResultEnum.isNull.getStatus(), "参数为空");
            }
            if (userService.delete(userName)){
                return ResultUtil.success();
            }
        }catch (Exception e){
            return ResultUtil.error(1,e.getMessage());
        }
        return null;
    }

}

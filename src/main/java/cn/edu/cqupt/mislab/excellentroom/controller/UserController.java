package cn.edu.cqupt.mislab.excellentroom.controller;

import cn.edu.cqupt.mislab.excellentroom.constant.ResultEnum;
import cn.edu.cqupt.mislab.excellentroom.domain.dto.UserDto;
import cn.edu.cqupt.mislab.excellentroom.domain.entity.ResultJson;
import cn.edu.cqupt.mislab.excellentroom.domain.po.UserPo;
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
        if (userDto.getUserName() == null || userDto.getPassword() == null || userDto
                .getVerifyCode() == null) {
            return ResultUtil.isNull();
        }
        try {
            UserPo userPo = userService.login(userDto);
        } catch (Exception e) {
            return ResultUtil.error();
        }
        return ResultUtil.success();
    }


    @PostMapping("add")
    @ApiOperation("添加管理员")
    public ResultJson add(@RequestBody UserDto userDto){
        if (userDto.getUserName()==null || userDto.getPassword()==null || userDto
            .getVerifyCode()==null) {
        return ResultUtil.isNull();
        }
        try {
           Boolean result = userService.addUser(userDto);
        } catch (Exception e) {
            return ResultUtil.error();
        }
        return ResultUtil.success();
    }

    @DeleteMapping("delete")
    @ApiOperation("删除管理员")
    @ApiImplicitParam(name = "userName",value = "用户名",dataType = "string",required = true)
    public ResultJson delete(String userName) {
        if (userName==null) {
            return ResultUtil.isNull();
        }
        try {
            Boolean result = userService.deleteUserByuserName(userName);
        }catch (Exception e){
            return ResultUtil.error();
        }
        return ResultUtil.success() ;
    }

}

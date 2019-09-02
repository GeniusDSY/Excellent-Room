package cn.edu.cqupt.mislab.excellentroom.controller;

import cn.edu.cqupt.mislab.excellentroom.constant.ResultEnum;
import cn.edu.cqupt.mislab.excellentroom.domain.dto.UserDto;
import cn.edu.cqupt.mislab.excellentroom.domain.po.Result;
import cn.edu.cqupt.mislab.excellentroom.domain.po.UserPo;
import cn.edu.cqupt.mislab.excellentroom.service.UserService;
import cn.edu.cqupt.mislab.excellentroom.util.ResultUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.session.data.redis.config.annotation.web.http.EnableRedisHttpSession;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;


/**
 * @author HanSiyue
 */

@EnableRedisHttpSession
@RestController
@RequestMapping("userSystem")
@Api("登陆文档接口")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("login")
    @ApiOperation("用户登陆")
    public Result login(HttpServletRequest request, @RequestBody UserDto userDto) {
        try {
            if (userDto.getUserName() == null || userDto.getPassword() == null || userDto
                    .getVerifyStatus() == null) {
                return ResultUtil.isNull();
            }
            String verifyStatus = (String)request.getSession().getAttribute("verifyStatus");
            if (verifyStatus.equals(userDto.getVerifyStatus())){
                UserPo userPo = userService.login(userDto);
                request.getSession().setAttribute("userId",userPo.getId());
                return ResultUtil.success(userPo);
            }
        } catch (Exception e) {
            e.printStackTrace();
            return ResultUtil.error();
        }
        return ResultUtil.error();
    }


    @PostMapping("addUser")
    @ApiOperation("添加管理员")
    public Result addUser(@RequestBody UserDto userDto){
        try {
            if (userDto.getUserName()==null || userDto.getPassword()==null || userDto
                .getVerifyStatus()==null) {
            return ResultUtil.isNull();
        }
           Boolean result = userService.addUser(userDto);
            if (result){
                return ResultUtil.success();
            }
        } catch (Exception e) {
            e.printStackTrace();
            return ResultUtil.error();
        }
        return ResultUtil.error();
    }

    @DeleteMapping("deleteUser")
    @ApiOperation("删除管理员")
    @ApiImplicitParam(name = "userName",value = "用户名",dataType = "string",required = true)
    public Result deleteUserByuserName(String userName) {
        try {
            if (userName==null) {
                return ResultUtil.isNull();
            }
            Boolean result = userService.deleteUserByuserName(userName);
            if (result){
                return ResultUtil.success();
            }
        }catch (Exception e){
            e.printStackTrace();
            return ResultUtil.error();
        }
        return ResultUtil.error();
    }

}

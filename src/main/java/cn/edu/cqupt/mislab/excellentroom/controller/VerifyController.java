package cn.edu.cqupt.mislab.excellentroom.controller;

import cn.edu.cqupt.mislab.excellentroom.util.ResultUtil;
import cn.edu.cqupt.mislab.excellentroom.util.VerifyUtil;
import cn.edu.cqupt.mislab.excellentroom.domain.entity.ResultJson;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.session.data.redis.config.annotation.web.http.EnableRedisHttpSession;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import java.util.HashMap;
import java.util.Map;

@EnableRedisHttpSession
@RequestMapping("userSystem")
@Api("验证码接口")
@RestController
public class VerifyController {

    @PostMapping("createVerifyCode")
    @ApiOperation("生成验证码")
    public ResultJson verifycode(HttpSession session, HttpServletRequest request,
                                   HttpServletResponse response)throws Exception{
        try {
            Object[] objects = VerifyUtil.createImage();
            request.getSession().setAttribute("verifyCode",objects[0]);
            Map map = new HashMap<>();
            map.put("base64","data:image/png;base64,"+ VerifyUtil.getbase64(objects[1]));
            map.put("verifycode",objects[0]);
            return ResultUtil.success(map);
        }catch (Exception e){
            e.printStackTrace();
            return ResultUtil.error();
        }
    }
}

package cn.edu.cqupt.mislab.excellentroom.controller;

import cn.edu.cqupt.mislab.excellentroom.util.ResultUtil;
import cn.edu.cqupt.mislab.excellentroom.util.VerifyUtil;
import cn.edu.cqupt.mislab.excellentroom.domain.entity.ResultJson;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import sun.misc.BASE64Encoder;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.util.HashMap;
import java.util.Map;

@RequestMapping("userSystem")
@Api("验证码接口")
@RestController
public class VerifyController {

    @PostMapping("createVerifyCode")
    @ApiOperation("生成验证码")
    public ResultJson verifycode(HttpSession session, HttpServletRequest request,
                                   HttpServletResponse response)throws Exception{
        ResultJson resultJson = new ResultJson();
        //利用图片工具生成图片
        //第一个参数是生成的验证码，第二个参数是生成的图片
        Object[] objs = VerifyUtil.createImage();
        //将验证码存入Session
        session.setAttribute("verifyCode",objs[0]);
//        System.out.println("验证码："+session.getAttribute("imageCode"));


        //将图片转正base64
        BufferedImage image = (BufferedImage) objs[1];
        //转base64
        BASE64Encoder encoder = new BASE64Encoder();
        ByteArrayOutputStream baos = new ByteArrayOutputStream();//io流
        ImageIO.write(image, "png", baos);//写入流中
        byte[] bytes = baos.toByteArray();//转换成字节
        String png_base64 =  encoder.encodeBuffer(bytes).trim();//转换成base64串
        //删除 \r\n
        png_base64 = png_base64.replaceAll("\n", "").replaceAll("\r", "");

        Map map = new HashMap<>();
        map.put("base64","data:image/png;base64,"+ png_base64);
        map.put("verifycode",objs[0]);

        return ResultUtil.success(map);
    }
}

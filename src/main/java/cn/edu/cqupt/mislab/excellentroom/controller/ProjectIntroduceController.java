package cn.edu.cqupt.mislab.excellentroom.controller;

import cn.edu.cqupt.mislab.excellentroom.domain.entity.ClientWant;
import cn.edu.cqupt.mislab.excellentroom.domain.po.Result;
import cn.edu.cqupt.mislab.excellentroom.domain.po.ProjectIntroducePo;
import cn.edu.cqupt.mislab.excellentroom.service.ClientWantService;
import cn.edu.cqupt.mislab.excellentroom.service.ProjectIntroduceService;
import cn.edu.cqupt.mislab.excellentroom.util.FileUtil;
import cn.edu.cqupt.mislab.excellentroom.util.ResultUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import io.swagger.models.auth.In;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.session.data.redis.config.annotation.web.http.EnableRedisHttpSession;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @Author HanSiyue
 * @Date 2019/8/24 下午3:07
 */

@EnableRedisHttpSession
@RestController
@RequestMapping("projectIntroduceManagement")
@Api("项目介绍接口文档")
public class ProjectIntroduceController {

    @Autowired
    private ProjectIntroduceService projectIntroduceService;

    @Autowired
    private ClientWantService clientWantService;

    @Value("${filepath}")
    private String filePath;

    @PostMapping("updateBkground")
    @ApiOperation("修改项目介绍背景图片")
    public Result updateProjectIntroduceBkground(HttpServletRequest request, @RequestParam(value = "file") MultipartFile imageFile) {
        try {
            String projectId =(String) request.getSession().getAttribute("projectId");
            if (imageFile.isEmpty()||projectId==null) {
                return ResultUtil.isNull();
            }
            FileUtil.upload(imageFile, filePath);
            Boolean result = projectIntroduceService.updateProjectIntroduceBkgroundUrl(FileUtil.fileUrl(imageFile, filePath), projectId);
            if (result) {
                return ResultUtil.success(FileUtil.fileUrl(imageFile,filePath));
            }
        } catch (Exception e) {
            e.printStackTrace();
            return ResultUtil.error();
        }
        return ResultUtil.error();
    }

    @GetMapping("getBkground")
    @ApiOperation("展示项目介绍背景图片")
    public Result selectProjectIntroduceBkgroundById(HttpServletRequest request) {
        try {
            String projectId =(String) request.getSession().getAttribute("projectId");
            if (projectId == null) {
                return ResultUtil.isNull();
            }
            ProjectIntroducePo projectIntroducePo = projectIntroduceService.selectProjectIntroduceBkgroundById(projectId);
            return ResultUtil.success(projectIntroducePo.getProjectIntroduceBkgroundUrl());
        } catch (Exception e) {
            e.printStackTrace();
            return ResultUtil.error();
        }
    }

    @PostMapping("updateText")
    @ApiOperation("修改项目介绍文字描述")
    @ApiImplicitParam(name = "text", value = "文字描述", dataType = "string", required = true)
    public Result updateProjectIntroduceText(@RequestParam String text,HttpServletRequest request) {
        try {
            String projectId =(String) request.getSession().getAttribute("projectId");
            if (text==null|| projectId==null) {
                return ResultUtil.isNull();
            }
            Boolean result = projectIntroduceService.updateProjectIntroduceText(text, projectId);
            if (result) {
                return ResultUtil.success();
            }
        } catch (Exception e) {
            e.printStackTrace();
            return ResultUtil.error();
        }
        return ResultUtil.error();
    }

    @GetMapping("getText")
    @ApiOperation("展示项目介绍文字描述")
    public Result selectProjectIntroduceTextById(HttpServletRequest request) {
        try {
            String projectId =(String) request.getSession().getAttribute("projectId");
            if (projectId == null) {
                return ResultUtil.isNull();
            }
            ProjectIntroducePo projectIntroducePo = projectIntroduceService.selectProjectIntroduceTextById(projectId);
            return ResultUtil.success(projectIntroducePo.getProjectIntroduceText());
        } catch (Exception e) {
            e.printStackTrace();
            return ResultUtil.error();
        }
    }

    @PostMapping("updateTitel")
    @ApiOperation("修改项目介绍标题")
    @ApiImplicitParam(name = "titel", value = "标题", dataType = "string", required = true)
    public Result updateProjectIntroduceTitel(@RequestParam String titel,HttpServletRequest request) {
        try {
            String projectId =(String) request.getSession().getAttribute("projectId");
            if (titel==null||projectId==null) {
                return ResultUtil.isNull();
            }
            Boolean result = projectIntroduceService.updateProjectIntroduceTitle(titel, projectId);
            if (result) {
                return ResultUtil.success();
            }
        } catch (Exception e) {
            e.printStackTrace();
            return ResultUtil.error();
        }
        return ResultUtil.error();
    }

    @GetMapping("getTitel")
    @ApiOperation("展示项目介绍标题")
    public Result selectProjectIntroduceTitelById(HttpServletRequest request) {
        try {
            String projectId =(String) request.getSession().getAttribute("projectId");
            if (projectId == null) {
                return ResultUtil.isNull();
            }
            ProjectIntroducePo projectIntroducePo = projectIntroduceService.selectProjectIntroduceTitleById(projectId);
            return ResultUtil.success(projectIntroducePo.getProjectIntroduceTitle());
        } catch (Exception e) {
            e.printStackTrace();
            return ResultUtil.error();
        }
    }

    @PostMapping("addClientWant")
    @ApiOperation("我有意向填写")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "tel", value = "电话", dataType = "string", required = true),
            @ApiImplicitParam(name = "price", value = "意向价格", dataType = "integer"),
            @ApiImplicitParam(name = "type", value = "户型", dataType = "integer")
    })
    public Result addClientWant(HttpServletRequest request, String tel, Integer price, Integer type){
        try {
            String projectId =(String) request.getSession().getAttribute("projectId");
            if (projectId == null||tel==null) {
                return ResultUtil.isNull();
            }
            Boolean result = clientWantService.addClientWant(projectId,tel,price,type);
            if (result){
                return ResultUtil.success();
            }else {
                return ResultUtil.error();
            }
        }catch (Exception e){
            e.printStackTrace();
            return ResultUtil.error();
        }
    }

    @GetMapping("getClientWant")
    @ApiOperation("展示所有意向")
    public Result findAll(HttpServletRequest request){
        try {
            String projectId =(String) request.getSession().getAttribute("projectId");
            if (projectId == null) {
                return ResultUtil.isNull();
            }
            List<ClientWant> clientWants = clientWantService.findAll(projectId);
            return ResultUtil.success(clientWants);
        }catch (Exception e){
            e.printStackTrace();
            return ResultUtil.error();
        }
    }
}

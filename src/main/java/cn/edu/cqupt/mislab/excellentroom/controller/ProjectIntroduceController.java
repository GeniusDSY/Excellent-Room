package cn.edu.cqupt.mislab.excellentroom.controller;

import cn.edu.cqupt.mislab.excellentroom.domain.entity.ClientWant;
import cn.edu.cqupt.mislab.excellentroom.domain.entity.ResultJson;
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
    @ApiImplicitParam(name = "imageFile", value = "背景图片", paramType = "form", dataType = "file", required = true)
    public ResultJson updateProjectIntroduceBkground(HttpServletRequest request, @RequestParam MultipartFile imageFile) {
        try {
            if (imageFile.isEmpty()) {
                return ResultUtil.isNull();
            }
            String projectId =(String) request.getSession().getAttribute("projectId");
            FileUtil.upload(imageFile, filePath);
            Boolean result = projectIntroduceService.updateProjectIntroduceBkgroundUrl(FileUtil.fileUrl(imageFile, filePath), projectId);
            if (result) {
                return ResultUtil.success();
            }
        } catch (Exception e) {
            e.printStackTrace();
            return ResultUtil.error();
        }
        return ResultUtil.error();
    }

    @GetMapping("getBkground")
    @ApiOperation("展示项目介绍背景图片")
    public ResultJson selectProjectIntroduceBkgroundById(HttpServletRequest request) {
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
    public ResultJson updateProjectIntroduceText(@RequestParam String text,HttpServletRequest request) {
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
    public ResultJson selectProjectIntroduceTextById(HttpServletRequest request) {
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
    public ResultJson updateProjectIntroduceTitel(@RequestParam String titel,HttpServletRequest request) {
        try {
            String projectId =(String) request.getSession().getAttribute("projectId");
            if (titel==null||projectId==null) {
                return ResultUtil.isNull();
            }
            Boolean result = projectIntroduceService.updateProjectIntroduceTitel(titel, projectId);
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
    public ResultJson selectProjectIntroduceTitelById(HttpServletRequest request) {
        try {
            String projectId =(String) request.getSession().getAttribute("projectId");
            if (projectId == null) {
                return ResultUtil.isNull();
            }
            ProjectIntroducePo projectIntroducePo = projectIntroduceService.selectprojectIntroduceTitelById(projectId);
            return ResultUtil.success(projectIntroducePo.getProjectIntroduceTitel());
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
            @ApiImplicitParam(name = "type", value = "户型", dataType = "integer", required = true)
    })
    public ResultJson addClientWant(HttpServletRequest request, String tel, Integer price, Integer type){
        try {
            String projectId =(String) request.getSession().getAttribute("projectId");
            if (projectId == null) {
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
    public ResultJson findAll(HttpServletRequest request){
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

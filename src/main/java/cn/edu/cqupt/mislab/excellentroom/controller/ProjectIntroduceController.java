package cn.edu.cqupt.mislab.excellentroom.controller;

import cn.edu.cqupt.mislab.excellentroom.domain.entity.ResultJson;
import cn.edu.cqupt.mislab.excellentroom.domain.po.ProjectIntroducePo;
import cn.edu.cqupt.mislab.excellentroom.service.ProjectIntroduceService;
import cn.edu.cqupt.mislab.excellentroom.util.FileUtil;
import cn.edu.cqupt.mislab.excellentroom.util.ResultUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

/**
 * @Author HanSiyue
 * @Date 2019/8/24 下午3:07
 */
@RestController
@RequestMapping("projectIntroduceManagement")
@Api("项目介绍接口文档")
public class ProjectIntroduceController {

    @Autowired
    private ProjectIntroduceService projectIntroduceService;
    @Value("${filepath}")
    private String filePath;

    @PostMapping("updateProjectIntroduceBkground")
    @ApiOperation("修改项目介绍背景图片")
    @ApiImplicitParam(name = "imageFile", value = "背景图片", paramType = "form", dataType = "file", required = true)
    public ResultJson updateProjectIntroduceBkground(@RequestParam MultipartFile imageFile, @RequestParam String projecId) {
        try {
            if (imageFile.isEmpty()) {
                return ResultUtil.isNull();
            }
            FileUtil.upload(imageFile, filePath);
            Boolean result = projectIntroduceService.updateProjectIntroduceBkgroundUrl(FileUtil.fileUrl(imageFile, filePath), projecId);
            if (result) {
                return ResultUtil.success();
            }
        } catch (Exception e) {
            e.printStackTrace();
            return ResultUtil.error();
        }
        return ResultUtil.error();
    }

    @GetMapping("displayProjectIntroduceBkground")
    @ApiOperation("展示项目介绍背景图片")
    @ApiImplicitParam(name = "projectId", value = "项目ID", dataType = "string", required = true)
    public ResultJson selectProjectIntroduceBkgroundById(@RequestParam String projectId) {
        try {
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

    @PostMapping("updateProjectIntroduceText")
    @ApiOperation("修改项目介绍文字描述")
    @ApiImplicitParam(name = "text", value = "文字描述", dataType = "string", required = true)
    public ResultJson updateProjectIntroduceText(@RequestParam String text, @RequestParam String projecId) {
        try {
            if (text==null||projecId==null) {
                return ResultUtil.isNull();
            }
            Boolean result = projectIntroduceService.updateProjectIntroduceText(text, projecId);
            if (result) {
                return ResultUtil.success();
            }
        } catch (Exception e) {
            e.printStackTrace();
            return ResultUtil.error();
        }
        return ResultUtil.error();
    }

    @GetMapping("selectProjectIntroduceTextById")
    @ApiOperation("展示项目介绍文字描述")
    @ApiImplicitParam(name = "projectId", value = "项目ID", dataType = "string", required = true)
    public ResultJson selectProjectIntroduceTextById(@RequestParam String projectId) {
        try {
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

    @PostMapping("updateProjectIntroduceTitel")
    @ApiOperation("修改项目介绍标题")
    @ApiImplicitParam(name = "titel", value = "标题", dataType = "string", required = true)
    public ResultJson updateProjectIntroduceTitel(@RequestParam String titel, @RequestParam String projecId) {
        try {
            if (titel==null||projecId==null) {
                return ResultUtil.isNull();
            }
            Boolean result = projectIntroduceService.updateProjectIntroduceTitel(titel, projecId);
            if (result) {
                return ResultUtil.success();
            }
        } catch (Exception e) {
            e.printStackTrace();
            return ResultUtil.error();
        }
        return ResultUtil.error();
    }

    @GetMapping("selecProjectIntroduceTitelById")
    @ApiOperation("展示项目介绍标题")
    @ApiImplicitParam(name = "projectId", value = "项目ID", dataType = "string", required = true)
    public ResultJson selectProjectIntroduceTitelById(@RequestParam String projectId) {
        try {
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
}

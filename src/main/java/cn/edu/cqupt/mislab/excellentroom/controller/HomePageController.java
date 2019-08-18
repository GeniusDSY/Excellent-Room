package cn.edu.cqupt.mislab.excellentroom.controller;

import cn.edu.cqupt.mislab.excellentroom.util.FileUtil;
import cn.edu.cqupt.mislab.excellentroom.domain.po.HomePagePo;
import cn.edu.cqupt.mislab.excellentroom.util.ResultUtil;
import cn.edu.cqupt.mislab.excellentroom.domain.entity.ResultJson;
import cn.edu.cqupt.mislab.excellentroom.service.HomePageService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;

/**
 * @Author HanSiyue
 * @Date 2019/8/14 下午11:37
 */

@RestController
@RequestMapping("homePageManagement")
@Api("首页管理接口文档")
public class HomePageController {
    @Autowired
    private HomePageService homePageService;
    @Value("${filepath}")
    private String filePath;

    @PostMapping("updateHomePageBkground")
    @ApiOperation("修改首页背景图片")
    @ApiImplicitParam(name = "imageFile", value = "背景图片", paramType = "form", dataType = "file", required = true)
    public ResultJson updateHomePageBkground(@RequestParam MultipartFile imageFile, @RequestParam String projecId){
        try {
            if (imageFile.isEmpty()){
                return ResultUtil.isNull();
            }
            FileUtil.upload(imageFile,filePath);
            Boolean result = homePageService.updateHomePageBkground(FileUtil.fileUrl(imageFile,filePath),projecId);
            if (result){
                return ResultUtil.success();
            }
        } catch (Exception e) {
            return ResultUtil.error();
        }
        return null;
    }

    @PostMapping("updateHomePageLogo")
    @ApiOperation("修改首页Logo")
    @ApiImplicitParam(name = "imageFile",value = "首页Logo图片",paramType = "form",dataType = "file",required = true)
    public ResultJson updateHomePageLogo(@RequestParam MultipartFile imageFile, @RequestParam String projecId){
        try {
            if (imageFile.isEmpty()){
                return ResultUtil.isNull();
            }
            FileUtil.upload(imageFile,filePath);
            Boolean result = homePageService.updateHomePageLogo(FileUtil.fileUrl(imageFile,filePath), projecId);
            if (result){
                return ResultUtil.success();
            }
        } catch (Exception e) {
            return ResultUtil.error();
        }
        return null;
    }

    @PostMapping("updateHomePageIcon")
    @ApiOperation("修改首页Icon")
    @ApiImplicitParam(name = "imageFile",value = "首页Icon图片",dataType = "form",required = true)
    public ResultJson updateHomePageIcon(@RequestParam MultipartFile imageFile, @RequestParam String projectId){
        try {
            if (imageFile.isEmpty()){
                return ResultUtil.isNull();
            }
            FileUtil.upload(imageFile,filePath);
            Boolean result = homePageService.updateHomePageIcon(FileUtil.fileUrl(imageFile,filePath),projectId);
            if (result){
                return ResultUtil.success();
            }
        } catch (Exception e) {
            return ResultUtil.error();
        }
        return null;
    }
}

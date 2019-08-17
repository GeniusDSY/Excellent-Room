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
    private String filePath = "/Users/mac/picture/pic";

    @PostMapping("updateHomePageBkground")
    @ApiOperation("修改首页背景图片")
    @ApiImplicitParam(name = "imageFile", value = "背景图片", paramType = "form", dataType = "file", required = true)
    public ResultJson updateHomePageBkground(@RequestParam MultipartFile imageFile, @RequestParam String projecId){
        try {
            if (imageFile.isEmpty()){
            return ResultUtil.isNull();
            }
            String fileName = imageFile.getOriginalFilename();
            FileUtil.upload(imageFile,filePath,fileName);
            String homePageBkgroundUrl = FileUtil.fileUrl(imageFile,filePath,fileName);
            HomePagePo homePagePo = homePageService.updateHomePageBkground(homePageBkgroundUrl,projecId);
        } catch (Exception e) {
            return ResultUtil.error();
        }
        return ResultUtil.success();
    }

    @PostMapping("updateHomePageLogo")
    @ApiOperation("修改首页Logo")
    @ApiImplicitParam(name = "imageFile",value = "首页Logo图片",paramType = "form",dataType = "file",required = true)
    public ResultJson updateHomePageLogo(@RequestParam MultipartFile imageFile, @RequestParam String projecId){
        try {
            if (imageFile.isEmpty()){
                return ResultUtil.isNull();
            }
            String fileName = imageFile.getOriginalFilename();
            FileUtil.upload(imageFile,filePath,fileName);
            String homePageLogoUrl = FileUtil.fileUrl(imageFile,filePath,fileName);
            HomePagePo homePagePo = homePageService.updateHomePageLogo(homePageLogoUrl, projecId);
        } catch (Exception e) {
            return ResultUtil.error();
        }
        return ResultUtil.success();
    }

    @PostMapping("updateHomePageIcon")
    @ApiOperation("修改首页Icon")
    @ApiImplicitParam(name = "imageFile",value = "首页Icon图片",dataType = "form",required = true)
    public ResultJson updateHomePageIcon(@RequestParam MultipartFile imageFile, @RequestParam String projectId){
        try {
            if (imageFile.isEmpty()){
                return ResultUtil.isNull();
            }
            String fileName = imageFile.getOriginalFilename();
            FileUtil.upload(imageFile,filePath,fileName);
            String homePageIconUrl = FileUtil.fileUrl(imageFile,filePath,fileName);
            HomePagePo homePagePo = homePageService.updateHomePageIcon(homePageIconUrl,projectId);
        } catch (Exception e) {
            return ResultUtil.error();
        }
        return ResultUtil.success();
    }
}

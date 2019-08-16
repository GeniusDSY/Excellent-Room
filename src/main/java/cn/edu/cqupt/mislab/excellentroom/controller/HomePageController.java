package cn.edu.cqupt.mislab.excellentroom.controller;

import cn.edu.cqupt.mislab.excellentroom.util.ImageFileUtil;
import cn.edu.cqupt.mislab.excellentroom.domain.po.HomePagePo;
import cn.edu.cqupt.mislab.excellentroom.util.ResultUtil;
import cn.edu.cqupt.mislab.excellentroom.domain.entity.ResultJson;
import cn.edu.cqupt.mislab.excellentroom.service.HomePageService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
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

    @PostMapping("updateHomePageBkground")
    @ApiOperation("修改首页背景图片")
    @ApiImplicitParam(name = "imageFile",value = "背景图片",paramType = "form",dataType = "file",required = true)
    public ResultJson updateHomePageBkground(@RequestParam MultipartFile imageFile){
        String homePageBkgroundUrl = ImageFileUtil.storageImage(imageFile);
        if (homePageBkgroundUrl == null){
            return ResultUtil.isNull();
        }
        try {
            HomePagePo homePagePo = homePageService.updateHomePageBkground(homePageBkgroundUrl);
        } catch (Exception e) {
            return ResultUtil.error();
        }
        return ResultUtil.success();
    }

    @PostMapping("updateHomePageLogo")
    @ApiOperation("修改首页Logo")
    @ApiImplicitParam(name = "imageFile",value = "首页Logo图片",paramType = "form",dataType = "file",required = true)
    public ResultJson updateHomePageLogo(@RequestParam MultipartFile imageFile){
        String homePageLogoUrl = ImageFileUtil.storageImage(imageFile);
        if (homePageLogoUrl == null){
            return ResultUtil.isNull();
        }
        try {
            HomePagePo homePagePo = homePageService.updateHomePageLogo(homePageLogoUrl);
        } catch (Exception e) {
            return ResultUtil.error();
        }
        return ResultUtil.success();
    }

    @PostMapping("updateHomePageIcon")
    @ApiOperation("修改首页Icon")
    @ApiImplicitParam(name = "imageFile",value = "首页Icon图片",dataType = "form",required = true)
    public ResultJson updateHomePageIcon(@RequestParam MultipartFile imageFile){
        String homePageIconUrl = ImageFileUtil.storageImage(imageFile);
        if (homePageIconUrl == null){
            return ResultUtil.isNull();
        }
        try {
            HomePagePo homePagePo = homePageService.updateHomePageIcon(homePageIconUrl);
        } catch (Exception e) {
            return ResultUtil.error();
        }
        return ResultUtil.success();
    }
}

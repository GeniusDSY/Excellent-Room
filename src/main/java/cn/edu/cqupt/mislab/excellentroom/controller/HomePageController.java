package cn.edu.cqupt.mislab.excellentroom.controller;

import cn.edu.cqupt.mislab.excellentroom.util.FileUtil;
import cn.edu.cqupt.mislab.excellentroom.domain.po.HomePagePo;
import cn.edu.cqupt.mislab.excellentroom.util.ResultUtil;
import cn.edu.cqupt.mislab.excellentroom.domain.entity.ResultJson;
import cn.edu.cqupt.mislab.excellentroom.service.HomePageService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.session.data.redis.config.annotation.web.http.EnableRedisHttpSession;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;


/**
 * @Author HanSiyue
 * @Date 2019/8/14 下午11:37
 */

@EnableRedisHttpSession
@RestController
@RequestMapping("homePageManagement")
@Api("首页管理接口文档")
public class HomePageController {
    @Autowired
    private HomePageService homePageService;
    @Value("${filepath}")
    private String filePath;

    @PostMapping("updateBkground")
    @ApiOperation("修改首页背景图片")
    @ApiImplicitParam(name = "imageFile", value = "背景图片", paramType = "form", dataType = "file", required = true)
    public ResultJson updateHomePageBkground(HttpServletRequest request, @RequestParam MultipartFile imageFile){
        try {
            String projectId =(String) request.getSession().getAttribute("projectId");
            if (imageFile.isEmpty()||projectId==null){
                return ResultUtil.isNull();
            }
            FileUtil.upload(imageFile,filePath);
            Boolean result = homePageService.updateHomePageBkground(FileUtil.fileUrl(imageFile,filePath),projectId);

            if (result){
                return ResultUtil.success();
            }
        } catch (Exception e) {
            e.printStackTrace();
            return ResultUtil.error();
        }
        return ResultUtil.error();
    }

    @PostMapping("updateLogo")
    @ApiOperation("修改首页Logo")
    @ApiImplicitParam(name = "imageFile",value = "首页Logo图片",paramType = "form",dataType = "file",required = true)
    public ResultJson updateHomePageLogo(HttpServletRequest request,@RequestParam MultipartFile imageFile){
        try {
            String projectId =(String) request.getSession().getAttribute("projectId");
            if (imageFile.isEmpty()||projectId==null){
                return ResultUtil.isNull();
            }
            FileUtil.upload(imageFile,filePath);
            Boolean result = homePageService.updateHomePageLogo(FileUtil.fileUrl(imageFile,filePath), projectId);
            if (result){
                return ResultUtil.success();
            }
        } catch (Exception e) {
            e.printStackTrace();
            return ResultUtil.error();
        }
        return ResultUtil.error();
    }

    @PostMapping("updateIcon")
    @ApiOperation("修改首页Icon")
    @ApiImplicitParam(name = "imageFile",value = "首页Icon图片",dataType = "form",required = true)
    public ResultJson updateHomePageIcon(HttpServletRequest request,@RequestParam MultipartFile imageFile){
        try {
            String projectId =(String) request.getSession().getAttribute("projectId");
            if (imageFile.isEmpty()||projectId==null){
                return ResultUtil.isNull();
            }
            FileUtil.upload(imageFile,filePath);
            Boolean result = homePageService.updateHomePageIcon(FileUtil.fileUrl(imageFile,filePath),projectId);
            if (result){
                return ResultUtil.success();
            }
        } catch (Exception e) {
            e.printStackTrace();
            return ResultUtil.error();
        }
        return ResultUtil.error();
    }

    @GetMapping("getBkground")
    @ApiOperation("展示首页背景图片")
    public ResultJson selectHomePageBkgroundById(HttpServletRequest request){
        try {
            String projectId =(String) request.getSession().getAttribute("projectId");
            if (projectId == null){
                return ResultUtil.isNull();
            }
            HomePagePo homePagePo = homePageService.selectHomePageBkgroundById(projectId);
            return ResultUtil.success(homePagePo.getHomePageBkgroundUrl());
        }catch (Exception e){
            e.printStackTrace();
            return ResultUtil.error();
        }
    }

    @GetMapping("getLogo")
    @ApiOperation("展示首页Logo")
    public ResultJson selectHomePageLogoById(HttpServletRequest request){
        try {
            String projectId =(String) request.getSession().getAttribute("projectId");
            if (projectId == null){
                return ResultUtil.isNull();
            }
            HomePagePo homePagePo = homePageService.selectHomePageLogoById(projectId);
            return ResultUtil.success(homePagePo.getHomePageLogoUrl());
        }catch (Exception e){
            e.printStackTrace();
            return ResultUtil.error();
        }
    }

    @GetMapping("getIcon")
    @ApiOperation("展示首页Icon")
    public ResultJson selectHomePageIconById(HttpServletRequest request,@RequestParam String id){
        try {
            String projectId =(String) request.getSession().getAttribute("projectId");
            if (projectId == null){
                return ResultUtil.isNull();
            }
            HomePagePo homePagePo = homePageService.selectHomePageIconById(projectId,id);
            return ResultUtil.success(homePagePo.getHomePageIconUrl());
        }catch (Exception e){
            e.printStackTrace();
            return ResultUtil.error();
        }
    }
}

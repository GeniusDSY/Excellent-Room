package cn.edu.cqupt.mislab.excellentroom.controller;

import cn.edu.cqupt.mislab.excellentroom.domain.po.Result;
import cn.edu.cqupt.mislab.excellentroom.exception.MyException;
import cn.edu.cqupt.mislab.excellentroom.service.ICompanyService;
import cn.edu.cqupt.mislab.excellentroom.service.ICultureService;
import cn.edu.cqupt.mislab.excellentroom.util.GetUtil;
import cn.edu.cqupt.mislab.excellentroom.util.UploadUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;

/**
 * @program: Excellent-Room-sl-dev
 * @description: 企业文化
 * @author: 宋丽
 * @create: 2019-08-28 04:01
 **/
@Api("企业文化")
@RestController
@RequestMapping("/Culture")
public class BrandCultureController {
    @Autowired
    private ICultureService iCultureService;

    @ApiOperation(value = "修改企业文化背景（无删除）")
    @RequestMapping(value = "/updateBkground",method = RequestMethod.POST)
    public Result updateBkground(@RequestParam(value = "file",required = false) MultipartFile file, HttpServletRequest request){
        String projectId = GetUtil.getProjectId(request);
        String pic = null;
        try {
            pic = UploadUtil.pic(file,request);
        } catch (MyException e) {
            e.printStackTrace();
        }
        return iCultureService.updateCultureBkground(projectId,pic);
    }

    @ApiOperation(value = "查找企业文化背景（无删除）")
    @RequestMapping(value = "/searchBkground",method = RequestMethod.GET)
    public Result searchBkground(HttpServletRequest request){
        String projectId = GetUtil.getProjectId(request);
        return iCultureService.searchCultureBkground(projectId);
    }

    @ApiOperation(value = "修改企业文化背景（无删除）")
    @RequestMapping(value = "/updatePic",method = RequestMethod.POST)
    public Result updatePic(@RequestParam(value = "file",required = false) MultipartFile file, HttpServletRequest request){
        String projectId = GetUtil.getProjectId(request);
        String pic = null;
        try {
            pic = UploadUtil.pic(file,request);
        } catch (MyException e) {
            e.printStackTrace();
        }
        return iCultureService.updateCulturePic(projectId,pic);
    }

    @ApiOperation(value = "查找企业文化图片（无删除）")
    @RequestMapping(value = "/searchPic",method = RequestMethod.GET)
    public Result searchPic(HttpServletRequest request){
        String projectId = GetUtil.getProjectId(request);
        return iCultureService.searchCulturePic(projectId);
    }

    @ApiOperation(value = "查找企业文化（无修改）")
    @RequestMapping(value = "/searchCulture",method = RequestMethod.GET)
    public Result searchCulture(HttpServletRequest request){
        String projectId = GetUtil.getProjectId(request);
        return iCultureService.searchCulture(projectId);
    }

    @ApiOperation(value = "删除指定企业文化")
    @RequestMapping(value = "/deleteCulture",method = RequestMethod.POST)
    public Result deleteCulture(@Param("title")String title,@Param("text")String text, HttpServletRequest request){
        String projectId = GetUtil.getProjectId(request);
        return iCultureService.deleteCulture(projectId,title,text);
    }

    @ApiOperation(value = "新增企业简介的轮播背景图片（无更新）")
    @RequestMapping(value = "/addCulture",method = RequestMethod.POST)
    public Result addCulture(@Param("title")String title,@Param("text")String text,HttpServletRequest request){
        String projectId = GetUtil.getProjectId(request);
        return iCultureService.addCulture(projectId,title,text);
    }











}

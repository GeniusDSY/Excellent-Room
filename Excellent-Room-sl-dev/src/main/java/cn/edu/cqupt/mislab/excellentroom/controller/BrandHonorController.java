package cn.edu.cqupt.mislab.excellentroom.controller;

import cn.edu.cqupt.mislab.excellentroom.domain.po.Result;
import cn.edu.cqupt.mislab.excellentroom.exception.MyException;
import cn.edu.cqupt.mislab.excellentroom.service.IHonorService;
import cn.edu.cqupt.mislab.excellentroom.util.GetUtil;
import cn.edu.cqupt.mislab.excellentroom.util.UploadUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;

/**
 * @program: Excellent-Room-sl-dev
 * @description: 品牌荣誉
 * @author: 宋丽
 * @create: 2019-08-28 03:59
 **/
@Api("品牌荣誉")
@RestController
@RequestMapping("/Honor")
public class BrandHonorController {
    @Autowired
    private IHonorService iHonorService;

    @ApiOperation(value = "修改品牌荣誉背景图片（无删除）")
    @RequestMapping(value = "/updateBkground",method = RequestMethod.POST)
    public Result updateBkground(@RequestParam(value = "file",required = false) MultipartFile file, HttpServletRequest request){
        String projectId = GetUtil.getProjectId(request);
        String pic = null;
        try {
            pic = UploadUtil.pic(file,request);
        } catch (MyException e) {
            e.printStackTrace();
        }
        return iHonorService.updateHonorBkground(projectId,pic);
    }

    @ApiOperation(value = "查找品牌荣誉背景图片")
    @RequestMapping(value = "/searchBkground",method = RequestMethod.GET)
    public Result searchBkground(HttpServletRequest request){
        String projectId = GetUtil.getProjectId(request);
        return iHonorService.searchHonorBkground(projectId);
    }

    @ApiOperation(value = "查找品牌荣誉轮播图片（无更新）")
    @RequestMapping(value = "/searchHonorPic",method = RequestMethod.GET)
    public Result searchHonorPic(HttpServletRequest request){
        String projectId = GetUtil.getProjectId(request);
        return iHonorService.searchHonorPic(projectId);
    }

    @ApiOperation(value = "查找品牌荣誉文本（无更新）")
    @RequestMapping(value = "/searchHonorText",method = RequestMethod.GET)
    public Result searchHonorText(HttpServletRequest request){
        String projectId = GetUtil.getProjectId(request);
        return iHonorService.searchHonorText(projectId);
    }

    @ApiOperation(value = "新增品牌荣誉轮播图片")
    @RequestMapping(value = "/addPic",method = RequestMethod.POST)
    public Result addPic(@RequestParam(value = "file",required = false)MultipartFile file,HttpServletRequest request){
        String projectId = GetUtil.getProjectId(request);
        String pic = null;
        try {
            pic = UploadUtil.pic(file,request);
        } catch (MyException e) {
            e.printStackTrace();
        }
        return iHonorService.addHonorPic(projectId,pic);
    }

    @ApiOperation(value = "新增品牌荣誉文本")
    @RequestMapping(value = "/addText",method = RequestMethod.POST)
    public Result addText(@Param("text")String text,HttpServletRequest request){
        String projectId = GetUtil.getProjectId(request);
        return iHonorService.addHonorText(projectId,text);
    }

    @ApiOperation(value = "删除指定品牌荣誉轮播图片")
    @RequestMapping(value = "/deletePic",method = RequestMethod.POST)
    public Result deletePic(@RequestParam(value = "file",required = false)MultipartFile file,HttpServletRequest request){
        String projectId = GetUtil.getProjectId(request);
        String pic = null;
        try {
            pic = UploadUtil.pic(file,request);
        } catch (MyException e) {
            e.printStackTrace();
        }
        return iHonorService.deleteHonorPic(projectId,pic);
    }

    @ApiOperation(value = "删除指定品牌荣誉文本")
    @RequestMapping(value = "/deleteText",method = RequestMethod.POST)
    public Result deleteText(@Param("text")String text,HttpServletRequest request){
        String projectId = GetUtil.getProjectId(request);
        return iHonorService.deleteHonorText(projectId,text);
    }
}

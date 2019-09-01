package cn.edu.cqupt.mislab.excellentroom.controller;
import cn.edu.cqupt.mislab.excellentroom.domain.po.Result;
import cn.edu.cqupt.mislab.excellentroom.exception.MyException;
import cn.edu.cqupt.mislab.excellentroom.service.ICompanyService;
import cn.edu.cqupt.mislab.excellentroom.util.GetUtil;
import cn.edu.cqupt.mislab.excellentroom.util.UploadUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import javax.servlet.http.HttpServletRequest;

/**
 * @program: Excellent-Room-sl-dev
 * @description: 企业简介
 * @author: 宋丽
 * @create: 2019-08-16 06:59
 **/
@Api("企业简介")
@RestController
@RequestMapping("/Company")
public class BrandCompanyController {
    @Autowired
    private ICompanyService iCompanyService;

    /**
     * 修改企业简介的视频链接
     * @param video
     * @param request
     * @return
     */
    @ApiOperation(value = "修改企业简介的视频链接")
    @RequestMapping(value = "/updateVideo",method = RequestMethod.POST)
    public Result updateVideo(@RequestParam(value = "file",required = false)MultipartFile video,HttpServletRequest request){
        String projectId = GetUtil.getProjectId(request);
        String vid = "";
        try {
            vid = UploadUtil.video(video, request);
        } catch (MyException e) {
            e.printStackTrace();
        }
        return iCompanyService.updateCompanyProfilesVideo(projectId,vid);
    }

    /**
     * 查询企业简介的视频链接
     * @param request
     * @return
     */
    @ApiOperation(value = "查询企业简介的视频链接")
    @RequestMapping(value = "/searchVideo",method = RequestMethod.GET)
    public Result searchVideo(HttpServletRequest request){
        String projectId = GetUtil.getProjectId(request);
        return iCompanyService.searchCompanyProfilesVideo(projectId);
    }

    /**
     * 修改企业简介的介绍文本（无删除）
     * @param text
     * @param request
     * @return
     */
    @ApiOperation(value = "修改企业简介的介绍文本（无删除）")
    @RequestMapping(value = "/updateText",method = RequestMethod.POST)
    public Result updateText(@Param(value = "string")String text,HttpServletRequest request){
        String projectId = GetUtil.getProjectId(request);
        return iCompanyService.updateCompanyProfilesText(projectId,text);
    }

    /**
     * 查询企业简介的介绍文本
     * @param request
     * @return
     */
    @ApiOperation(value = "查询企业简介的介绍文本")
    @RequestMapping(value = "/searchText",method = RequestMethod.GET)
    public Result searchText(HttpServletRequest request){
        String projectId = GetUtil.getProjectId(request);
        return iCompanyService.searchCompanyProfilesText(projectId);
    }

    /**
     * 新增企业简介的轮播背景图片（无更新）
     * @param file
     * @param request
     * @return
     */
    @ApiOperation(value = "新增企业简介的轮播背景图片（无更新）")
    @RequestMapping(value = "/addPic",method = RequestMethod.POST)
    public Result addPic(@RequestParam(value = "file",required = false)MultipartFile file,HttpServletRequest request){
        String projectId = GetUtil.getProjectId(request);
        String pic = null;
        try {
            pic = UploadUtil.pic(file,request);
        } catch (MyException e) {
            e.printStackTrace();
        }
        return iCompanyService.addCompanyProfilesPic(projectId,pic);
    }

    /**
     * 查询企业简介的轮播背景图片
     * @param request
     * @return
     */
    @ApiOperation(value = "查询企业简介的轮播背景图片")
    @RequestMapping(value = "/searchPic",method = RequestMethod.GET)
    public Result searchPic(HttpServletRequest request){
        String projectId = GetUtil.getProjectId(request);
        return iCompanyService.searchCompanyProfilesPic(projectId);
    }

    /**
     * 删除企业简介的轮播背景图片（单张）
     * @param file
     * @param request
     * @return
     */
    @ApiOperation(value = "删除企业简介的轮播背景图片（单张）")
    @RequestMapping(value = "/deletePic",method = RequestMethod.POST)
    public Result deletePic(@RequestParam(value = "file",required = false)MultipartFile file,HttpServletRequest request){
        String projectId = GetUtil.getProjectId(request);
        String pic = null;
        try {
            pic = UploadUtil.pic(file,request);
        } catch (MyException e) {
            e.printStackTrace();
        }
        return iCompanyService.deleteCompanyProfilesPic(projectId,pic);
    }
}

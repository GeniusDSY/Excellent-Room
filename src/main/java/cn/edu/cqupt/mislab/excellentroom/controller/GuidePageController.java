package cn.edu.cqupt.mislab.excellentroom.controller;
import cn.edu.cqupt.mislab.excellentroom.domain.po.Result;
import cn.edu.cqupt.mislab.excellentroom.exception.MyException;
import cn.edu.cqupt.mislab.excellentroom.service.IGuidePageService;
import cn.edu.cqupt.mislab.excellentroom.util.GetUtil;
import cn.edu.cqupt.mislab.excellentroom.util.ServiceUtil;
import cn.edu.cqupt.mislab.excellentroom.util.UploadUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;

/**
 * @program: Excellent-Room-sl-dev
 * @description: 引导页
 * @author: 宋丽
 * @create: 2019-08-30 05:19
 **/
@Api("企业简介")
@RestController
@RequestMapping("/Company")
public class GuidePageController {
    @Autowired
    private IGuidePageService iGuidePageService;

    @ApiOperation(value = "修改引导页背景图片（无删除）")
    @RequestMapping(value = "/updateBkground",method = RequestMethod.POST)
    public Result updateBkground(@RequestParam(value = "file",required = false) MultipartFile file, HttpServletRequest request){
        String projectId = GetUtil.getProjectId(request);
        String pic = null;
        try {
            pic = UploadUtil.pic(file,request);
        } catch (MyException e) {
            e.printStackTrace();
        }
        return iGuidePageService.updateGuidePageBkground(projectId,pic);
    }

    @ApiOperation(value = "查找引导页背景图片")
    @RequestMapping(value = "/searchBkground",method = RequestMethod.GET)
    public Result searchBkground(HttpServletRequest request){
        String projectId = GetUtil.getProjectId(request);
        return iGuidePageService.searchGuidePageBkground(projectId);
    }

    @ApiOperation(value = "修改引导页logo（无删除）")
    @RequestMapping(value = "/updateLogo",method = RequestMethod.POST)
    public Result updateLogo(@RequestParam(value = "file",required = false) MultipartFile file, HttpServletRequest request){
        String projectId = GetUtil.getProjectId(request);
        String pic = null;
        try {
            pic = UploadUtil.pic(file,request);
        } catch (MyException e) {
            e.printStackTrace();
        }
        return iGuidePageService.updateGuidePageLogo(projectId,pic);
    }

    @ApiOperation(value = "查找引导页logo")
    @RequestMapping(value = "/searchLogo",method = RequestMethod.GET)
    public Result searchLogo(HttpServletRequest request){
        String projectId = GetUtil.getProjectId(request);
        return iGuidePageService.searchGuidePageLogo(projectId);
    }

    @ApiOperation(value = "修改引导页底部信息")
    @RequestMapping(value = "/updateInfo",method = RequestMethod.POST)
    public Result updateInfo(@Param("developer")String developer, @Param("adress")String adress, @Param("telephone")String telephone, HttpServletRequest request){
        String projectId = GetUtil.getProjectId(request);
        return iGuidePageService.updateGuidePageInfo(projectId,developer,adress,telephone);
    }

    @ApiOperation(value = "查找引导页底部信息")
    @RequestMapping(value = "/searchInfo",method = RequestMethod.GET)
    public Result searchInfo(HttpServletRequest request){
        String projectId = GetUtil.getProjectId(request);
        return iGuidePageService.searchGuidePageInfo(projectId);
    }
}

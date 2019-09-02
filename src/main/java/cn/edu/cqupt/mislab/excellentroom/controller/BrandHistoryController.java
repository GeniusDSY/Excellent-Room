package cn.edu.cqupt.mislab.excellentroom.controller;

import cn.edu.cqupt.mislab.excellentroom.domain.po.Result;
import cn.edu.cqupt.mislab.excellentroom.exception.MyException;
import cn.edu.cqupt.mislab.excellentroom.service.ICultureService;
import cn.edu.cqupt.mislab.excellentroom.service.IHistoryService;
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
 * @description: 发展历程
 * @author: 宋丽
 * @create: 2019-08-28 04:02
 **/
@Api("发展历程")
@RestController
@RequestMapping("/History")
public class BrandHistoryController {
    @Autowired
    private IHistoryService iHistoryService;

    @ApiOperation(value = "修改发展历程背景（无删除）")
    @RequestMapping(value = "/updateBkground",method = RequestMethod.POST)
    public Result updateBkground(@RequestParam(value = "file",required = false) MultipartFile file, HttpServletRequest request){
        String projectId = GetUtil.getProjectId(request);
        String pic = null;
        try {
            pic = UploadUtil.pic(file,request);
        } catch (MyException e) {
            e.printStackTrace();
        }
        return iHistoryService.updateHistoryBkground(projectId,pic);
    }

    @ApiOperation(value = "查找发展历程背景（无删除）")
    @RequestMapping(value = "/searchBkground",method = RequestMethod.GET)
    public Result searchBkground(HttpServletRequest request){
        String projectId = GetUtil.getProjectId(request);
        return iHistoryService.searchHistoryBkground(projectId);
    }

    @ApiOperation(value = "查找轮播历程")
    @RequestMapping(value = "/searchHistory",method = RequestMethod.GET)
    public Result searchHistory(HttpServletRequest request){
        String projectId = GetUtil.getProjectId(request);
        return iHistoryService.searchHistory(projectId);
    }

    @ApiOperation(value = "新增轮播历程")
    @RequestMapping(value = "/addHistory",method = RequestMethod.POST)
    public Result addHistory(@RequestParam(value = "file",required = false) MultipartFile file,
                             @Param("time")String time,@Param("simple")String simple,@Param("text")String text, HttpServletRequest request){
        String projectId = GetUtil.getProjectId(request);
        String pic = null;
        try {
            pic = UploadUtil.pic(file,request);
        } catch (MyException e) {
            e.printStackTrace();
        }
        return iHistoryService.addHistory(projectId,pic,time,simple,text);
    }

    @ApiOperation(value = "修改轮播历程")
    @RequestMapping(value = "/updateHistory",method = RequestMethod.POST)
    public Result updateHistory(@Param("id")String id,@RequestParam(value = "file",required = false) MultipartFile file,
                                 @Param("time")String time,@Param("simple")String simple,@Param("text")String text, HttpServletRequest request){
        String projectId = GetUtil.getProjectId(request);
        String pic = null;
        try {
            pic = UploadUtil.pic(file,request);
        } catch (MyException e) {
            e.printStackTrace();
        }
        return iHistoryService.updateHistory(projectId,id,pic,time,simple,text);
    }

    @ApiOperation(value = "删除指定历程")
    @RequestMapping(value = "/deleteHistory",method = RequestMethod.POST)
    public Result deleteHistory(@Param("id")String id, HttpServletRequest request){
        String projectId = GetUtil.getProjectId(request);
        return iHistoryService.deleteHistory(projectId,id);
    }
}

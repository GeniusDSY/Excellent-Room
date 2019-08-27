package cn.edu.cqupt.mislab.excellentroom.controller;

import cn.edu.cqupt.mislab.excellentroom.constant.ResultEnum;
import cn.edu.cqupt.mislab.excellentroom.domain.dto.ProjectId;
import cn.edu.cqupt.mislab.excellentroom.domain.entity.Project;
import cn.edu.cqupt.mislab.excellentroom.domain.po.Result;
import cn.edu.cqupt.mislab.excellentroom.exception.MyException;
import cn.edu.cqupt.mislab.excellentroom.service.impl.IProjectService;
import cn.edu.cqupt.mislab.excellentroom.util.ResultUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.hibernate.sql.Update;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @program: Excellent-Room-sl-dev
 * @description: 项目管理模块
 * @author: 宋丽
 * @create: 2019-08-16 06:59
 **/
@Api("项目管理模块")
@RestController
@RequestMapping("/projectManagement")
public class ProjectController {
    @Autowired
    private IProjectService iProjectService;

    /**
     * 单项查询项目
     * @param provinceOrName
     * @return
     */
    @ApiOperation(value = "查找项目",notes = "根据省份或者具体项目名称进行单项查询")
    @RequestMapping(value = "/searchProjectByOne",method = RequestMethod.GET)
    public List<Result<Project>> searchProject(@RequestBody String provinceOrName){
        List<Project> list = new ArrayList<>();
        List<Result<Project>> list1 = new ArrayList<>();
        try {
            list = iProjectService.searchProject(provinceOrName);
        }catch (MyException e){
            e.printStackTrace();
            e.toString();
        }
        for(Iterator i = list.iterator(); i.hasNext();){
            list1.add(ResultUtil.success(i));
            i.next();
        }
        return list1;
    }

    /**
     * 多项查询项目
     * @param province
     * @param city
     * @return
     */
    @ApiOperation(value = "查找项目",notes = "根据省份和城市进行多项查询")
    @RequestMapping(value = "/searchProjectByTwo",method = RequestMethod.GET)
    public List<Result<Project>> searchProject(@RequestBody String province,String city){
        List<Project> list = new ArrayList<>();
        List<Result<Project>> list1 = new ArrayList<>();
        try {
            list = iProjectService.searchProject(province,city);
        }catch (MyException e){
            e.printStackTrace();
            e.toString();
        }
        for(Iterator i = list.iterator(); i.hasNext();){
            list1.add(ResultUtil.success(i));
            i.next();
        }
        return list1;
    }

    /**
     * 更改项目
     * @param project
     * @return
     */
    @ApiOperation(value = "更改项目",notes = "更改项目信息")
    @RequestMapping(value = "/updateProject",method = RequestMethod.POST)
    public Result updateProject(@RequestBody Project project) throws MyException {
        Result result = iProjectService.updateProject(project);
        return result;
    }

    /**
     * 新增项目
     * @param project
     * @return
     */
    @ApiOperation(value = "新增项目",notes = "录入新增项目的有效信息")
    @RequestMapping(value = "/addProject",method = RequestMethod.POST)
    public Result addProject(@RequestBody Project project){
        Result result = null;
        try {
            result = iProjectService.newProject(project);
        }catch (RuntimeException e){
            e.printStackTrace();
            return ResultUtil.error(ResultEnum.PPRJECT_EXISTED);
        }
        return result;
    }

    /**
     * 删除项目
     * @param id
     * @return
     */
    @ApiOperation(value = "删除项目",notes = "删除一个项目")
    @RequestMapping(value = "/deleteProject",method = RequestMethod.DELETE)
    public Result deletProject(@RequestBody ProjectId id){
        Boolean flag = iProjectService.deleteProject(id);
        if (!flag){
            return ResultUtil.error(ResultEnum.DELETE_ERROR);
        }
        return ResultUtil.success();
    }

    @ApiOperation(value = "上传二维码图片",notes = "上传指定项目的二维码图片")
    @RequestMapping(value = "/QRcodeUpload",method = RequestMethod.POST)
    public Result QRcodeUpload(@RequestParam(value="file",required=false) MultipartFile file, HttpServletRequest request){
        String url = iProjectService.QRcodeUpload(file,request);
        return ResultUtil.success(url);
    }
}

package cn.edu.cqupt.mislab.excellentroom.controller;

import cn.edu.cqupt.mislab.excellentroom.constant.ResultEnum;
import cn.edu.cqupt.mislab.excellentroom.domain.entity.Project;
import cn.edu.cqupt.mislab.excellentroom.domain.po.Result;
import cn.edu.cqupt.mislab.excellentroom.service.impl.IProjectService;
import cn.edu.cqupt.mislab.excellentroom.util.ResultUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author sl
 */
@Api("项目管理模块")
@RestController
@RequestMapping("/projectManagement")
public class ProjectController {
    @Autowired
    private IProjectService iProjectService;

    /**
     *
     * @return
     */
    @RequestMapping("/searchProject")
    public String searchProject(){
        return null;
    }

    /**
     *
     * @return
     */
    @RequestMapping("/project")
    public String project(){
        return null;
    }

    /**
     *
     * @return
     */
    @ApiOperation(value = "增加项目",notes = "录入新增项目的有效信息")
    @RequestMapping(value = "/addProject",method = RequestMethod.POST)
    public Result addProject(@RequestBody Project project){

        try {
            iProjectService.newProject(project);
        }catch (RuntimeException e){
            e.printStackTrace();
            return ResultUtil.error(ResultEnum.PPRJECT_EXISTED);
        }
        return ResultUtil.success();
    }

    /**
     *
     * @return
     */
    @RequestMapping("/deleteProject")
    public String deletProject(){
        return null;
    }
}

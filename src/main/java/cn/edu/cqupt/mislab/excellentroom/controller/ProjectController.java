package cn.edu.cqupt.mislab.excellentroom.controller;

import cn.edu.cqupt.mislab.excellentroom.domain.entity.Project;
import cn.edu.cqupt.mislab.excellentroom.domain.entity.ResultJson;
import cn.edu.cqupt.mislab.excellentroom.service.ProjectService;
import cn.edu.cqupt.mislab.excellentroom.util.ResultUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.session.data.redis.config.annotation.web.http.EnableRedisHttpSession;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * @Author HanSiyue
 * @Date 2019/8/25 上午12:00
 */

@EnableRedisHttpSession
@RestController
@RequestMapping("projectManagement")
@Api("项目管理接口文档")
public class ProjectController {

    @Autowired
    private ProjectService projectService;

    @PostMapping("updateProject")
    @ApiOperation("切换项目")
    @ApiImplicitParam(name = "projectId", value = "项目ID", dataType = "string", required = true)
    public ResultJson updateProject(HttpServletRequest request,String projectId){
        try {
            if (projectId!=null){
                Project project = projectService.selectProjectById(projectId);
                request.getSession().setAttribute("projectId",projectId);
                return ResultUtil.success(project.getProjectId());
            }else{
                return ResultUtil.isNull();
            }
        }catch (Exception e){
            e.printStackTrace();
            return ResultUtil.error();
        }
    }
}

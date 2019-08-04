package cn.edu.cqupt.mislab.excellentroom.service.impl;

import cn.edu.cqupt.mislab.excellentroom.domain.entity.Project;
import cn.edu.cqupt.mislab.excellentroom.domain.po.Result;
import cn.edu.cqupt.mislab.excellentroom.exception.MyException;

import java.util.List;

public interface IProjectService {
    /**
     * 新增项目
     * @param project
     * @return
     */
    Result newProject(Project project);

    /**
     * 删除项目
     * @param projectId
     * @return
     */
    Boolean deleteProject(String projectId);

    /**
     * 单项查询
     * @param provinceOrName
     * @return
     */
    List<Project> searchProject(String provinceOrName) throws MyException;

    /**
     * 多项查询
     * @param province
     * @param district
     * @return
     */
    List<Project> searchProject(String province,String district) throws MyException;

    /**
     * 更新项目信息
     * @param project
     * @return
     */
    Result updateProject(Project project);

}

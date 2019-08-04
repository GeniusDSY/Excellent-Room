package cn.edu.cqupt.mislab.excellentroom.service.impl;

import cn.edu.cqupt.mislab.excellentroom.domain.entity.Project;
import cn.edu.cqupt.mislab.excellentroom.domain.po.Result;

import java.util.List;

public interface IProjectService {
    /**
     * 新增项目
     * @param project
     * @return
     */
    Result newProject(Project project);

    /**
     * 单项查询
     * @param provinceOrProjectId
     * @return
     */
    List<Project> searchProject(String provinceOrProjectId);

    /**
     * 多项查询
     * @param province
     * @param district
     * @return
     */
    List<Project> searchProject(String province,String district);

}

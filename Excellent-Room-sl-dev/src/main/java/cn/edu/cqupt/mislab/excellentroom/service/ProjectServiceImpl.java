package cn.edu.cqupt.mislab.excellentroom.service;

import cn.edu.cqupt.mislab.excellentroom.constant.ResultEnum;
import cn.edu.cqupt.mislab.excellentroom.domain.entity.Project;
import cn.edu.cqupt.mislab.excellentroom.dao.ProjectDao;
import cn.edu.cqupt.mislab.excellentroom.domain.po.Result;
import cn.edu.cqupt.mislab.excellentroom.service.impl.IProjectService;
import cn.edu.cqupt.mislab.excellentroom.util.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;

/**
 * 项目管理服务，包括新增项目，查找项目，查看项目，删除项目
 *
 * @author 宋丽
 * @date 2019/8/4
 */
@Service("Project")
public class ProjectServiceImpl implements IProjectService {

    @Autowired
    private ProjectDao projectDao;

    @Override
    public Result newProject(Project project) {
        Boolean flag = projectDao.addProject(project.getProjectId(), project.getProvince(), project.getDistrict(), project.getName(), project.getTel(), project.getQRcodeName(), project.getQRcode());
        if (flag){
            return ResultUtil.success();
        }
        return ResultUtil.error(ResultEnum.UNKNOWN_ERROR);
    }

    @Override
    public List<Project> searchProject(String provinceOrProjectId) {
        List<Project> list;
         list = projectDao.searchProjectByOne(provinceOrProjectId);
        return list;
    }

    @Override
    public List<Project> searchProject(String province, String district) throws {
        List<Project> list;
        list = projectDao.searchProjectByTwo(province,district);
        try {
            boolean flag = list.isEmpty();
            if (!flag)throw
        }


        return list;
    }
}
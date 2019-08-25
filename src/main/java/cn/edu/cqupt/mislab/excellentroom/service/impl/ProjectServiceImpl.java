package cn.edu.cqupt.mislab.excellentroom.service.impl;

import cn.edu.cqupt.mislab.excellentroom.dao.ProjectDao;
import cn.edu.cqupt.mislab.excellentroom.domain.entity.Project;
import cn.edu.cqupt.mislab.excellentroom.service.ProjectService;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @Author HanSiyue
 * @Date 2019/8/25 上午12:27
 */
@Service
public class ProjectServiceImpl implements ProjectService {
    @Resource
    private ProjectDao projectDao;

    @Override
    public Project selectProjectById(String projectId){
        Project project = projectDao.selectProjectById(projectId);
        if (project!=null){
            return project;
        }else {
            return null;
        }
    }
}

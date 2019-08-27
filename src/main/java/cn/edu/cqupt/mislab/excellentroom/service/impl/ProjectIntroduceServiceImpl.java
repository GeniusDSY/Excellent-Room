package cn.edu.cqupt.mislab.excellentroom.service.impl;

import cn.edu.cqupt.mislab.excellentroom.dao.ProjectIntroduceDao;
import cn.edu.cqupt.mislab.excellentroom.domain.entity.ProjectIntroduce;
import cn.edu.cqupt.mislab.excellentroom.domain.po.ProjectIntroducePo;
import cn.edu.cqupt.mislab.excellentroom.service.ProjectIntroduceService;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @Author HanSiyue
 * @Date 2019/8/24 下午3:30
 */

@Service
public class ProjectIntroduceServiceImpl implements ProjectIntroduceService {
    @Resource
    private ProjectIntroduceDao projectIntroduceDao;

    @Override
    public Boolean updateProjectIntroduceBkgroundUrl(String projectIntroduceBkgroundUrl,String projectId){
        Boolean result = projectIntroduceDao.updateProjectIntroduceBkgroundUrl(projectIntroduceBkgroundUrl,projectId);
        return result;
    }

    @Override
    public ProjectIntroducePo selectProjectIntroduceBkgroundById(String projectId){
        ProjectIntroduce projectIntroduce = projectIntroduceDao.selectProjectIntroduceBkgroundById(projectId);
        if (projectIntroduce!=null){
            ProjectIntroducePo projectIntroducePo = new ProjectIntroducePo();
            BeanUtils.copyProperties(projectIntroduce,projectIntroducePo);
            return projectIntroducePo;
        }else {
            return null;
        }
    }

    @Override
    public Boolean addProjectIntroduceBkgroundUrl(String projectIntroduceBkgroundUrl, String projectId){
        Boolean result = projectIntroduceDao.addProjectIntroduceBkgroundUrl(projectIntroduceBkgroundUrl, projectId);
        return result;
    }

    @Override
    public Boolean deleteProjectIntroduceBkgroundUrl(String projectId){
        Boolean result = projectIntroduceDao.deleteProjectIntroduceBkgroundUrl(projectId);
        return result;
    }

    @Override
    public Boolean updateProjectIntroduceText(String projectIntroduceText,String projectId){
        Boolean result = projectIntroduceDao.updateProjectIntroduceText(projectIntroduceText, projectId);
        return result;
    }

    @Override
    public ProjectIntroducePo selectProjectIntroduceTextById(String projectId){
        ProjectIntroduce projectIntroduce = projectIntroduceDao.selectProjectIntroduceTextById(projectId);
        if (projectIntroduce!=null){
            ProjectIntroducePo projectIntroducePo = new ProjectIntroducePo();
            BeanUtils.copyProperties(projectIntroduce,projectIntroducePo);
            return projectIntroducePo;
        }else {
            return null;
        }
    }

    @Override
    public Boolean updateProjectIntroduceTitle(String projectIntroduceTitle, String projectId){
        Boolean result = projectIntroduceDao.updateProjectIntroduceTitle(projectIntroduceTitle, projectId);
        return result;
    }

    @Override
    public ProjectIntroducePo selectProjectIntroduceTitleById(String projectId){
        ProjectIntroduce projectIntroduce = projectIntroduceDao.selectProjectIntroduceTitleById(projectId);
        if (projectIntroduce!=null){
            ProjectIntroducePo projectIntroducePo = new ProjectIntroducePo();
            BeanUtils.copyProperties(projectIntroduce,projectIntroducePo);
            return projectIntroducePo;
        }else {
            return null;
        }
    }
}

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
    public Boolean updateProjectIntroduceBkgroundUrl(String projectIntroduceBkgroundUrl,Object projectId){
        Boolean result = projectIntroduceDao.updateProjectIntroduceBkgroundUrl(projectIntroduceBkgroundUrl,projectId);
        return result;
    }

    @Override
    public ProjectIntroducePo selectProjectIntroduceBkgroundById(Object projectId){
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
    public Boolean addProjectIntroduceBkgroundUrl(String projectIntroduceBkgroundUrl, Object projectId){
        Boolean result = projectIntroduceDao.addProjectIntroduceBkgroundUrl(projectIntroduceBkgroundUrl, projectId);
        return result;
    }

    @Override
    public Boolean deleteProjectIntroduceBkgroundUrl(Object projectId){
        Boolean result = projectIntroduceDao.deleteProjectIntroduceBkgroundUrl(projectId);
        return result;
    }

    @Override
    public Boolean updateProjectIntroduceText(String projectIntroduceText,Object projectId){
        Boolean result = projectIntroduceDao.updateProjectIntroduceText(projectIntroduceText, projectId);
        return result;
    }

    @Override
    public ProjectIntroducePo selectProjectIntroduceTextById(Object projectId){
        ProjectIntroduce projectIntroduce = projectIntroduceDao.selectprojectIntroduceTextById(projectId);
        if (projectIntroduce!=null){
            ProjectIntroducePo projectIntroducePo = new ProjectIntroducePo();
            BeanUtils.copyProperties(projectIntroduce,projectIntroducePo);
            return projectIntroducePo;
        }else {
            return null;
        }
    }

    @Override
    public Boolean updateProjectIntroduceTitel(String projectIntroduceTitel, Object projectId){
        Boolean result = projectIntroduceDao.updateProjectIntroduceTitel(projectIntroduceTitel, projectId);
        return result;
    }

    @Override
    public ProjectIntroducePo selectprojectIntroduceTitelById(Object projectId){
        ProjectIntroduce projectIntroduce = projectIntroduceDao.selectprojectIntroduceTitelById(projectId);
        if (projectIntroduce!=null){
            ProjectIntroducePo projectIntroducePo = new ProjectIntroducePo();
            BeanUtils.copyProperties(projectIntroduce,projectIntroducePo);
            return projectIntroducePo;
        }else {
            return null;
        }
    }
}

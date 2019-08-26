package cn.edu.cqupt.mislab.excellentroom.service;

import cn.edu.cqupt.mislab.excellentroom.constant.ResultEnum;
import cn.edu.cqupt.mislab.excellentroom.domain.dto.ProjectId;
import cn.edu.cqupt.mislab.excellentroom.domain.entity.Project;
import cn.edu.cqupt.mislab.excellentroom.dao.ProjectDao;
import cn.edu.cqupt.mislab.excellentroom.domain.po.Result;
import cn.edu.cqupt.mislab.excellentroom.exception.MyException;
import cn.edu.cqupt.mislab.excellentroom.service.impl.IProjectService;
import cn.edu.cqupt.mislab.excellentroom.util.ResultUtil;
import cn.edu.cqupt.mislab.excellentroom.util.UploadUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
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
        Boolean flag = projectDao.addProject(project.getProjectId(), project.getProvince(), project.getDistrict(), project.getName(), project.getTel(), project.getQRcodeName());
        if (flag){
            return ResultUtil.success();
        }
        return ResultUtil.error(ResultEnum.UNKNOWN_ERROR);
    }

    @Override
    public Boolean deleteProject(ProjectId id) {
        Boolean flag = projectDao.deleteProject(id);
        return flag;
    }

    @Override
    public List<Project> searchProject(String provinceOrName) throws MyException {
        List<Project> list;
         list = projectDao.searchProjectByOne(provinceOrName);
        boolean flag = list.isEmpty();
        if (!flag){
            throw new MyException(401,"无匹配项");
        }
        return list;
    }

    @Override
    public List<Project> searchProject(String province, String district) throws MyException {
        List<Project> list;
        list = projectDao.searchProjectByTwo(province,district);
        boolean flag = list.isEmpty();
        if (!flag){
            throw new MyException(401,"无匹配项");
        }
        return list;
    }

    @Override
    public Result updateProject(Project project) {
        int i = projectDao.updateProject(project.getProjectId(),project.getProvince(),project.getDistrict(),project.getName(),project.getTel(),project.getQRcodeName());
        if (i == 0){
            return ResultUtil.error(ResultEnum.UPDATE_ERROR);
        }
        return ResultUtil.success(projectDao.searchProjectByOne(project.getName()));
    }
}
package cn.edu.cqupt.mislab.excellentroom.service;

import cn.edu.cqupt.mislab.excellentroom.domain.dto.ProjectId;
import cn.edu.cqupt.mislab.excellentroom.domain.entity.Project;
import cn.edu.cqupt.mislab.excellentroom.domain.po.Result;
import cn.edu.cqupt.mislab.excellentroom.exception.MyException;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @author: 宋丽
 * @create: 2019-08-16 9:59
 */
public interface IProjectService {
    /**
     * 新增项目
     * @param project
     * @return
     */
    Result newProject(Project project);

    /**
     * 删除项目
     * @param id
     * @return
     */
    Boolean deleteProject(ProjectId id);

    /**
     * 单项查询
     * @param provinceOrName
     * @return
     * @throws MyException
     */
    List<Project> searchProject(String provinceOrName) throws MyException;


    /**
     * 多项查询
     * @param province
     * @param district
     * @return
     * @throws MyException
     */
    List<Project> searchProject(String province,String district) throws MyException;

    /**
     * 更新项目信息
     * @param project
     * @return
     */
    Result updateProject(Project project) throws MyException;

    /**
     * 二维码图片上传
     * @param file
     * @return
     */
    String QRcodeUpload(MultipartFile file,HttpServletRequest request);

}

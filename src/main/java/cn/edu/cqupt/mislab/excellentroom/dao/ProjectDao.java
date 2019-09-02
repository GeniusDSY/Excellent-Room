package cn.edu.cqupt.mislab.excellentroom.dao;

import cn.edu.cqupt.mislab.excellentroom.domain.entity.Project;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import java.util.List;

/**
 * 项目管理服务接口
 * 增删改查
 *
 * @author 宋丽
 * @date 2019/8/4
 */
@Repository
@Mapper
public interface ProjectDao {
    /**
     * 增加项目
     * @param projectId
     * @param province
     * @param district
     * @param name
     * @param tel
     * @param QRcodename
     * @return
     */
    Boolean addProject(@Param("projectId")String projectId, @Param("province")String province, @Param("district")String district, @Param("name")String name, @Param("tel")String tel, @Param("QRcodename")String QRcodename);

    /**
     * 删除项目
     * @param projectId
     * @return
     */
    Boolean deleteProject(@Param("projectId") String projectId);

    /**
     * 传入省份或者项目代号进行查询
     * @param provinceOrName
     * @return
     */
    List<Project> searchProjectByOne(@Param("provinceOrName")String provinceOrName);

    /**
     * 输入省份及城市进行查询
     * @param province
     * @param district
     * @return
     */
    List<Project> searchProjectByTwo(@Param("province")String province,@Param("district")String district);

    /**
     * 更改对应项目代号的信息
     * @param projectId
     * @param province
     * @param district
     * @param name
     * @param tel
     * @param QRcodename
     * @return
     */
    int updateProject(@Param("projectId")String projectId, @Param("province")String province, @Param("district")String district, @Param("name")String name, @Param("tel")String tel, @Param("QRcodename")String QRcodename);

    /**
     * 上传项目二维码
     * @param projectId
     * @param Qrcode
     * @return
     */
    boolean QRcodeUpload(@Param("projectId")String projectId,@Param("QRcode")String Qrcode);

    /**
     * 通过项目ID查询项目
     * @param projectId 项目ID
     * @return true
     */
      Project selectProjectById(@Param("projectId") String projectId);
}

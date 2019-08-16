package cn.edu.cqupt.mislab.excellentroom.dao;

import cn.edu.cqupt.mislab.excellentroom.domain.dto.ProjectId;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 企业简介接口
 * 查询对应项目的企业相关信息
 *
 * @author 宋丽
 * @date 2019/8/16
 */
@Repository
@Mapper
public interface CompanyProfilesDao {
    /**
     * 查找企业简介标题
     * @param projectId
     * @return
     */
    String searchTitle(@Param("projectId")ProjectId projectId);

    /**
     * 查找企业简介文本介绍
     * @param projectId
     * @return
     */
    String searchText(@Param("projectId")ProjectId projectId);

    /**
     * 查找企业简介的视频介绍
     * @param projectId
     * @return
     */
    String searchVideo(@Param("projectId")ProjectId projectId);

    /**
     * 查找企业简介的图片介绍
     * @param projectId
     * @return
     */
    List<String> searchPic(@Param("projectId")ProjectId projectId);
}

package cn.edu.cqupt.mislab.excellentroom.dao;

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
public interface CompanyDao {

    /**
     * 修改企业简介的视频链接(无删除)
     * @param projectId
     * @param video
     * @return
     */
    boolean updateCompanyProfilesVideo(@Param("projectId")String projectId,@Param("video")String video);

    /**
     * 查询企业简介的视频链接
     * @param projectId
     * @return
     */
    String searchCompanyProfilesVideo(@Param("projectId")String projectId);
    /**
     * 修改企业简介的介绍文本（无删除）
     * @param projectId
     * @param text
     * @return
     */
    boolean updateCompanyProfilesText(@Param("projectId")String projectId,@Param("text")String text);

    /**
     * 查询企业简介的介绍文本
     * @param projectId
     * @return
     */
    String searchCompanyProfilesText(@Param("projectId")String projectId);

    /**
     * 新增企业简介的轮播背景图片（无更新）
     * @param projectId
     * @param pic
     * @return
     */
    boolean addCompanyProfilesPic(@Param("projectId")String projectId,@Param("pic")String pic);

    /**
     * 查询企业简介的轮播背景图片
     * @param projectId
     * @return
     */
    List<String> searchCompanyProfilesPic(@Param("projectId")String projectId);

    /**
     * 删除企业简介的轮播背景图片（单张）
     * @param projectId
     * @param pic
     * @return
     */
    boolean deleteCompanyProfilesPic(@Param("projectId")String projectId,@Param("pic")String pic);
}

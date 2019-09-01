package cn.edu.cqupt.mislab.excellentroom.dao;

import cn.edu.cqupt.mislab.excellentroom.domain.po.GuidePage;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

/**
 * 引导页接口
 * @author 宋丽
 * @date 2019/8/30
 */
@Repository
@Mapper
public interface GuidePageDao {
    /**
     * 修改引导页背景图片（无删除）
     * @param projectId
     * @param bkground
     * @return
     */
    boolean updateGuidePageBkground(@Param("projectId")String projectId, @Param("bkground")String bkground);

    /**
     * 查找引导页背景图片
     * @param projectId
     * @return
     */
    String searchGuidePageBkground(@Param("projectId")String projectId);

    /**
     * 修改引导页Logo
     * @param projectId
     * @param logo
     * @return
     */
    boolean updateGuidePageLogo(@Param("projectId")String projectId,@Param("logo")String logo);

    /**
     * 查找引导页Logo
     * @param projectId
     * @return
     */
    String searchGuidePageLogo(@Param("projectId")String projectId);


    /**
     * 修改引导页底部信息
     * @param projectId
     * @param developer
     * @param address
     * @param telephone
     * @return
     */
    boolean updateGuidePageInfo(@Param("projectId")String projectId,@Param("developer")String developer,@Param("address")String address,@Param("telephone")String telephone);

    /**
     * 查找引导页底部信息
     * @param projectId
     * @return
     */
    GuidePage searchGuidePageInfo(@Param("projectId")String projectId);


}

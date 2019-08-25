package cn.edu.cqupt.mislab.excellentroom.dao;

import cn.edu.cqupt.mislab.excellentroom.domain.entity.HomePage;
import cn.edu.cqupt.mislab.excellentroom.domain.po.HomePagePo;
import org.springframework.stereotype.Repository;
import org.apache.ibatis.annotations.Param;
import java.io.File;

@Repository
public interface HomePageDao {

    /**
     * 修改首页背景图片
     *@param homePageBkgroundUrl 首页背景图片地址
     *@param projectId 项目ID
     *@return true
     */
    Boolean updateHomePageBkground(@Param("homePageBkgroundUrl")String homePageBkgroundUrl,@Param("projectId") Object projectId);

    /**
     * 修改首页Logo
     *@param homePageLogoUrl 首页Logo地址
     *@param projectId 项目ID
     *@return true
     */
    Boolean updateHomePageLogo(@Param("homePageLogoUrl")String homePageLogoUrl,@Param("projectId") Object projectId);

    /**
     * 修改首页Icon
     *@param homePageIconUrl 首页Icon地址
     *@param projectId 项目ID
     *@return true
     */
    Boolean updateHomePageIcon(@Param("homePageIconUrl")String homePageIconUrl,@Param("projectId") Object projectId);

    /**
     * 展示首页背景图片
     *@param projectId 项目ID
     *@return true
     */
    HomePage selectHomePageBkgroundById(@Param("projectId") Object projectId);

    /**
     * 展示首页Logo
     *@param projectId 项目ID
     *@return true
     */
    HomePage selectHomePageLogoById(@Param("projectId") Object projectId);

    /**
     * 展示首页Icon
     *@param projectId 项目ID
     *@param id 图片ID
     *@return true
     */
    HomePage selectHomePageIconById(@Param("projectId") Object projectId, @Param("id") String id);
}

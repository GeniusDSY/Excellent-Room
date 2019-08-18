package cn.edu.cqupt.mislab.excellentroom.dao;

import cn.edu.cqupt.mislab.excellentroom.domain.entity.HomePage;
import org.springframework.stereotype.Repository;
import org.apache.ibatis.annotations.Param;
import java.io.File;

@Repository
public interface HomePageDao {
    /**
     * 修改首页背景图片
     *@param homePageBkgroundUrl 首页背景图片地址
     *@param projectId 项目ID
     *@return HomePage
     */
    Boolean updateHomePageBkground(@Param("homePageBkgroundUrl")String homePageBkgroundUrl,@Param("projectId") String projectId);

    /**
     * 修改首页Logo
     *@param homePageLogoUrl 首页Logo地址
     *@param projectId 项目ID
     *@return HomePage
     */
    Boolean updateHomePageLogo(@Param("homePageLogoUrl")String homePageLogoUrl,@Param("projectId") String projectId);

    /**
     * 修改首页Icon
     *@param homePageIconUrl 首页Icon地址
     *@param projectId 项目ID
     *@return HomePage
     */
    Boolean updateHomePageIcon(@Param("homePageIconUrl")String homePageIconUrl,@Param("projectId") String projectId);
}

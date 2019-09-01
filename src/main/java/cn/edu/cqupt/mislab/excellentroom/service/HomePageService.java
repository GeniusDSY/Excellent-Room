package cn.edu.cqupt.mislab.excellentroom.service;

import cn.edu.cqupt.mislab.excellentroom.domain.po.HomePagePo;
import org.apache.ibatis.annotations.Param;

/**
 * @Author HanSiyue
 * @Date 2019/8/14 下午9:40
 */

public interface HomePageService {
    /**
     * 修改首页背景图片
     *@param homePageBkgroundUrl 首页背景图片地址
     *@param projectId 项目ID
     *@return
     */
    Boolean updateHomePageBkground(@Param("homePageBkgroundUrl") String homePageBkgroundUrl, @Param("projectId") String projectId);

    /**
     * 修改首页Logo
     *@param homePageLogoUrl 首页Logo地址
     *@param projectId 项目ID
     *@return
     */
    Boolean updateHomePageLogo(@Param("homePageLogoUrl") String homePageLogoUrl,@Param("projectId") String projectId);

    /**
     * 修改首页Icon
     *@param homePageIconUrl 首页Icon地址
     *@param projectId 项目ID
     *@return
     */
    Boolean updateHomePageIcon(@Param("homePageIconUrl") String homePageIconUrl,@Param("projectId") String projectId);

    /**
     * 展示首页背景图片
     *@param projectId 项目ID
     *@return HomePagePo
     */
    HomePagePo selectHomePageBkgroundById(@Param("projectId") String projectId);

    /**
     * 展示首页Logo
     *@param projectId 项目ID
     *@return
     */
    HomePagePo selectHomePageLogoById(@Param("projectId") String projectId);

    /**
     * 展示首页Icon
     *@param projectId 项目ID
     *@return
     */
    HomePagePo selectHomePageIconById(@Param("projectId") String projectId, @Param("id") String id);

}

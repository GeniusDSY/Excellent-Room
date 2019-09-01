package cn.edu.cqupt.mislab.excellentroom.service;

import cn.edu.cqupt.mislab.excellentroom.domain.po.ProjectIntroducePo;
import org.apache.ibatis.annotations.Param;

/**
 * @Author HanSiyue
 * @Date 2019/8/24 下午3:27
 */
public interface ProjectIntroduceService {
    /**
     * 修改项目介绍背景图片
     *@param projectIntrduceBkgroundUrl 项目介绍背景图片地址
     *@param projectId 项目ID
     *@return
     */
    Boolean updateProjectIntroduceBkgroundUrl(@Param("projectIntroduceBkgroundUrl") String projectIntrduceBkgroundUrl, @Param("projectId") String projectId);

    /**
     * 展示项目介绍背景图片
     *@param projectId 项目ID
     *@return HomePagePo
     */
    ProjectIntroducePo selectProjectIntroduceBkgroundById(@Param("projectId") String projectId);

    /**
     * 修改项目介绍描述
     * @param projectIntroduceText 文字描述
     * @param projectId 项目ID
     * @return true
     */
    Boolean updateProjectIntroduceText(@Param("projectIntroduceText") String projectIntroduceText, @Param("projectId") String projectId);

    /**
     * 展示项目介绍文字描述
     * @param projectId 项目ID
     * @return ...
     */
    ProjectIntroducePo selectProjectIntroduceTextById(@Param("projectId") String projectId);

    /**
     * 修改项目介绍标题
     * @param projectIntroduceTitle 项目介绍标题
     * @param projectId 项目ID
     * @return true
     */
    Boolean updateProjectIntroduceTitle(@Param("projectIntroduceTitle") String projectIntroduceTitle, @Param("projectId") String projectId);

    /**
     * 展示项目介绍标题
     * @param projectId 项目ID
     * @return ...
     */
    ProjectIntroducePo selectProjectIntroduceTitleById(@Param("projectId") String projectId);
}

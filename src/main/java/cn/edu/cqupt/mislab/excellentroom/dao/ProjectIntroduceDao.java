package cn.edu.cqupt.mislab.excellentroom.dao;

import cn.edu.cqupt.mislab.excellentroom.domain.entity.ProjectIntroduce;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

/**
 * @Author HanSiyue
 * @Date 2019/8/24 下午3:11
 */

@Repository
public interface ProjectIntroduceDao {
    /**
     * 修改项目介绍背景图片
     *@param projectIntroduceBkgroundUrl 项目介绍背景图片地址
     *@param projectId 项目ID
     *@return true
     */
    Boolean updateProjectIntroduceBkgroundUrl(@Param("projectIntroduceBkgroundUrl")String projectIntroduceBkgroundUrl, @Param("projectId") Object projectId);

    /**
     * 展示项目介绍背景图片
     *@param projectId 项目ID
     *@return ...
     */
    ProjectIntroduce selectProjectIntroduceBkgroundById(@Param("projectId") Object projectId);

    /**
     * 增加项目介绍背景图片
     * @param projectIntroduceBkgroundUrl 项目介绍背景图片地址
     * @param projectId 项目ID
     * @return true
     */
    Boolean addProjectIntroduceBkgroundUrl(@Param("projectIntroduceBkgroundUrl") String projectIntroduceBkgroundUrl, @Param("projectId") Object projectId);

    /**
     * 删除项目介绍背景图片
     * @param projectId 项目ID
     * @return true
     */
    Boolean deleteProjectIntroduceBkgroundUrl(@Param("projectId") Object projectId);

    /**
     * 修改项目介绍描述
     * @param projectIntroduceText 文字描述
     * @param projectId 项目ID
     * @return true
     */
    Boolean updateProjectIntroduceText(@Param("projectIntroduceText") String projectIntroduceText, @Param("projectId") Object projectId);

    /**
     * 展示项目介绍文字描述
     * @param projectId 项目ID
     * @return ...
     */
    ProjectIntroduce selectprojectIntroduceTextById(@Param("projectId") Object projectId);

    /**
     * 修改项目介绍标题
     * @param projectIntroduceTitel 项目介绍标题
     * @param projectId 项目ID
     * @return true
     */
    Boolean updateProjectIntroduceTitel(@Param("projectIntroduceTitel") String projectIntroduceTitel, @Param("projectId") Object projectId);

    /**
     * 展示项目介绍标题
     * @param projectId 项目ID
     * @return ...
     */
    ProjectIntroduce selectprojectIntroduceTitelById(@Param("projectId") Object projectId);
}

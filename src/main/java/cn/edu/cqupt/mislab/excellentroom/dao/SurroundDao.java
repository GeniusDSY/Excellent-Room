package cn.edu.cqupt.mislab.excellentroom.dao;

import cn.edu.cqupt.mislab.excellentroom.domain.entity.Landscape;
import cn.edu.cqupt.mislab.excellentroom.domain.entity.PublicUtility;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Author HanSiyue
 * @Date 2019/8/27 上午11:31
 */

@Repository
public interface SurroundDao {

    /**
     * 增加园林景观图片
     * @param projectId 项目ID
     * @param landscapeUrl 园林景观图片
     * @param text 描述
     * @return true
     */
    Boolean addLandscape(@Param("projectId") String projectId, @Param("landscapeUrl") String landscapeUrl, @Param("text") String text);

    /**
     * 删除园林景观图片
     * @param projectId 项目ID
     * @param id 图片id
     * @return true
     */
    Boolean deleteLandscapeById(@Param("projectId") String projectId, @Param("id") Integer id);

    /**
     * 通过id查询园林景观图片
     * @param projectId 项目ID
     * @param id id
     * @return
     */
    Landscape selectLandscapeById(@Param("projectId") String projectId, @Param("id") Integer id);

    /**
     * 通过id查询公共设施图片
     * @param projectId 项目ID
     * @param id id
     * @return
     */
    PublicUtility selectPublicUtilityById(@Param("projectId") String projectId, @Param("id") Integer id);

    /**
     * 展示所有园林景观图片
     * @param projectId 项目ID
     * @return
     */
    List<Landscape> findAllLandscape(@Param("projectId") String projectId);

    /**
     * 增加公共设施图片
     * @param projectId 项目ID
     * @param publicUtilityUrl 公共设施图片
     * @param text 描述
     * @return true
     */
    Boolean addPublicUtility(@Param("projectId") String projectId, @Param("publicUtilityUrl") String publicUtilityUrl, @Param("text") String text);

    /**
     * 删除公共设施图片
     * @param projectId 项目ID
     * @param id 图片id
     * @return true
     */
    Boolean deletePublicUtilityById(@Param("projectId") String projectId, @Param("id") Integer id);

    /**
     * 展示所有公共设施图片
     * @param projectId 项目ID
     * @return
     */
    List<PublicUtility> findAllPublicUtility(@Param("projectId") String projectId);
}

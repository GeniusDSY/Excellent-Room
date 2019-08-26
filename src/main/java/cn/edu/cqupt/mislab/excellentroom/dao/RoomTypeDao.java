package cn.edu.cqupt.mislab.excellentroom.dao;

import cn.edu.cqupt.mislab.excellentroom.domain.entity.RoomType;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

/**
 * @Author HanSiyue
 * @Date 2019/8/26 下午2:53
 */

@Repository
public interface RoomTypeDao {

    /**
     * 增加户型
     * @param projectId 项目ID
     * @param type 户型
     * @return true
     */
    Boolean addRoomType(@Param("projectId") String projectId, @Param("type") Integer type);

    /**
     * 删除户型
     * @param projectId 项目ID
     * @param id id
     * @return true
     */
    Boolean deleteRoomTypeById(@Param("projectId") String projectId, @Param("id") Integer id);

    /**
     * 增加样板间图片
     * @param projectId 项目ID
     * @param type 户型
     * @param simplePicUrl 样板间图片
     * @return true
     */
    Boolean addSimplePic(@Param("projectId") String projectId, @Param("type") Integer type, @Param("simplePicUrl") String simplePicUrl);

    /**
     * 删除样板间图片
     * @param projectId 项目ID
     * @param id id
     * @return true
     */
    Boolean deleteSimplePicById(@Param("prpjectId") String projectId, @Param("id") Integer id);

    /**
     * 修改户型图片
     * @param projectId 项目ID
     * @param type 户型
     * @param layoutUrl 户型图
     * @return
     */
    RoomType updateLayout(@Param("projectId") String projectId, @Param("type") Integer type, @Param("layoutUrl") String layoutUrl);

    /**
     * 修改全景图片
     * @param projectId 项目ID
     * @param type 户型
     * @param panoramaUrl 全景图
     * @return
     */
    RoomType updatePanorama(@Param("projectId") String projectId, @Param("type") Integer type, @Param("panoramaUrl") String panoramaUrl);

    /**
     * 展示户型
     * @param projectId 项目ID
     * @param type type
     * @return
     */
    RoomType selectRoomTypeById(@Param("projectId") String projectId, @Param("type") Integer type);

    /**
     * 展示样板间图片
     * @param projectId 项目ID
     * @param id id
     * @return
     */
    RoomType selectSimplePicById(@Param("projectId") String projectId, @Param("id") Integer id);
}

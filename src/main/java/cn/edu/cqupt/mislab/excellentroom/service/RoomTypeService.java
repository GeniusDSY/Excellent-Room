package cn.edu.cqupt.mislab.excellentroom.service;

import cn.edu.cqupt.mislab.excellentroom.domain.entity.RoomType;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;

/**
 * @Author HanSiyue
 * @Date 2019/8/26 下午5:06
 */

@Service
public interface RoomTypeService {
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
    Boolean deleteSimplePicById(@Param("projectId") String projectId, @Param("id") Integer id);

    /**
     * 修改户型图片
     * @param projectId 项目ID
     * @param type 户型
     * @param layoutUrl 户型图
     * @return
     */
    Boolean updateLayout(@Param("projectId") String projectId, @Param("type") Integer type, @Param("layoutUrl") String layoutUrl);

    /**
     * 修改全景图片
     * @param projectId 项目ID
     * @param type 户型
     * @param panoramaUrl 全景图
     * @return
     */
    Boolean updatePanorama(@Param("projectId") String projectId, @Param("type") Integer type, @Param("panoramaUrl") String panoramaUrl);

    /**
     * 展示户型
     * @param projectId 项目ID
     * @param type 户型
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


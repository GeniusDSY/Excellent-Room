package cn.edu.cqupt.mislab.excellentroom.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
@Mapper
public interface HonorDao {
    /**
     * 修改品牌荣誉背景图片（无删除）
     * @param projectId
     * @param bkground
     * @return
     */
    boolean updateHonorBkground(@Param("projectId")String projectId,@Param("bkground")String bkground);

    /**
     * 查找品牌荣誉背景图片
     * @param projectId
     * @return
     */
    String searchHonorBkground(@Param("projectId")String projectId);
    /**
     * 查找品牌荣誉轮播图片（无更新）
     * @param projectId
     * @return
     */
    List<String> searchHonorPic(@Param("projectId")String projectId);

    /**
     * 查找品牌荣誉轮播文本（无更新）
     * @param projectId
     * @return
     */
    List<String> searchHonorText(@Param("projectId")String projectId);


    /**
     * 删除指定品牌荣誉轮播图片
     * @param projectId
     * @return
     */
    boolean deleteHonorPic(@Param("projectId")String projectId,@Param("pic")String pic);

    /**
     * 新增品牌荣誉轮播图片
     * @param projectId
     * @return
     */
    boolean addHonorPic(@Param("projectId")String projectId,@Param("pic")String pic);
    /**
     * 删除指定品牌荣誉文本
     * @param projectId
     * @param text
     * @return
     */
    boolean deleteHonorText(@Param("projectId")String projectId,@Param("text")String text);

    /**
     * 新增品牌荣誉文本
     * @param projectId
     * @return
     */
    boolean addHonorText(@Param("projectId")String projectId,@Param("text")String text);

}

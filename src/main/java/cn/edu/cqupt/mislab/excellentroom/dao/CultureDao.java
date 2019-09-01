package cn.edu.cqupt.mislab.excellentroom.dao;

import cn.edu.cqupt.mislab.excellentroom.domain.po.Culture;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
@Mapper
public interface CultureDao {
    /**
     * 修改企业文化背景（无删除）
     * @param projectId
     * @param pic
     * @return
     */
    boolean updateCultureBkground(@Param("projectId")String projectId,@Param("pic")String pic);

    /**
     * 查找企业文化背景（无删除）
     * @param projectId
     * @return
     */
    String searchCultureBkground(@Param("projectId")String projectId);

    /**
     * 修改企业文化图片（无删除）
     * @param projectId
     * @param pic
     * @return
     */
    boolean updateCulturePic(@Param("projectId")String projectId,@Param("pic")String pic);

    /**
     * 查找企业文化图片（无删除）
     * @param projectId
     * @return
     */
    String searchCulturePic(@Param("projectId")String projectId);

    /**
     * 查找企业文化（无修改）
     * @param projectId
     * @return
     */
    List<Culture> searchCulture(@Param("projectId")String projectId);

    /**
     * 删除指定企业文化
     * @param projectId
     * @param title
     * @param text
     * @return
     */
    boolean deleteCulture(@Param("projectId")String projectId,@Param("title")String title,@Param("text")String text);

    /**
     * 增加文化
     * @param projectId
     * @param title
     * @param text
     * @return
     */
    boolean addCulture(@Param("projectId")String projectId,@Param("title")String title,@Param("text")String text);

}

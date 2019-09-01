package cn.edu.cqupt.mislab.excellentroom.dao;

import cn.edu.cqupt.mislab.excellentroom.domain.po.History;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
@Mapper
public interface HistoryDao {
    /**
     * 修改发展历程背景（无删除）
     * @param projectId
     * @param bkground
     * @return
     */
    boolean updateHistoryBkground(@Param("projectId")String projectId,@Param("bkground")String bkground);

    /**
     * 查找发展历程背景（无删除）
     * @param projectId
     * @return
     */
    String searchHistoryBkground(@Param("projectId")String projectId);

    /**
     * 查找轮播历程
     * @param projectId
     * @return
     */
    List<History> searchHistory(@Param("projectId")String projectId);

    /**
     * 新增轮播历程
     * @param projectId
     * @param pic
     * @param time
     * @param simple
     * @param text
     * @return
     */
    boolean addHistory(@Param("projectId")String projectId,@Param("pic")String pic,
        @Param("time")String time,@Param("simple")String simple,@Param("text")String text);

    /**
     * 修改轮播历程
     * @param projectId
     * @param pic
     * @param time
     * @param simple
     * @param text
     * @param id
     * @return
     */
    boolean updateHistory(@Param("projectId")String projectId,@Param("id")String id,@Param("pic")String pic,
                       @Param("time")String time,@Param("simple")String simple,@Param("text")String text);

    /**
     * 删除指定历程
     * @param projectId
     * @param id
     * @return
     */
    boolean deleteHistory(@Param("projectId")String projectId,@Param("id")String id);

}

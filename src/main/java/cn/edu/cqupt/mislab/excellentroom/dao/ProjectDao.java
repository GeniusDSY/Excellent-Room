package cn.edu.cqupt.mislab.excellentroom.dao;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

/**
 * @Author HanSiyue
 * @Date 2019/8/25 上午12:24
 */

@Repository
public interface ProjectDao {

    /**
     * 通过项目ID查询项目
     * @param projectId 项目ID
     * @return true
     */
    Boolean selectProjectById(@Param("projectId") String projectId);
}

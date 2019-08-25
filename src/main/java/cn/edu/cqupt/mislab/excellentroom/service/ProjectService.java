package cn.edu.cqupt.mislab.excellentroom.service;

import cn.edu.cqupt.mislab.excellentroom.domain.entity.Project;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;

/**
 * @Author HanSiyue
 * @Date 2019/8/25 上午12:26
 */

@Service
public interface ProjectService {

    /**
     * 通过项目ID查询项目
     * @param projectId 项目ID
     * @return true
     */
    Project selectProjectById(@Param("projectId") String projectId);
}

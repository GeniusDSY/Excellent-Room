package cn.edu.cqupt.mislab.excellentroom.service;

import cn.edu.cqupt.mislab.excellentroom.domain.entity.ClientWant;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author HanSiyue
 * @Date 2019/8/25 下午10:21
 */
@Service
public interface ClientWantService {

    /**
     * 我有意向填写
     * @param projectId 项目ID
     * @param tel 客户电话
     * @param price 意向价格
     * @param type 户型
     * @return true
     */
    Boolean addClientWant(@Param("projectId") String projectId, @Param("tel") String tel, @Param("price") Integer price, @Param("type") Integer type);

    /**
     * 展示所有意向
     * @param projectId
     * @return
     */
    List<ClientWant> findAll(@Param("projectId") String projectId);
}




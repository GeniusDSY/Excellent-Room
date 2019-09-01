package cn.edu.cqupt.mislab.excellentroom.service;

import cn.edu.cqupt.mislab.excellentroom.domain.po.Result;
import org.springframework.stereotype.Service;

public interface IGuidePageService {
    /**
     * 修改背景
     * @param projectId
     * @param pic
     * @return
     */
    Result updateGuidePageBkground(String projectId, String pic);

    /**
     * 查询背景
     * @param projectId
     * @return
     */
    Result searchGuidePageBkground(String projectId);

    /**
     * 修改logo
     * @param projectId
     * @param pic
     * @return
     */
    Result updateGuidePageLogo(String projectId,String pic);

    /**
     * 查询logo
     * @param projectId
     * @return
     */
    Result searchGuidePageLogo(String projectId);

    /**
     * 修改引导页底部信息
     * @param projectId
     * @param developer
     * @param adress
     * @param telephone
     * @return
     */
    Result updateGuidePageInfo(String projectId,String developer,String adress,String telephone);

    /**
     * 查找引导页底部信息
     * @param projectId
     * @return
     */
    Result searchGuidePageInfo(String projectId);
}

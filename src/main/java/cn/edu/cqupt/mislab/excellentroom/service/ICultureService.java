package cn.edu.cqupt.mislab.excellentroom.service;

import cn.edu.cqupt.mislab.excellentroom.domain.po.Result;
import org.springframework.stereotype.Service;

public interface ICultureService {

    /**
     * 修改背景
     * @param projectId
     * @param pic
     * @return
     */
    Result updateCultureBkground(String projectId,String pic);

    /**
     * 查询背景
     * @param projectId
     * @return
     */
    Result searchCultureBkground(String projectId);

    /**
     * 修改图片
     * @param projectId
     * @param pic
     * @return
     */
    Result updateCulturePic(String projectId,String pic);

    /**
     * 查询图片
     * @param projectId
     * @return
     */
    Result searchCulturePic(String projectId);

    /**
     * 增加文化
     * @param projectId
     * @param title
     * @param text
     * @return
     */
    Result addCulture(String projectId,String title,String text);

    /**
     * 删除文化
     * @param projectId
     * @param title
     * @param text
     * @return
     */
    Result deleteCulture(String projectId,String title,String text);

    /**
     * 查询文化
     * @param projectId
     * @return
     */
    Result searchCulture(String projectId);

}

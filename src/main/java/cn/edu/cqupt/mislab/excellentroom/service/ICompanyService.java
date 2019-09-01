package cn.edu.cqupt.mislab.excellentroom.service;

import cn.edu.cqupt.mislab.excellentroom.domain.dto.ProjectId;
import cn.edu.cqupt.mislab.excellentroom.domain.po.CompanyProfiles;
import cn.edu.cqupt.mislab.excellentroom.domain.po.Result;

/**
 * @author: 宋丽
 * @create: 2019-08-16 09:59
 **/
public interface ICompanyService {

    /**
     * 查询轮播图片
     * @param projectId
     * @return
     */
    Result searchCompanyProfilesPic(String projectId);

    /**
     * 增加轮播图片
     * @param projectId
     * @param pic
     * @return
     */
    Result addCompanyProfilesPic(String projectId,String pic);

    /**
     * 删除轮播图片
     * @param projectId
     * @param pic
     * @return
     */
    Result deleteCompanyProfilesPic(String projectId,String pic);

    /**
     * 修改文本
     * @param projectId
     * @param text
     * @return
     */
    Result updateCompanyProfilesText(String projectId,String text);

    /**
     * 查询文本
     * @param projectId
     * @return
     */
    Result searchCompanyProfilesText(String projectId);

    /**
     * 修改视频链接
     * @param projectId
     * @param video
     * @return
     */
    Result updateCompanyProfilesVideo(String projectId,String video);

    /**
     * 查询视频链接
     * @param projectId
     * @return
     */
    Result searchCompanyProfilesVideo(String projectId);

}
package cn.edu.cqupt.mislab.excellentroom.service;

import cn.edu.cqupt.mislab.excellentroom.domain.po.Result;

import java.util.List;

public interface IHonorService {
    /**
     * 更新品牌荣誉背景图片（无删除）
     * @param projectId
     * @param bkground
     * @return
     */
    Result updateHonorBkground(String projectId, String bkground);

    /**
     * 查找品牌荣誉背景图片
     * @param projectId
     * @return
     */
    Result searchHonorBkground(String projectId);
    /**
     * 查找品牌荣誉轮播图片（无更新）
     * @param projectId
     * @return
     */
    Result  searchHonorPic(String projectId);

    /**
     * 查找品牌荣誉轮播文本（无更新）
     * @param projectId
     * @return
     */
    Result  searchHonorText(String projectId);


    /**
     * 删除指定品牌荣誉轮播图片
     * @param projectId
     * @return
     */
    Result deleteHonorPic(String projectId,String pic);

    /**
     * 新增品牌荣誉轮播图片
     * @param projectId
     * @return
     */
    Result addHonorPic(String projectId,String pic);
    /**
     * 删除指定品牌荣誉文本
     * @param projectId
     * @param text
     * @return
     */
    Result deleteHonorText(String projectId,String text);

    /**
     * 新增品牌荣誉文本
     * @param projectId
     * @return
     */
    Result addHonorText(String projectId,String text);

}

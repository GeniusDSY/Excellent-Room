package cn.edu.cqupt.mislab.excellentroom.service;

import cn.edu.cqupt.mislab.excellentroom.domain.po.Result;

public interface IHistoryService {
    /**
     * 修改背景
     * @param projectId
     * @param pic
     * @return
     */
    Result updateHistoryBkground(String projectId, String pic);

    /**
     * 查询背景
     * @param projectId
     * @return
     */
    Result searchHistoryBkground(String projectId);

    /**
     * 查询历程
     * @param projectId
     * @return
     */
    Result searchHistory(String projectId);

    /**
     * 增加历程
     * @param projectId
     * @param pic
     * @param time
     * @param simple
     * @param text
     * @return
     */
    Result addHistory(String projectId,String pic,
         String time,String simple,String text);

    /**
     * 减少历程
     * @param projectId
     * @param id
     * @return
     */
    Result deleteHistory(String projectId,String id);

    /**
     * 修改历程
     * @param projectId
     * @param id
     * @param pic
     * @param time
     * @param simple
     * @param text
     * @return
     */
    Result updateHistory(String projectId,String id,String pic,
         String time,String simple,String text);

}

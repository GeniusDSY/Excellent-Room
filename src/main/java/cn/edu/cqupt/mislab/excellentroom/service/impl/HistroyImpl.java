package cn.edu.cqupt.mislab.excellentroom.service.impl;

import cn.edu.cqupt.mislab.excellentroom.constant.ResultEnum;
import cn.edu.cqupt.mislab.excellentroom.dao.HistoryDao;
import cn.edu.cqupt.mislab.excellentroom.domain.po.History;
import cn.edu.cqupt.mislab.excellentroom.domain.po.Result;
import cn.edu.cqupt.mislab.excellentroom.exception.MyException;
import cn.edu.cqupt.mislab.excellentroom.service.IHistoryService;
import cn.edu.cqupt.mislab.excellentroom.util.ResultUtil;
import cn.edu.cqupt.mislab.excellentroom.util.ServiceUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @program: Excellent-Room-sl-dev
 * @description: 发展历程
 * @author: 宋丽
 * @create: 2019-08-28 04:10
 **/
@Service("History")
public class HistroyImpl implements IHistoryService {
    @Autowired
    private HistoryDao historyDao;

    @Override
    public Result updateHistoryBkground(String projectId, String pic) {
        try {
            Map<String, String> map = new HashMap<>(2);
            ServiceUtil.updateSuccess(historyDao.updateHistoryBkground(projectId,pic));
            map.put("pic",pic);
            return ResultUtil.success(map);
        } catch (MyException e) {
            e.printStackTrace();
            return ResultUtil.error(ResultEnum.UPDATE_ERROR);
        }

    }

    @Override
    public Result searchHistoryBkground(String projectId) {
        try {
            String bkground = historyDao.searchHistoryBkground(projectId);
            if (bkground == null){
                throw new MyException(ResultEnum.SEARCH_ERROR);
            }
            return ResultUtil.success(bkground);
        } catch (MyException e) {
            e.printStackTrace();
            return ResultUtil.error(ResultEnum.SEARCH_ERROR);
        }

    }

    @Override
    public Result searchHistory(String projectId) {
        try {
            List<History> list;
            list = historyDao.searchHistory(projectId);
            if (list.isEmpty()){
                throw new MyException(ResultEnum.SEARCH_ERROR);
            }
            return ResultUtil.success(list);
        } catch (MyException e) {
            return ResultUtil.error(ResultEnum.SEARCH_ERROR);
        }

    }

    @Override
    public Result addHistory(String projectId, String pic, String time, String simple, String text) {

        try {
            Map<String, String> map = new HashMap<>(6);
            ServiceUtil.insertSuccess(historyDao.addHistory(projectId, pic, time, simple, text));
            map.put("projectId",projectId);
            map.put("pic",pic);
            map.put("time",time);
            map.put("simple",simple);
            map.put("text",text);
            return ResultUtil.success(map);
        } catch (MyException e) {
            e.printStackTrace();
            return ResultUtil.error(ResultEnum.UPDATE_ERROR);
        }

    }

    @Override
    public Result deleteHistory(String projectId, String id) {
        try {
            Map<String, String> map = new HashMap<>(3);
            ServiceUtil.deleteSuccess(historyDao.deleteHistory(projectId,id));
            map.put("projectId",projectId);
            map.put("id",id);
            return ResultUtil.success(map);
        } catch (MyException e) {
            e.printStackTrace();
            return ResultUtil.error(ResultEnum.DELETE_ERROR);
        }
    }

    @Override
    public Result updateHistory(String projectId, String id, String pic, String time, String simple, String text) {
        try {
            Map<String, String> map = new HashMap<>(7);
            ServiceUtil.updateSuccess(historyDao.updateHistory(projectId, id, pic, time, simple, text));
            map.put("projectId", projectId);
            map.put("id", id);
            map.put("pic", pic);
            map.put("time", time);
            map.put("simple", simple);
            map.put("text", text);
            return ResultUtil.success(map);
        } catch (MyException e) {
            e.printStackTrace();
            return ResultUtil.error(ResultEnum.UPDATE_ERROR);
        }
    }
}

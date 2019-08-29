package cn.edu.cqupt.mislab.excellentroom.service.impl;

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
@Service
public class HistroyImpl implements IHistoryService {
    @Autowired
    private HistoryDao historyDao;

    @Override
    public Result updateHistoryBkground(String projectId, String pic) {
        Map<String, String> map = new HashMap<>(2);
        try {
            ServiceUtil.updateSuccess(historyDao.updateHistoryBkground(projectId,pic));
            map.put("pic",pic);
        } catch (MyException e) {
            e.printStackTrace();
        }
        return ResultUtil.success(map);
    }

    @Override
    public Result searchHistoryBkground(String projectId) {
        String bkground = historyDao.searchHistoryBkground(projectId);
        return ResultUtil.success(bkground);
    }

    @Override
    public Result searchHistory(String projectId) {
        List<History> list;
        list = historyDao.searchHistory(projectId);
        return ResultUtil.success(list);
    }

    @Override
    public Result addHistory(String projectId, String pic, String time, String simple, String text) {
        Map<String, String> map = new HashMap<>(6);
        try {
            ServiceUtil.insertSuccess(historyDao.addHistory(projectId, pic, time, simple, text));
            map.put("projectId",projectId);
            map.put("pic",pic);
            map.put("time",time);
            map.put("simple",simple);
            map.put("text",text);
        } catch (MyException e) {
            e.printStackTrace();
        }
        return ResultUtil.success(map);
    }

    @Override
    public Result deleteHistory(String projectId, String id) {
        Map<String, String> map = new HashMap<>(3);
        try {
            ServiceUtil.deleteSuccess(historyDao.deleteHistory(projectId,id));
            map.put("projectId",projectId);
            map.put("id",id);
        } catch (MyException e) {
            e.printStackTrace();
        }
        return ResultUtil.success(map);
    }

    @Override
    public Result updateHistory(String projectId, String id, String pic, String time, String simple, String text) {
        Map<String, String> map = new HashMap<>(7);
        try {
            ServiceUtil.updateSuccess(historyDao.updateHistory(projectId, id, pic, time, simple, text));
            map.put("projectId",projectId);
            map.put("id",id);
            map.put("pic",pic);
            map.put("time",time);
            map.put("simple",simple);
            map.put("text",text);
        } catch (MyException e) {
            e.printStackTrace();
        }
        return ResultUtil.success(map);
    }
}

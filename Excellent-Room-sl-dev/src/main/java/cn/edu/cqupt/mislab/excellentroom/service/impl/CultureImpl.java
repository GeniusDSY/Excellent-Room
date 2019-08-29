package cn.edu.cqupt.mislab.excellentroom.service.impl;
import cn.edu.cqupt.mislab.excellentroom.dao.CultureDao;
import cn.edu.cqupt.mislab.excellentroom.domain.po.Culture;
import cn.edu.cqupt.mislab.excellentroom.domain.po.Result;
import cn.edu.cqupt.mislab.excellentroom.exception.MyException;
import cn.edu.cqupt.mislab.excellentroom.service.ICultureService;
import cn.edu.cqupt.mislab.excellentroom.util.ResultUtil;
import cn.edu.cqupt.mislab.excellentroom.util.ServiceUtil;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.*;

/**
 * @program: Excellent-Room-sl-dev
 * @description: 企业文化
 * @author: 宋丽
 * @create: 2019-08-28 04:09
 **/
public class CultureImpl implements ICultureService {
    @Autowired
    private CultureDao cultureDao;

    @Override
    public Result updateCultureBkground(String projectId, String pic) {
        Map<String, String> map = new HashMap<>(2);
        try {
            ServiceUtil.updateSuccess(cultureDao.updateCultureBkground(projectId,pic));
            map.put("pic",pic);
        } catch (MyException e) {
            e.printStackTrace();
        }
        return ResultUtil.success(map);
    }

    @Override
    public Result searchCultureBkground(String projectId) {
        String bkground = cultureDao.searchCultureBkground(projectId);
        return ResultUtil.success(bkground);
    }

    @Override
    public Result updateCulturePic(String projectId, String pic) {
        Map<String, String> map = new HashMap<>(2);
        try {
            ServiceUtil.updateSuccess(cultureDao.updateCulturePic(projectId,pic));
            map.put("pic",pic);
        } catch (MyException e) {
            e.printStackTrace();
        }

        return ResultUtil.success(map);
    }

    @Override
    public Result searchCulturePic(String projectId) {
        String pic = cultureDao.searchCulturePic(projectId);
        Map<String, String> map = new HashMap<>(2);
        map.put("pic",pic);
        return ResultUtil.success(map);
    }

    @Override
    public Result addCulture(String projectId, String title, String text) {
        Map<String, String> map = new HashMap<>(4);
        try {
            ServiceUtil.insertSuccess(cultureDao.addCulture(projectId, title, text));
            map.put("projectId",projectId);
            map.put("title",title);
            map.put("text",text);
        } catch (MyException e) {
            e.printStackTrace();
        }
        return ResultUtil.success(map);
    }

    @Override
    public Result deleteCulture(String projectId, String title, String text) {
        Map<String, String> map = new HashMap<>(4);
        try {
            ServiceUtil.deleteSuccess(cultureDao.deleteCulture(projectId, title, text));
            map.put("projectId",projectId);
            map.put("title",title);
            map.put("text",text);
        } catch (MyException e) {
            e.printStackTrace();
        }
        return ResultUtil.success(map);
    }

    @Override
    public Result searchCulture(String projectId) {
        List<Culture> list;
        list = cultureDao.searchCulture(projectId);
        return ResultUtil.success(list);
    }
}

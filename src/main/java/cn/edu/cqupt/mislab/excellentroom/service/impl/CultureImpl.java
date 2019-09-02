package cn.edu.cqupt.mislab.excellentroom.service.impl;
import cn.edu.cqupt.mislab.excellentroom.constant.ResultEnum;
import cn.edu.cqupt.mislab.excellentroom.dao.CultureDao;
import cn.edu.cqupt.mislab.excellentroom.domain.po.Culture;
import cn.edu.cqupt.mislab.excellentroom.domain.po.Result;
import cn.edu.cqupt.mislab.excellentroom.exception.MyException;
import cn.edu.cqupt.mislab.excellentroom.service.ICultureService;
import cn.edu.cqupt.mislab.excellentroom.util.ResultUtil;
import cn.edu.cqupt.mislab.excellentroom.util.ServiceUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 * @program: Excellent-Room-sl-dev
 * @description: 企业文化
 * @author: 宋丽
 * @create: 2019-08-28 04:09
 **/
@Service("Culture")
public class CultureImpl implements ICultureService {
    @Autowired
    private CultureDao cultureDao;

    @Override
    public Result updateCultureBkground(String projectId, String pic) {
        try {
            Map<String, String> map = new HashMap<>(2);
            ServiceUtil.updateSuccess(cultureDao.updateCultureBkground(projectId,pic));
            map.put("pic",pic);
            return ResultUtil.success(map);
        } catch (MyException e) {
            e.printStackTrace();
            return ResultUtil.error(ResultEnum.NOTEXIST);
        }

    }

    @Override
    public Result searchCultureBkground(String projectId) {
        try {
            String bkground = cultureDao.searchCultureBkground(projectId);
            if (bkground == null){
                throw new MyException(ResultEnum.NOTEXIST);
            }
            return ResultUtil.success(bkground);
        } catch (MyException e) {
            e.printStackTrace();
            return ResultUtil.error(ResultEnum.NOTEXIST);
        }

    }

    @Override
    public Result updateCulturePic(String projectId, String pic) {
        try {
            Map<String, String> map = new HashMap<>(2);
            ServiceUtil.updateSuccess(cultureDao.updateCulturePic(projectId,pic));
            map.put("pic",pic);
            return ResultUtil.success(map);
        } catch (MyException e) {
            e.printStackTrace();
            return ResultUtil.error(ResultEnum.NOTEXIST);
        }


    }

    @Override
    public Result searchCulturePic(String projectId) {
        try {
            String pic = cultureDao.searchCulturePic(projectId);
            Map<String, String> map = new HashMap<>(2);
            map.put("pic",pic);
            if (pic == null){
                throw new MyException(ResultEnum.NOTEXIST);
            }
            return ResultUtil.success(map);
        } catch (MyException e) {
            e.printStackTrace();
            return ResultUtil.error(ResultEnum.NOTEXIST);
        }

    }

    @Override
    public Result addCulture(String projectId, String title, String text) {
        try {
            Map<String, String> map = new HashMap<>(4);
            ServiceUtil.insertSuccess(cultureDao.addCulture(projectId, title, text));
            map.put("projectId",projectId);
            map.put("title",title);
            map.put("text",text);
            return ResultUtil.success(map);
        } catch (MyException e) {
            e.printStackTrace();
            return ResultUtil.error(ResultEnum.ISEXIST);
        }

    }

    @Override
    public Result deleteCulture(String projectId, String title, String text) {
        try {
            Map<String, String> map = new HashMap<>(4);
            ServiceUtil.deleteSuccess(cultureDao.deleteCulture(projectId, title, text));
            map.put("projectId",projectId);
            map.put("title",title);
            map.put("text",text);
            return ResultUtil.success(map);
        } catch (MyException e) {
            e.printStackTrace();
            return ResultUtil.error(ResultEnum.NOTEXIST);
        }

    }

    @Override
    public Result searchCulture(String projectId) {
        try {
            List<Culture> list;
            list = cultureDao.searchCulture(projectId);
            if (list.isEmpty()){
                throw new MyException(ResultEnum.NOTEXIST);
            }
            return ResultUtil.success(list);
        } catch (MyException e) {
            e.printStackTrace();
            return ResultUtil.error(ResultEnum.NOTEXIST);
        }

    }
}

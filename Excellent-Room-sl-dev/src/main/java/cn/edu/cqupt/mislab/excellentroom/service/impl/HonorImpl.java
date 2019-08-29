package cn.edu.cqupt.mislab.excellentroom.service.impl;
import cn.edu.cqupt.mislab.excellentroom.dao.HonorDao;
import cn.edu.cqupt.mislab.excellentroom.domain.po.Result;
import cn.edu.cqupt.mislab.excellentroom.exception.MyException;
import cn.edu.cqupt.mislab.excellentroom.service.IHonorService;
import cn.edu.cqupt.mislab.excellentroom.util.ResultUtil;
import cn.edu.cqupt.mislab.excellentroom.util.ServiceUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @program: Excellent-Room-sl-dev
 * @description: 品牌荣誉
 * @author: 宋丽
 * @create: 2019-08-28 04:10
 **/
@Service
public class HonorImpl implements IHonorService {
    @Autowired
    private HonorDao honorDao;

    @Override
    public Result updateHonorBkground(String projectId, String bkground) {
        Map<String, String> map = new HashMap<>(2);
        try {
            ServiceUtil.updateSuccess(honorDao.updateHonorBkground(projectId,bkground));
            map.put("bkground",bkground);
        } catch (MyException e) {
            e.printStackTrace();
        }
        return ResultUtil.success(map);
    }

    @Override
    public Result searchHonorBkground(String projectId) {
        String pic = honorDao.searchHonorBkground(projectId);
        Map<String, String> map = new HashMap<>(2);
        map.put("pic",pic);
        return ResultUtil.success(map);
    }

    @Override
    public Result searchHonorPic(String projectId) {
        List<String> list;
        list = honorDao.searchHonorPic(projectId);
        return ResultUtil.success(list);
    }

    @Override
    public Result searchHonorText(String projectId) {
        List<String> list;
        list = honorDao.searchHonorText(projectId);
        return ResultUtil.success(list);
    }

    @Override
    public Result deleteHonorPic(String projectId, String pic) {
        Map<String, String> map = new HashMap<>(10);
        try {
            ServiceUtil.deleteSuccess(honorDao.deleteHonorPic(projectId,pic));
            map.put("projectId",projectId);
            map.put("pic",pic);
        } catch (MyException e) {
            e.printStackTrace();
        }
        return ResultUtil.success(map);
    }

    @Override
    public Result addHonorPic(String projectId,String pic) {
        Map<String, String> map = new HashMap<>(4);
        try {
            ServiceUtil.insertSuccess(honorDao.addHonorPic(projectId,pic));
            map.put("projectId",projectId);
            map.put("pic",pic);
        } catch (MyException e) {
            e.printStackTrace();
        }
        return ResultUtil.success(map);
    }

    @Override
    public Result deleteHonorText(String projectId, String text) {
        Map<String, String> map = new HashMap<>(10);
        try {
            ServiceUtil.deleteSuccess(honorDao.deleteHonorPic(projectId,text));
            map.put("projectId",projectId);
            map.put("text",text);
        } catch (MyException e) {
            e.printStackTrace();
        }
        return ResultUtil.success(map);
    }

    @Override
    public Result addHonorText(String projectId, String text) {
        Map<String, String> map = new HashMap<>(4);
        try {
            ServiceUtil.insertSuccess(honorDao.addHonorText(projectId,text));
            map.put("projectId",projectId);
            map.put("text",text);
        } catch (MyException e) {
            e.printStackTrace();
        }
        return ResultUtil.success(map);
    }
}

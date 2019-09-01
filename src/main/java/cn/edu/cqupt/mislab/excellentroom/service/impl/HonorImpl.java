package cn.edu.cqupt.mislab.excellentroom.service.impl;
import cn.edu.cqupt.mislab.excellentroom.constant.ResultEnum;
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
@Service("Honor")
public class HonorImpl implements IHonorService {
    @Autowired
    private HonorDao honorDao;

    @Override
    public Result updateHonorBkground(String projectId, String bkground) {
        try {
            Map<String, String> map = new HashMap<>(2);
            ServiceUtil.updateSuccess(honorDao.updateHonorBkground(projectId,bkground));
            map.put("bkground",bkground);
            return ResultUtil.success(map);
        } catch (MyException e) {
            e.printStackTrace();
            return ResultUtil.error(ResultEnum.UPDATE_ERROR);
        }

    }

    @Override
    public Result searchHonorBkground(String projectId) {
        try {
            String pic = honorDao.searchHonorBkground(projectId);
            Map<String, String> map = new HashMap<>(2);
            map.put("pic",pic);
            if (pic == null){
                throw new MyException(ResultEnum.SEARCH_ERROR);
            }
            return ResultUtil.success(map);
        } catch (MyException e) {
            e.printStackTrace();
            return ResultUtil.error(ResultEnum.SEARCH_ERROR);
        }
    }

    @Override
    public Result searchHonorPic(String projectId) {
        try {
            List<String> list;
            list = honorDao.searchHonorPic(projectId);
            if (list.isEmpty()){
                throw new MyException(ResultEnum.SEARCH_ERROR);
            }
            return ResultUtil.success(list);
        } catch (MyException e) {
            e.printStackTrace();
            return ResultUtil.error(ResultEnum.SEARCH_ERROR);
        }

    }

    @Override
    public Result searchHonorText(String projectId) {
        try {
            List<String> list;
            list = honorDao.searchHonorText(projectId);
            if (list.isEmpty()){
                throw new MyException(ResultEnum.SEARCH_ERROR);
            }
            return ResultUtil.success(list);
        } catch (MyException e) {
            e.printStackTrace();
            return ResultUtil.error(ResultEnum.SEARCH_ERROR);
        }

    }

    @Override
    public Result deleteHonorPic(String projectId, String pic) {
        try {
            Map<String, String> map = new HashMap<>(10);
            ServiceUtil.deleteSuccess(honorDao.deleteHonorPic(projectId,pic));
            map.put("projectId",projectId);
            map.put("pic",pic);
            return ResultUtil.success(map);
        } catch (MyException e) {
            e.printStackTrace();
            return ResultUtil.error(ResultEnum.DELETE_ERROR);
        }

    }

    @Override
    public Result addHonorPic(String projectId,String pic) {
        try {
            Map<String, String> map = new HashMap<>(4);
            ServiceUtil.insertSuccess(honorDao.addHonorPic(projectId,pic));
            map.put("projectId",projectId);
            map.put("pic",pic);
            return ResultUtil.success(map);
        } catch (MyException e) {
            e.printStackTrace();
            return ResultUtil.error(ResultEnum.ADD_ERROR);
        }

    }

    @Override
    public Result deleteHonorText(String projectId, String text) {
        try {
            Map<String, String> map = new HashMap<>(10);
            ServiceUtil.deleteSuccess(honorDao.deleteHonorPic(projectId,text));
            map.put("projectId",projectId);
            map.put("text",text);
            return ResultUtil.success(map);
        } catch (MyException e) {
            e.printStackTrace();
            return ResultUtil.error(ResultEnum.DELETE_ERROR);
        }

    }

    @Override
    public Result addHonorText(String projectId, String text) {
        try {
            Map<String, String> map = new HashMap<>(4);
            ServiceUtil.insertSuccess(honorDao.addHonorText(projectId,text));
            map.put("projectId",projectId);
            map.put("text",text);
            return ResultUtil.success(map);
        } catch (MyException e) {
            e.printStackTrace();
            return ResultUtil.error(ResultEnum.ADD_ERROR);
        }

    }
}

package cn.edu.cqupt.mislab.excellentroom.service.impl;

import cn.edu.cqupt.mislab.excellentroom.constant.ResultEnum;
import cn.edu.cqupt.mislab.excellentroom.dao.GuidePageDao;
import cn.edu.cqupt.mislab.excellentroom.domain.po.GuidePage;
import cn.edu.cqupt.mislab.excellentroom.domain.po.Result;
import cn.edu.cqupt.mislab.excellentroom.exception.MyException;
import cn.edu.cqupt.mislab.excellentroom.service.IGuidePageService;
import cn.edu.cqupt.mislab.excellentroom.util.ResultUtil;
import cn.edu.cqupt.mislab.excellentroom.util.ServiceUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

/**
 * @program: Excellent-Room-sl-dev
 * @description: 引导页业务逻辑
 * @author: 宋丽
 * @create: 2019-08-30 05:00
 **/
@Service("GuidePage")
public class GuidePageImpl implements IGuidePageService {
    @Autowired
    private GuidePageDao guidePageDao;

    @Override
    public Result updateGuidePageBkground(String projectId, String pic) {
        try {
            Map<String, String> map = new HashMap<>(2);
            ServiceUtil.updateSuccess(guidePageDao.updateGuidePageBkground(projectId,pic));
            map.put("bkground",pic);
            return ResultUtil.success(map);
        } catch (MyException e) {
            e.printStackTrace();
            return ResultUtil.error(ResultEnum.NOTEXIST);
        }

    }

    @Override
    public Result searchGuidePageBkground(String projectId) {
        try {
            Map<String,String> map = new HashMap();
            String bkground = guidePageDao.searchGuidePageBkground(projectId);
            map.put("bkground",bkground);
            if (bkground == null){
                throw new MyException(ResultEnum.NOTEXIST);
            }
            return ResultUtil.success(map);
        } catch (MyException e) {
            e.printStackTrace();
            return ResultUtil.error(ResultEnum.NOTEXIST);
        }

    }

    @Override
    public Result updateGuidePageLogo(String projectId, String pic) {
        try {
            Map<String, String> map = new HashMap<>(2);
            ServiceUtil.updateSuccess(guidePageDao.updateGuidePageLogo(projectId,pic));
            map.put("logo",pic);
            return ResultUtil.success(map);
        } catch (MyException e) {
            e.printStackTrace();
            return ResultUtil.error(ResultEnum.NOTEXIST);
        }

    }

    @Override
    public Result searchGuidePageLogo(String projectId) {
        try {
            String bkground = guidePageDao.searchGuidePageLogo(projectId);
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
    public Result updateGuidePageInfo(String projectId, String developer, String adress, String telephone) {
        try {
            ServiceUtil.updateSuccess(guidePageDao.updateGuidePageInfo(projectId, developer, adress, telephone));
            Map<String, String> map = new HashMap<>(5);
            map.put("projectId",projectId);
            map.put("developer",developer);
            map.put("adress",adress);
            map.put("telephone",telephone);
            return ResultUtil.success(map);
        } catch (MyException e) {
            e.printStackTrace();
            return ResultUtil.error(ResultEnum.NOTEXIST);
        }

    }

    @Override
    public Result searchGuidePageInfo(String projectId) {
        try {
            GuidePage info = guidePageDao.searchGuidePageInfo(projectId);
            if (info == null){
                throw new MyException(ResultEnum.NOTEXIST);
            }
            return ResultUtil.success(info);
        } catch (MyException e) {
            e.printStackTrace();
            return ResultUtil.error(ResultEnum.NOTEXIST);
        }

    }
}

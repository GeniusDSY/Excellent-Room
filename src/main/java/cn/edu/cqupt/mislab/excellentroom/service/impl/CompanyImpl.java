package cn.edu.cqupt.mislab.excellentroom.service.impl;
import cn.edu.cqupt.mislab.excellentroom.constant.ResultEnum;
import cn.edu.cqupt.mislab.excellentroom.dao.CompanyDao;
import cn.edu.cqupt.mislab.excellentroom.domain.po.Result;
import cn.edu.cqupt.mislab.excellentroom.exception.MyException;
import cn.edu.cqupt.mislab.excellentroom.service.ICompanyService;
import cn.edu.cqupt.mislab.excellentroom.util.ResultUtil;
import cn.edu.cqupt.mislab.excellentroom.util.ServiceUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;

/**
 * @program: Excellent-Room-sl-dev
 * @description: 企业简述相关服务的实现
 * @author: 宋丽
 * @create: 2019-08-16 07:04
 **/
@Service("Company")
public class CompanyImpl implements ICompanyService {
    @Autowired
    private CompanyDao companyDao;

    @Override
    public Result searchCompanyProfilesPic(String projectId) {
        HashMap<String, String> map = new HashMap<>(2);
        try {
            List<String> pic = companyDao.searchCompanyProfilesPic(projectId);
            for (String p:pic
            ) {
                map.put("pic",p);
            }
            if (pic.isEmpty()){
                throw new MyException(ResultEnum.SEARCH_ERROR);
            }
            return ResultUtil.success(map);
        }catch (MyException e) {
            e.printStackTrace();
            return ResultUtil.error(ResultEnum.SEARCH_ERROR);
        }


    }

    @Override
    public Result addCompanyProfilesPic(String projectId, String pic) {
        HashMap<String, String> map = new HashMap<>(2);
        try {
            ServiceUtil.insertSuccess(companyDao.addCompanyProfilesPic(projectId,pic));
            map.put("pic",pic);
        } catch (MyException e) {
            e.printStackTrace();
        }
        return ResultUtil.success(map);
    }

    @Override
    public Result deleteCompanyProfilesPic(String projectId, String pic) {

        try {
            HashMap<String, String> map = new HashMap<>(2);
            ServiceUtil.deleteSuccess(companyDao.addCompanyProfilesPic(projectId,pic));
            map.put("pic",pic);
            return ResultUtil.success(map);
        } catch (MyException e) {
            e.printStackTrace();
            return ResultUtil.error(ResultEnum.DELETE_ERROR);
        }

    }

    @Override
    public Result updateCompanyProfilesText(String projectId, String text) {
        HashMap<String, String> map = new HashMap<>(2);
        try {
            ServiceUtil.updateSuccess(companyDao.updateCompanyProfilesText(projectId,text));
            map.put("text",text);
        } catch (MyException e) {
            e.printStackTrace();
        }
        return ResultUtil.success(map);
    }

    @Override
    public Result searchCompanyProfilesText(String projectId) {
        try{
            String text = companyDao.searchCompanyProfilesText(projectId);
            HashMap<String, String> map = new HashMap<>(2);
            map.put("text",text);
            if (text == null){
                throw new MyException(ResultEnum.SEARCH_ERROR);
            }
            return ResultUtil.success(map);
        } catch (MyException e) {
            e.printStackTrace();
            return ResultUtil.error(ResultEnum.SEARCH_ERROR);
        }

    }

    @Override
    public Result updateCompanyProfilesVideo(String projectId, String video) {
        try {
            HashMap<String, String> map = new HashMap<>(2);
            ServiceUtil.updateSuccess(companyDao.updateCompanyProfilesVideo(projectId,video));
            map.put("video",video);
            return ResultUtil.success(map);
        } catch (MyException e) {
            e.printStackTrace();
        }
        return ResultUtil.error(ResultEnum.UPDATE_ERROR);

    }

    @Override
    public Result searchCompanyProfilesVideo(String projectId) {
        try {
            String video = companyDao.searchCompanyProfilesVideo(projectId);
            HashMap<String, String> map = new HashMap<>(2);
            map.put("video",video);
            if (video == null){
                throw new MyException(ResultEnum.SEARCH_ERROR);
            }
            return ResultUtil.success(map);
        } catch (MyException e) {
            e.printStackTrace();
            return ResultUtil.error(ResultEnum.SEARCH_ERROR);
        }


    }
}

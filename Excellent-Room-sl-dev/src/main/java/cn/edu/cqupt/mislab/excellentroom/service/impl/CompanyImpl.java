package cn.edu.cqupt.mislab.excellentroom.service.impl;
import cn.edu.cqupt.mislab.excellentroom.dao.CompanyDao;
import cn.edu.cqupt.mislab.excellentroom.domain.po.Result;
import cn.edu.cqupt.mislab.excellentroom.exception.MyException;
import cn.edu.cqupt.mislab.excellentroom.service.ICompanyService;
import cn.edu.cqupt.mislab.excellentroom.util.ResultUtil;
import cn.edu.cqupt.mislab.excellentroom.util.ServiceUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;

/**
 * @program: Excellent-Room-sl-dev
 * @description: 企业简述相关服务的实现
 * @author: 宋丽
 * @create: 2019-08-16 07:04
 **/
@Service
public class CompanyImpl implements ICompanyService {
    @Autowired
    private CompanyDao companyDao;

    @Override
    public Result searchCompanyProfilesPic(String projectId) {
        String pic = companyDao.searchCompanyProfilesPic(projectId);
        HashMap<String, String> map = new HashMap<>(2);
        map.put("pic",pic);
        return ResultUtil.success(map);
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
        HashMap<String, String> map = new HashMap<>(2);
        try {
            ServiceUtil.deleteSuccess(companyDao.addCompanyProfilesPic(projectId,pic));
            map.put("pic",pic);
        } catch (MyException e) {
            e.printStackTrace();
        }
        return ResultUtil.success(map);
    }

    @Override
    public Result updateCompanyProfilesText(String projectId, String text) {
        HashMap<String, String> map = new HashMap<>(2);
        try {
            ServiceUtil.updateSuccess(companyDao.addCompanyProfilesPic(projectId,text));
            map.put("text",text);
        } catch (MyException e) {
            e.printStackTrace();
        }
        return ResultUtil.success(map);
    }

    @Override
    public Result searchCompanyProfilesText(String projectId) {
        String text = companyDao.searchCompanyProfilesText(projectId);
        HashMap<String, String> map = new HashMap<>(2);
        map.put("text",text);
        return ResultUtil.success(map);
    }

    @Override
    public Result updateCompanyProfilesVideo(String projectId, String video) {
        return null;
    }

    @Override
    public Result searchCompanyProfilesVideo(String projectId) {
        String video = companyDao.searchCompanyProfilesVideo(projectId);
        HashMap<String, String> map = new HashMap<>(2);
        map.put("video",video);
        return ResultUtil.success(map);
    }
}

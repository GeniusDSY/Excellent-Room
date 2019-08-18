package cn.edu.cqupt.mislab.excellentroom.service.impl;

import cn.edu.cqupt.mislab.excellentroom.dao.HomePageDao;
import cn.edu.cqupt.mislab.excellentroom.domain.entity.HomePage;
import cn.edu.cqupt.mislab.excellentroom.domain.po.HomePagePo;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import cn.edu.cqupt.mislab.excellentroom.service.HomePageService;

import javax.annotation.Resource;
import java.io.File;

@Service
public class HomePageServiceImpl implements HomePageService {
    @Resource
    private HomePageDao homePageDao;

    @Override
    public Boolean updateHomePageBkground(String homePageBkgroundUrl,String projectId){
        Boolean result = homePageDao.updateHomePageBkground(homePageBkgroundUrl,projectId);
        return result;
    }

    @Override
    public Boolean updateHomePageLogo(String homePageLogoUrl,String projectId){
        Boolean result = homePageDao.updateHomePageLogo(homePageLogoUrl,projectId);
        return result;
    }

    @Override
    public Boolean updateHomePageIcon(String homePageIconUrl,String projectId){
        Boolean result = homePageDao.updateHomePageIcon(homePageIconUrl,projectId);
        return result;
    }


}

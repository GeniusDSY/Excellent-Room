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
    public HomePagePo updateHomePageBkground(String homePageBkgroundUrl,String projectId){
        HomePage homePage = homePageDao.updateHomePageBkground(homePageBkgroundUrl,projectId);
        if (homePage != null){
            HomePagePo homePagePo = new HomePagePo();
            BeanUtils.copyProperties(homePage,homePagePo);
            return homePagePo;
        }else {
            return null;
        }
    }

    @Override
    public HomePagePo updateHomePageLogo(String homePageLogoUrl,String projectId){
        HomePage homePage = homePageDao.updateHomePageLogo(homePageLogoUrl,projectId);
        if (homePage != null){
            HomePagePo homePagePo = new HomePagePo();
            BeanUtils.copyProperties(homePage,homePagePo);
            return homePagePo;
        }else {
            return null;
        }
    }

    @Override
    public HomePagePo updateHomePageIcon(String homePageIconUrl,String projectId){
        HomePage homePage = homePageDao.updateHomePageIcon(homePageIconUrl,projectId);
        if (homePage != null){
            HomePagePo homePagePo = new HomePagePo();
            BeanUtils.copyProperties(homePage,homePagePo);
            return homePagePo;
        }else {
            return null;
        }
    }


}

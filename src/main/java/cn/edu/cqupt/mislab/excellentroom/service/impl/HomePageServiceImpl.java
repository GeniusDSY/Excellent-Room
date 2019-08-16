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

    public HomePagePo updateHomePageBkground(String homePageBkgroundUrl){
        HomePage homePage = homePageDao.updateHomePageBkgound(homePageBkgroundUrl);
        if (homePage != null){
            HomePagePo homePagePo = new HomePagePo();
            BeanUtils.copyProperties(homePage,homePagePo);
            return homePagePo;
        }else {
            return null;
        }
    }

    public HomePagePo updateHomePageLogo(String homePageLogoUrl){
        HomePage homePage = homePageDao.updateHomePageLogo(homePageLogoUrl);
        if (homePage != null){
            HomePagePo homePagePo = new HomePagePo();
            BeanUtils.copyProperties(homePage,homePagePo);
            return homePagePo;
        }else {
            return null;
        }
    }

    public HomePagePo updateHomePageIcon(String homePageIconUrl){
        HomePage homePage = homePageDao.updateHomePageIcon(homePageIconUrl);
        if (homePage != null){
            HomePagePo homePagePo = new HomePagePo();
            BeanUtils.copyProperties(homePage,homePagePo);
            return homePagePo;
        }else {
            return null;
        }
    }


}

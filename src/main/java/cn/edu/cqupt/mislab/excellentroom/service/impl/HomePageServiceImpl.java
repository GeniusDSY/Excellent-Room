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
    public Boolean updateHomePageBkground(String homePageBkgroundUrl,Object projectId){
        Boolean result =homePageDao.updateHomePageBkground(homePageBkgroundUrl,projectId);
        return result;
    }

    @Override
    public Boolean updateHomePageLogo(String homePageLogoUrl,Object projectId){
        Boolean result =homePageDao.updateHomePageLogo(homePageLogoUrl,projectId);
        return result;
    }

    @Override
    public Boolean updateHomePageIcon(String homePageIconUrl,Object projectId){
        Boolean result =homePageDao.updateHomePageIcon(homePageIconUrl,projectId);
        return result;
    }

    @Override
    public HomePagePo selectHomePageBkgroundById(Object projectId){
        HomePage homePage = homePageDao.selectHomePageBkgroundById(projectId);
        if (homePage != null) {
            HomePagePo homePagePo = new HomePagePo();
            BeanUtils.copyProperties(homePage,homePagePo);
            return homePagePo;
        }else{
            return null;
        }
    }

    @Override
    public HomePagePo selectHomePageLogoById(Object projectId){
        HomePage homePage = homePageDao.selectHomePageLogoById(projectId);
        if (homePage != null) {
            HomePagePo homePagePo = new HomePagePo();
            BeanUtils.copyProperties(homePage,homePagePo);
            return homePagePo;
        }else{
            return null;
        }
    }

    @Override
    public HomePagePo selectHomePageIconById(Object projectId, String id){
        HomePage homePage = homePageDao.selectHomePageIconById(projectId,id);
        if (homePage != null) {
            HomePagePo homePagePo = new HomePagePo();
            BeanUtils.copyProperties(homePage,homePagePo);
            return homePagePo;
        }else{
            return null;
        }
    }
}

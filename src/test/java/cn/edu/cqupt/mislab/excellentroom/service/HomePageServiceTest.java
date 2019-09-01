package cn.edu.cqupt.mislab.excellentroom.service;

import cn.edu.cqupt.mislab.excellentroom.domain.entity.HomePage;
import cn.edu.cqupt.mislab.excellentroom.domain.po.HomePagePo;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.Assert.*;

/**
 * @Author HanSiyue
 * @Date 2019/8/18 下午6:24
 */

@RunWith(SpringRunner.class)
@SpringBootTest

public class HomePageServiceTest {

    @Autowired
    private HomePageService homePageService;

    @Transactional
    @Test
    public void updateHomePageBkgroundTest() {
        Boolean result = homePageService.updateHomePageBkground("/Users/mac/picture/pic/12345.png","123");
        Assert.assertTrue(result);
    }

    @Transactional
    @Test
    public void updateHomePageLogoTest() {
        Boolean result = homePageService.updateHomePageLogo("/Users/mac/picture/pic/12345.png","123");
        Assert.assertTrue(result);
    }

    @Transactional
    @Test
    public void updateHomePageIconTest() {
        HomePage homePage = new HomePage();
        homePage.setHomePageIconUrl("/Users/mac/picture/pic/12345.png");
        homePage.setProjectId("123");
        Boolean result = homePageService.updateHomePageIcon(homePage.getHomePageIconUrl(),homePage.getProjectId());
        Assert.assertTrue(result);
    }

    @Test
    public void selectHomePageBkgroundByIdTest() {
        HomePagePo homePagePo = homePageService.selectHomePageBkgroundById("123");
        Assert.assertNotNull(homePagePo.getHomePageBkgroundUrl());

    }

    @Test
    public void selectHomePageLogoByIdTest() {
        HomePagePo homePagepo = homePageService.selectHomePageLogoById("123");
        Assert.assertNotNull(homePagepo.getHomePageLogoUrl());
    }

    @Test
    public void selectHomePageIconByIdTest() {
        HomePagePo homePagepo = homePageService.selectHomePageIconById("123","1");
        Assert.assertNotNull(homePagepo.getHomePageIconUrl());
    }
}
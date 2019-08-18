package cn.edu.cqupt.mislab.excellentroom.dao;

import cn.edu.cqupt.mislab.excellentroom.domain.entity.HomePage;
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
 * @Date 2019/8/18 下午5:54
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class HomePageDaoTest {

    @Autowired
    private HomePageDao homePageDao;

    @Transactional
    @Test
    public void updateHomePageBkgroundTest() {
        Boolean result  = homePageDao.updateHomePageBkground("/Users/mac/picture/pic/12345.png","123");
        Assert.assertTrue(result);
    }

    @Transactional
    @Test
    public void updateHomePageLogoTest() {
        Boolean result = homePageDao.updateHomePageIcon("/Users/mac/picture/pic/12345.png","123");
        Assert.assertTrue(result);
    }

    @Transactional
    @Test
    public void updateHomePageIconTest() {
        Boolean result = homePageDao.updateHomePageIcon("/Users/mac/picture/pic/12345.png","123");
        Assert.assertTrue(result);
    }
}
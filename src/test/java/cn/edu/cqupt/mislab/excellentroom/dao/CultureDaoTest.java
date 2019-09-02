package cn.edu.cqupt.mislab.excellentroom.dao;

import cn.edu.cqupt.mislab.excellentroom.domain.po.Culture;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @program: Excellent-Room-sl-dev
 * @description: 企业文化dao层测试
 * @author: 宋丽
 * @create: 2019-09-01 10:44
 **/
@RunWith(SpringRunner.class)
@SpringBootTest
public class CultureDaoTest {
    @Autowired
    private CultureDao cultureDao;

    private static final String projectId = "abc1";

    @Transactional
    @Test
    public void updateBkground(){
        boolean flag = cultureDao.updateCultureBkground(projectId,"111");
        Assert.assertTrue(flag);
    }

    @Transactional
    @Test
    public void updatePic(){
        boolean flag = cultureDao.updateCulturePic(projectId,"111");
        Assert.assertTrue(flag);
    }

    @Transactional
    @Test
    public void searchBkground(){
        String test = cultureDao.searchCultureBkground(projectId);
        System.out.println(test);
    }

    @Transactional
    @Test
    public void searchPic(){
        String test = cultureDao.searchCulturePic(projectId);
        System.out.println(test);
    }

    @Transactional
    @Test
    public void searchCulture() {
        List<Culture> test = cultureDao.searchCulture(projectId);
        for (Culture c : test
        ) {
            System.out.println(c.toString());
        }
    }

    @Transactional
    @Test
    public void deleteCulture(){
        boolean flag = cultureDao.deleteCulture(projectId,"t1","tt1");
        Assert.assertTrue(flag);
    }

    @Transactional
    @Test
    public void addCulture(){
        boolean flag = cultureDao.addCulture("abc2","t3","tt3");
                Assert.assertTrue(flag);
    }

}

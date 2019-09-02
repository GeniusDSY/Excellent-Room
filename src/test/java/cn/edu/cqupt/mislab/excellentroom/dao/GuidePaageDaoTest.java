package cn.edu.cqupt.mislab.excellentroom.dao;

import cn.edu.cqupt.mislab.excellentroom.domain.po.Culture;
import cn.edu.cqupt.mislab.excellentroom.domain.po.GuidePage;
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
 * @description: 引导页dao层测试
 * @author: 宋丽
 * @create: 2019-09-01 13:45
 **/
@RunWith(SpringRunner.class)
@SpringBootTest
public class GuidePaageDaoTest {
    @Autowired
    private GuidePageDao guidePageDao;

    private static final String projectId = "abc1";

    @Transactional
    @Test
    public void updateBkground(){
        boolean flag = guidePageDao.updateGuidePageBkground(projectId,"111");
        Assert.assertTrue(flag);
    }

    @Transactional
    @Test
    public void updateLogo(){
        boolean flag = guidePageDao.updateGuidePageLogo(projectId,"111");
        Assert.assertTrue(flag);
    }

    @Transactional
    @Test
    public void update(){
        boolean flag = guidePageDao.updateGuidePageInfo(projectId,"t1","tt1","ttt1");
        Assert.assertTrue(flag);
    }

    @Transactional
    @Test
    public void searchBkground(){
        String test = guidePageDao.searchGuidePageBkground(projectId);
        System.out.println(test);
    }

    @Transactional
    @Test
    public void searchLogo(){
        String test = guidePageDao.searchGuidePageLogo(projectId);
        System.out.println(test);
    }

    @Transactional
    @Test
    public void searchInfo() {
        GuidePage test = guidePageDao.searchGuidePageInfo(projectId);
        System.out.println(test.toString());
    }
}


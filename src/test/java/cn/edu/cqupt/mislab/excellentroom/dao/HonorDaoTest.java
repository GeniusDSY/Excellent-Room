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
 * @description: 品牌荣誉dao层测试
 * @author: 宋丽
 * @create: 2019-09-01 11:11
 **/
@RunWith(SpringRunner.class)
@SpringBootTest
public class HonorDaoTest {
    @Autowired
    private HonorDao honorDao;

    private static final String projectId = "abc1";

    @Transactional
    @Test
    public void updateBkground(){
        boolean flag = honorDao.updateHonorBkground(projectId,"111");
        Assert.assertTrue(flag);
    }


    @Transactional
    @Test
    public void searchBkground(){
        String test = honorDao.searchHonorBkground(projectId);
        System.out.println(test);
    }

    @Transactional
    @Test
    public void searchPic(){
        List<String> test = honorDao.searchHonorPic(projectId);
        System.out.println(test);
    }

    @Transactional
    @Test
    public void searchCulture() {
        List<String> test = honorDao.searchHonorText(projectId);
        System.out.println(test);
    }

    @Transactional
    @Test
    public void deletePic(){
        boolean flag = honorDao.deleteHonorPic(projectId,"p1");
        Assert.assertTrue(flag);
    }

    @Transactional
    @Test
    public void deleteText(){
        boolean flag = honorDao.deleteHonorText(projectId,"t3");
        Assert.assertTrue(flag);
    }

    @Transactional
    @Test
    public void addText(){
        boolean flag = honorDao.addHonorText(projectId,"t4");
        Assert.assertTrue(flag);
    }

    @Transactional
    @Test
    public void addPic(){
        boolean flag = honorDao.addHonorPic(projectId,"p3");
        Assert.assertTrue(flag);
    }

}


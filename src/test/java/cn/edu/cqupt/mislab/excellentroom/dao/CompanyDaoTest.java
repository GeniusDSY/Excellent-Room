package cn.edu.cqupt.mislab.excellentroom.dao;

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
 * @description: 企业简介Dao层测试
 * @author: 宋丽
 * @create: 2019-09-01 09:46
 **/
@RunWith(SpringRunner.class)
@SpringBootTest
public class CompanyDaoTest {
    @Autowired
    private CompanyDao companyDao;

    @Transactional
    @Test
    public void updateVideo(){
        String projectId = "123";
        String video = "video";
        boolean flag = companyDao.updateCompanyProfilesVideo(projectId,video);
        Assert.assertTrue(flag);
    }

    @Transactional
    @Test
    public void updateText(){
        String projectId = "abc1";
        String video = "video";
        boolean flag = companyDao.updateCompanyProfilesText(projectId,video);
        Assert.assertTrue(flag);
    }

    @Transactional
    @Test
    public void searchVideo(){
        String projectId = "ab1c";
        String video = companyDao.searchCompanyProfilesVideo(projectId);
        System.out.println(video);
    }

    @Transactional
    @Test
    public void searchText(){
        String projectId = "abc1";
        String text = companyDao.searchCompanyProfilesText(projectId);
        System.out.println(text);
    }

    @Transactional
    @Test
    public void searchPic(){
        String projectId = "abc1";
        List<String> pic = companyDao.searchCompanyProfilesPic(projectId);
        System.out.println(pic);
    }

    @Transactional
    @Test
    public void addPic(){
        String projectId = "abc1";
        boolean flag = companyDao.addCompanyProfilesPic(projectId,"444");
        Assert.assertTrue(flag);
    }

    @Transactional
    @Test
    public void deletePic(){
        String projectId = "abc1";
        boolean flag = companyDao.deleteCompanyProfilesPic(projectId,"111");
        Assert.assertTrue(flag);
    }


}

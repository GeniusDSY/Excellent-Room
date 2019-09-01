package cn.edu.cqupt.mislab.excellentroom.service;

import cn.edu.cqupt.mislab.excellentroom.domain.po.Result;
import cn.edu.cqupt.mislab.excellentroom.service.impl.ProjectServiceImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

/**
 * @program: Excellent-Room-sl-dev
 * @description: 企业简介service测试
 * @author: 宋丽
 * @create: 2019-09-01 14:01
 **/
@RunWith(SpringRunner.class)
@SpringBootTest
public class CompanyServiceImplTest {

    @Autowired
    private ICompanyService iCompanyService;

    private static final String projectId = "abc1";
    private static final String wrong = "wrong";


    @Transactional
    @Test
    public void updateText(){
        Result test = iCompanyService.updateCompanyProfilesText(projectId,"111");
        System.out.println(test.toString());
    }

    @Transactional
    @Test
    public void updateVideo(){
        Result test = iCompanyService.updateCompanyProfilesVideo(projectId,"111");
        //Result test = iCompanyService.updateCompanyProfilesVideo(wrong,"111");
        System.out.println(test.toString());
    }

    @Transactional
    @Test
    public void addPic(){
        Result test = iCompanyService.addCompanyProfilesPic(projectId,"111");
        //Result test = iCompanyService.updateCompanyProfilesVideo(wrong,"111");
        System.out.println(test.toString());
    }

    @Transactional
    @Test
    public void searchPic(){
        //Result test = iCompanyService.searchCompanyProfilesPic(projectId);
        Result test = iCompanyService.searchCompanyProfilesPic(wrong);
        System.out.println(test.toString());
    }

    @Transactional
    @Test
    public void searchText(){
        //Result test = iCompanyService.searchCompanyProfilesText(projectId);
        Result test = iCompanyService.searchCompanyProfilesText(wrong);
        System.out.println(test.toString());
    }

    @Transactional
    @Test
    public void searchVideo(){
        //Result test = iCompanyService.searchCompanyProfilesVideo(projectId);
        Result test = iCompanyService.searchCompanyProfilesVideo(wrong);
        System.out.println(test.toString());
    }

    @Transactional
    @Test
    public void deletePic(){
        //Result test = iCompanyService.deleteCompanyProfilesPic(projectId,"111");
        Result test = iCompanyService.deleteCompanyProfilesPic(wrong,"111");
        System.out.println(test.toString());
    }
}

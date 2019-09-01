package cn.edu.cqupt.mislab.excellentroom.service;

import cn.edu.cqupt.mislab.excellentroom.domain.po.Result;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

/**
 * @program: Excellent-Room-sl-dev
 * @description: 企业文化service测试
 * @author: 宋丽
 * @create: 2019-09-01 15:13
 **/
@RunWith(SpringRunner.class)
@SpringBootTest
public class CultureServiceImplTest {
    @Autowired
    private ICultureService iCultureService;

    private static final String projectId = "abc1";
    private static final String wrong = "wrong";


    @Transactional
    @Test
    public void updateBkground() {
        //Result test = iCultureService.updateCultureBkground(projectId, "111");
        Result test = iCultureService.updateCultureBkground(wrong,"111");
        System.out.println(test.toString());
    }

    @Transactional
    @Test
    public void updatePic() {
        Result test = iCultureService.updateCulturePic(projectId, "111");
        //Result test = iCultureService.updateCulturePic(wrong,"111");
        System.out.println(test.toString());
    }

    @Transactional
    @Test
    public void addCulture() {
        Result test = iCultureService.addCulture(projectId, "111","11");
        System.out.println(test.toString());
    }

    @Transactional
    @Test
    public void searchCulture() {
        Result test = iCultureService.searchCulture(projectId);
        //Result test = iCultureService.searchCulture(wrong);
        System.out.println(test.toString());
    }

    @Transactional
    @Test
    public void searchBkground() {
        Result test = iCultureService.searchCultureBkground(projectId);
        //Result test = iCultureService.searchCultureBkground(wrong);
        System.out.println(test.toString());
    }

    @Transactional
    @Test
    public void searchPic() {
        Result test = iCultureService.searchCulturePic(projectId);
        //Result test = iCultureService.searchCulturePic(wrong);
        System.out.println(test.toString());
    }

    @Transactional
    @Test
    public void deletePic() {
        Result test = iCultureService.deleteCulture(projectId,"t1","tt1");
        //Result test = iCultureService.deleteCulture(wrong, "111","222");
        System.out.println(test.toString());
    }
}
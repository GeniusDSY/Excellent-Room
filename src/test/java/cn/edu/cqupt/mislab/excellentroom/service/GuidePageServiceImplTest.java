package cn.edu.cqupt.mislab.excellentroom.service;

import cn.edu.cqupt.mislab.excellentroom.domain.po.Result;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

/**
 * @program: Excellent-Room-sl-dev
 * @description: 引导页service测试
 * @author: 宋丽
 * @create: 2019-09-01 16:44
 **/
@RunWith(SpringRunner.class)
@SpringBootTest
public class GuidePageServiceImplTest {
    @Autowired
    private IGuidePageService iGuidePageService;

    private static final String projectId = "abc1";
    private static final String wrong = "wrong";


    @Transactional
    @Test
    public void updateBkground() {
        //Result test = iGuidePageService.updateGuidePageBkground(projectId, "111");
        Result test = iGuidePageService.updateGuidePageBkground(wrong,"111");
        System.out.println(test.toString());
    }

    @Transactional
    @Test
    public void updateLogo() {
        Result test = iGuidePageService.updateGuidePageLogo(projectId, "111");
        //Result test = iGuidePageService.updateGuidePageLogo(wrong,"111");
        System.out.println(test.toString());
    }

    @Transactional
    @Test
    public void updateInfo() {
        //Result test = iGuidePageService.updateGuidePageInfo(projectId, "111","11","1111");
        Result test = iGuidePageService.updateGuidePageInfo(wrong, "111","11","1111");
        System.out.println(test.toString());
    }

    @Transactional
    @Test
    public void searchBkground() {
        Result test = iGuidePageService.searchGuidePageBkground(projectId);
        //Result test = iGuidePageService.searchGuidePageBkground(wrong);
        System.out.println(test.toString());
    }

    @Transactional
    @Test
    public void searchInfo() {
        Result test = iGuidePageService.searchGuidePageInfo(projectId);
        //Result test = iGuidePageService.searchGuidePageInfo(wrong);
        System.out.println(test.toString());
    }

    @Transactional
    @Test
    public void searchLogo() {
        Result test = iGuidePageService.searchGuidePageLogo(projectId);
        //Result test = iGuidePageService.searchGuidePageLogo(wrong);
        System.out.println(test.toString());
    }
}


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
 * @description: 品牌荣誉service测试
 * @author: 宋丽
 * @create: 2019-09-01 16:26
 **/
@RunWith(SpringRunner.class)
@SpringBootTest
public class HonorServiceImplTest {
    @Autowired
    private IHonorService iHonorService;

    private static final String projectId = "abc1";
    private static final String wrong = "wrong";


    @Transactional
    @Test
    public void updateBkground() {
        Result test = iHonorService.updateHonorBkground(projectId, "111");
        //Result test = iHonorService.updateHonorBkground(wrong, "111");
        System.out.println(test.toString());
    }

    @Transactional
    @Test
    public void addPic() {
        Result test = iHonorService.addHonorPic(projectId, "111");
        System.out.println(test.toString());
    }

    @Transactional
    @Test
    public void addText() {
        Result test = iHonorService.addHonorText(projectId, "111");
        System.out.println(test.toString());
    }

    @Transactional
    @Test
    public void searchBkground() {
        Result test = iHonorService.searchHonorBkground(projectId);
        //Result test = iHonorService.searchHonorBkground(wrong);
        System.out.println(test.toString());
    }

    @Transactional
    @Test
    public void searchPic() {
        Result test = iHonorService.searchHonorPic(projectId);
        //Result test = iHonorService.searchHonorPic(wrong);
        System.out.println(test.toString());
    }

    @Transactional
    @Test
    public void searchText() {
        Result test = iHonorService.searchHonorText(projectId);
        //Result test = iHonorService.searchHonorText(wrong);
        System.out.println(test.toString());
    }
}


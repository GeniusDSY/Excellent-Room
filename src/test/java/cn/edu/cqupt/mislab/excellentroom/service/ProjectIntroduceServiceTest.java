package cn.edu.cqupt.mislab.excellentroom.service;

import cn.edu.cqupt.mislab.excellentroom.domain.entity.ProjectIntroduce;
import cn.edu.cqupt.mislab.excellentroom.domain.po.ProjectIntroducePo;
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
 * @Date 2019/9/1 上午10:54
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class ProjectIntroduceServiceTest {

    @Autowired
    private ProjectIntroduceService projectIntroduceService;

    @Transactional
    @Test
    public void updateProjectIntroduceBkgroundUrl() {
        Boolean result = projectIntroduceService.updateProjectIntroduceBkgroundUrl("34567890-","123");
        Assert.assertTrue(result);
    }

    @Test
    public void selectProjectIntroduceBkgroundById() {
        ProjectIntroducePo projectIntroducePo = projectIntroduceService.selectProjectIntroduceBkgroundById("123");
        Assert.assertNotNull(projectIntroducePo.getProjectIntroduceBkgroundUrl());
    }

    @Transactional
    @Test
    public void updateProjectIntroduceText() {
        Boolean result = projectIntroduceService.updateProjectIntroduceText("2ertyu","123");
        Assert.assertTrue(result);
    }

    @Test
    public void selectProjectIntroduceTextById() {
        ProjectIntroducePo projectIntroducePo = projectIntroduceService.selectProjectIntroduceTextById("123");
        Assert.assertNotNull(projectIntroducePo.getProjectIntroduceText());
    }

    @Transactional
    @Test
    public void updateProjectIntroduceTitle() {
        Boolean result = projectIntroduceService.updateProjectIntroduceTitle("3456789","123");
        Assert.assertTrue(result);
    }

    @Test
    public void selectProjectIntroduceTitleById() {
        ProjectIntroducePo projectIntroducePo = projectIntroduceService.selectProjectIntroduceTitleById("123");
        Assert.assertNotNull(projectIntroducePo);
    }

}
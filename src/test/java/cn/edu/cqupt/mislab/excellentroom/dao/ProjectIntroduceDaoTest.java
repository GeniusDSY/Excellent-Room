package cn.edu.cqupt.mislab.excellentroom.dao;

import cn.edu.cqupt.mislab.excellentroom.domain.entity.ProjectIntroduce;
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
 * @Date 2019/9/1 上午10:47
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class ProjectIntroduceDaoTest {

    @Autowired
    private ProjectIntroduceDao projectIntroduceDao;

    @Transactional
    @Test
    public void updateProjectIntroduceBkgroundUrl() {
        Boolean result = projectIntroduceDao.updateProjectIntroduceBkgroundUrl("34567890-","123");
        Assert.assertTrue(result);
    }

    @Test
    public void selectProjectIntroduceBkgroundById() {
        ProjectIntroduce projectIntroduce = projectIntroduceDao.selectProjectIntroduceBkgroundById("123");
        Assert.assertNotNull(projectIntroduce.getProjectIntroduceBkgroundUrl());
    }

    @Transactional
    @Test
    public void updateProjectIntroduceText() {
        Boolean result = projectIntroduceDao.updateProjectIntroduceText("2ertyu","123");
        Assert.assertTrue(result);
    }

    @Test
    public void selectProjectIntroduceTextById() {
        ProjectIntroduce projectIntroduce = projectIntroduceDao.selectProjectIntroduceTextById("123");
        Assert.assertNotNull(projectIntroduce.getProjectIntroduceText());
    }

    @Transactional
    @Test
    public void updateProjectIntroduceTitle() {
        Boolean result = projectIntroduceDao.updateProjectIntroduceTitle("3456789","123");
        Assert.assertTrue(result);
    }

    @Test
    public void selectProjectIntroduceTitleById() {
        ProjectIntroduce projectIntroduce = projectIntroduceDao.selectProjectIntroduceTitleById("123");
        Assert.assertNotNull(projectIntroduce);
    }
}
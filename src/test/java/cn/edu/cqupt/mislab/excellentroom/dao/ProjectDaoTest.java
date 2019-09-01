package cn.edu.cqupt.mislab.excellentroom.dao;

import cn.edu.cqupt.mislab.excellentroom.domain.entity.Project;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

/**
 * @Author HanSiyue
 * @Date 2019/9/1 上午9:59
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class ProjectDaoTest {

    @Autowired
    private ProjectDao projectDao;
    @Test
    public void selectProjectById() {
        Project project = projectDao.selectProjectById("123");
        Assert.assertNotNull(project);
    }
}
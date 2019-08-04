package cn.edu.cqupt.mislab.excellentroom.dao;

import cn.edu.cqupt.mislab.excellentroom.domain.entity.Project;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.io.File;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ProjectDaoTest {

    @Autowired
    private ProjectDao projectDao;

    @Transactional
    @Test
    public void addProject(){
        String file = "C:\\Users\\ASUS-PC\\Desktop\\乱\\5.jpg";
        Boolean project = projectDao.addProject("123","123","123","123","123","123",file);
        Assert.assertTrue(project);
    }
}

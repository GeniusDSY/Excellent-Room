package cn.edu.cqupt.mislab.excellentroom.dao;

import cn.edu.cqupt.mislab.excellentroom.domain.dto.ProjectId;
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
        Boolean flag = projectDao.addProject("123","123","123","123","123","123");
        Assert.assertTrue(flag);
    }

    @Transactional
    @Test
    public void deleteProject(){
        ProjectId projectId = new ProjectId("123");
        Boolean flag = projectDao.deleteProject(projectId);
        Assert.assertTrue(flag);
    }
}

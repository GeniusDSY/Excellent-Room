package cn.edu.cqupt.mislab.excellentroom.service;

import cn.edu.cqupt.mislab.excellentroom.domain.entity.Project;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

/**
 * @program: Excellent-Room-sl-dev
 * @description: 项目管理服务的测试类
 * @author: 宋丽
 * @create: 2019-08-04 06:49
 **/
@RunWith(SpringRunner.class)
@SpringBootTest
public class ProjectServiceImplTest {
    
    @Autowired
    private ProjectServiceImpl projectService;

    @Transactional
    @Test
    public void newProjectTest(){
        Project project = new Project("111","111","111","111","111","111","111");
        projectService.newProject(project);
    }
}

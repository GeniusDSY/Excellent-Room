package cn.edu.cqupt.mislab.excellentroom.service;

import cn.edu.cqupt.mislab.excellentroom.domain.dto.ProjectId;
import cn.edu.cqupt.mislab.excellentroom.domain.entity.Project;
import cn.edu.cqupt.mislab.excellentroom.exception.MyException;
import cn.edu.cqupt.mislab.excellentroom.service.impl.ProjectServiceImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;
import org.apache.http.entity.ContentType;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

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
        Project project = new Project("111","111","111","111","111","111");
        projectService.newProject(project);
    }

    @Transactional
    @Test
    public void deleteProjectTest(){
        ProjectId projectId = new ProjectId("string1");
        projectService.deleteProject(projectId);
    }

    @Transactional
    @Test
    public void updateProjectTest() throws MyException {
        Project project = new Project("string1","111","111","111","111","111");
        projectService.updateProject(project);
    }

    @Transactional
    @Test
    public void searchProjectTest1() throws MyException {
        projectService.searchProject("string1");
    }

    @Transactional
    @Test
    public void searchProjectTest2() throws MyException {
        projectService.searchProject("string","string");
    }

    @Transactional
    @Test
    public void QRStatusUploadTest() {
        MockHttpServletRequest request = new MockHttpServletRequest();
        File file = new File("D:\\英雄时刻\\ac4_Wallpaper3_1280x720.jpg");
        FileInputStream fileInputStream = null;
        try {
            fileInputStream = new FileInputStream(file);
            MultipartFile multipartFile = new MockMultipartFile(file.getName(), file.getName(),
                    ContentType.APPLICATION_OCTET_STREAM.toString(), fileInputStream);
            System.out.println(projectService.QRStatusUpload(multipartFile,request));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}

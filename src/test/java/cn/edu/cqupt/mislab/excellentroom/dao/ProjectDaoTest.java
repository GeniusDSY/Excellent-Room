package cn.edu.cqupt.mislab.excellentroom.dao;

import cn.edu.cqupt.mislab.excellentroom.domain.dto.ProjectId;
import cn.edu.cqupt.mislab.excellentroom.domain.entity.Project;
import cn.edu.cqupt.mislab.excellentroom.util.GetUtil;
import org.apache.http.entity.ContentType;
import cn.edu.cqupt.mislab.excellentroom.domain.entity.Project;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.mock.web.MockMultipartHttpServletRequest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

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

    @Transactional
    @Test
    public void addProject(){
        Boolean flag = projectDao.addProject("123","123","123","123","123","123");
        Assert.assertTrue(flag);
    }

    @Transactional
    @Test
    public void deleteProject(){
        ProjectId projectId = new ProjectId("string2");
        Boolean flag = projectDao.deleteProject(projectId.getProjectId());
        Assert.assertTrue(flag);
    }

    @Transactional
    @Test
    public void updateProject(){
        int flag = projectDao.updateProject("string","123","123","123","123","123");
        System.out.println("更新测试");
        System.out.println(flag);
    }

    @Transactional
    @Test
    public void searchProjectByOne(){
        List flag = projectDao.searchProjectByOne("string");
        for (Object p:flag
             ) {
            System.out.println(p.toString());
        }
    }

    @Transactional
    @Test
    public void searchProjectByTwo(){
        List flag = projectDao.searchProjectByTwo("string","string");
        for (Object p:flag
        ) {
            System.out.println(p.toString());
        }
    }

    @Transactional
    @Test
    public void QRcodeUpload(){
        String projectId = "123";
        String QRcode = "D:\\英雄时刻\\ac4_Wallpaper3_1280x720.jpg";
        boolean flag = projectDao.QRcodeUpload(projectId,QRcode);

    }
}
    @Test
    public void selectProjectById() {
        Project project = projectDao.selectProjectById("123");
        Assert.assertNotNull(project);
    }
}

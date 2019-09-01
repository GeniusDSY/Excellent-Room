package cn.edu.cqupt.mislab.excellentroom.service;

import cn.edu.cqupt.mislab.excellentroom.domain.entity.Landscape;
import cn.edu.cqupt.mislab.excellentroom.domain.entity.PublicUtility;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.junit.Assert.*;

/**
 * @Author HanSiyue
 * @Date 2019/9/1 上午11:05
 */

@RunWith(SpringRunner.class)
@SpringBootTest
public class SurroundServiceTest {

    @Autowired
    private SurroundService surroundService;

    @Transactional
    @Test
    public void addLandscape() {
        Boolean result = surroundService.addLandscape("123","1234567","sdfghjk");
        Assert.assertTrue(result);
    }

    @Transactional
    @Test
    public void deleteLandscapeById() {
        Boolean result = surroundService.deleteLandscapeById("123",1);
        Assert.assertTrue(result);
    }

    @Test
    public void selectLandscapeById() {
        Landscape landscape = surroundService.selectLandscapeById("123",1);
        Assert.assertNotNull(landscape);
    }

    @Test
    public void selectPublicUtilityById() {
        PublicUtility publicUtility = surroundService.selectPublicUtilityById("123",1);
        Assert.assertNotNull(publicUtility);
    }

    @Test
    public void findAllLandscape() {
        List<Landscape> landscapes = surroundService.findAllLandscape("123");
        Assert.assertNotNull(landscapes);
    }

    @Transactional
    @Test
    public void addPublicUtility() {
        Boolean result = surroundService.addPublicUtility("123","dfghjkl","23456789");
        Assert.assertTrue(result);
    }

    @Transactional
    @Test
    public void deletePublicUtilityById() {
        Boolean result = surroundService.deletePublicUtilityById("123",1);
        Assert.assertTrue(result);
    }

    @Test
    public void findAllPublicUtility() {
        List<PublicUtility> publicUtilities = surroundService.findAllPublicUtility("123");
        Assert.assertNotNull(publicUtilities);
    }

}
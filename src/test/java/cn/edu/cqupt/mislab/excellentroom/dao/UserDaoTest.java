package cn.edu.cqupt.mislab.excellentroom.dao;

import cn.edu.cqupt.mislab.excellentroom.domain.entity.User;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.Assert.*;
@RunWith(SpringRunner.class)
@SpringBootTest
public class UserDaoTest {
    @Autowired
    private UserDao userDao;

    @Test
    public void loginTest() {
        User user = userDao.login("hsy","123456");
        Assert.assertNotNull(user);
    }

    @Transactional
    @Test
    public void addTest() {
        Boolean result = userDao.addUser("sl","234567");
        Assert.assertTrue(result);
    }

    @Transactional
    @Test
    public void deleteTest() {
        Boolean result = userDao.deleteUserByuserName("hsy");
        Assert.assertTrue(result);
    }

}
package cn.edu.cqupt.mislab.excellentroom.service;

import cn.edu.cqupt.mislab.excellentroom.domain.dto.UserDto;
import cn.edu.cqupt.mislab.excellentroom.domain.po.UserPo;
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

public class UserServiceTest {
    @Autowired
    private UserService userService;

    @Test
    public void loginTest() {
        UserDto userDto = new UserDto();
        userDto.setUserName("hsy");
        userDto.setPassword("123456");
        UserPo userPo = userService.login(userDto);

        Assert.assertNotNull(userPo);
    }

    @Transactional
    @Test
    public void addTest() {
        UserDto userDto = new UserDto();
        userDto.setUserName("sl");
        userDto.setPassword("234567");
        Boolean result = userService.add(userDto);
        Assert.assertTrue(result);
    }

    @Transactional
    @Test
    public void deleteTest() {
        Boolean result = userService.delete("hsy");
        Assert.assertTrue(result);
    }
}

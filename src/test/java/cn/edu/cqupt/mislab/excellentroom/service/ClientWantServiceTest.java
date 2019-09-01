package cn.edu.cqupt.mislab.excellentroom.service;

import cn.edu.cqupt.mislab.excellentroom.domain.entity.ClientWant;
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
 * @Date 2019/9/1 上午10:12
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class ClientWantServiceTest {

    @Autowired
    private ClientWantService clientWantService;

    @Test
    public void selectClientWantByProjectId() {
        ClientWant clientWant = clientWantService.selectClientWantByProjectId("123");
        Assert.assertNotNull(clientWant);
    }

    @Transactional
    @Test
    public void addClientWant() {
        Boolean result = clientWantService.addClientWant("123","1111111",12,1);
        Assert.assertTrue(result);
    }

    @Test
    public void findAll() {
        List<ClientWant> clientWants = clientWantService.findAll("123");
        Assert.assertNotNull(clientWants);
    }
}
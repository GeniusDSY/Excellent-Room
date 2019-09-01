package cn.edu.cqupt.mislab.excellentroom.dao;

import cn.edu.cqupt.mislab.excellentroom.domain.po.Culture;
import cn.edu.cqupt.mislab.excellentroom.domain.po.History;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @program: Excellent-Room-sl-dev
 * @description: 历史进程dao层测试
 * @author: 宋丽
 * @create: 2019-09-01 11:22
 **/
@RunWith(SpringRunner.class)
@SpringBootTest
public class HistoryDaoTest {
    @Autowired
    private HistoryDao historyDao;

    private static final String projectId = "abc1";

    @Transactional
    @Test
    public void updateBkground() {
        boolean flag = historyDao.updateHistoryBkground(projectId, "111");
        Assert.assertTrue(flag);
    }



    @Transactional
    @Test
    public void searchBkground() {
        String test = historyDao.searchHistoryBkground(projectId);
        System.out.println(test);
    }

    @Transactional
    @Test
    public void updateHistory() {
        boolean flag = historyDao.updateHistory(projectId,"1","p1","t1","s1","tt1");
        Assert.assertTrue(flag);
    }

    @Transactional
    @Test
    public void searchHistory() {
        List<History> test = historyDao.searchHistory(projectId);
        for (History h:test
             ) {
            System.out.println(h.toString());
        }
    }

    @Transactional
    @Test
    public void deleteHistory() {
        boolean flag = historyDao.deleteHistory(projectId, "1");
        Assert.assertTrue(flag);
    }

    @Transactional
    @Test
    public void addHistory() {
        boolean flag = historyDao.addHistory(projectId,"p3","t3","s3","tt3");
        Assert.assertTrue(flag);
    }
}

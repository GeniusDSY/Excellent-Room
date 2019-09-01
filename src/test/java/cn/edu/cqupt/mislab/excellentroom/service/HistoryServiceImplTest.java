package cn.edu.cqupt.mislab.excellentroom.service;

import cn.edu.cqupt.mislab.excellentroom.domain.po.Result;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

/**
 * @program: Excellent-Room-sl-dev
 * @description: 历史进程service测试
 * @author: 宋丽
 * @create: 2019-09-01 15:59
 **/
@RunWith(SpringRunner.class)
@SpringBootTest
public class HistoryServiceImplTest {
    @Autowired
    private IHistoryService iHistoryService;

    private static final String projectId = "abc1";
    private static final String wrong = "wrong";


    @Transactional
    @Test
    public void updateBkground() {
        //Result test = iHistoryService.updateHistoryBkground(projectId, "111");
        Result test = iHistoryService.updateHistoryBkground(wrong, "111");
        System.out.println(test.toString());
    }

    @Transactional
    @Test
    public void updatePic() {
        //Result test = iHistoryService.updateHistory(projectId, "1","p5","t5","s5","t5");
        Result test = iHistoryService.updateHistory(wrong, "1","p5","t5","s5","t5");
        System.out.println(test.toString());
    }

    @Transactional
    @Test
    public void addCulture() {
        Result test = iHistoryService.addHistory(projectId, "111", "11","t4","tt4");
        System.out.println(test.toString());
    }

    @Transactional
    @Test
    public void searchBkground() {
        Result test = iHistoryService.searchHistoryBkground(projectId);
        //Result test = iHistoryService.searchHistoryBkground(wrong);
        System.out.println(test.toString());
    }

    @Transactional
    @Test
    public void searchHistory() {
        //Result test = iHistoryService.searchHistory(projectId);
        Result test = iHistoryService.searchHistory(wrong);
        System.out.println(test.toString());
    }

    @Transactional
    @Test
    public void deleteHistory() {
        Result test = iHistoryService.deleteHistory(projectId,"1");
        //Result test = iHistoryService.deleteHistory(wrong,"2");
        System.out.println(test.toString());
    }
}

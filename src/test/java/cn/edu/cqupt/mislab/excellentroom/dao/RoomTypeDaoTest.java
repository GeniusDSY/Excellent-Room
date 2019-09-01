package cn.edu.cqupt.mislab.excellentroom.dao;

import cn.edu.cqupt.mislab.excellentroom.domain.entity.RoomType;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.Assert.*;

/**
 * @Author HanSiyue
 * @Date 2019/9/1 上午10:16
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class RoomTypeDaoTest {

    @Autowired
    private RoomTypeDao roomTypeDao;

    @Transactional
    @Test
    public void addRoomType() {
        Boolean result = roomTypeDao.addRoomType("123",2);
        Assert.assertTrue(result);
    }

    @Transactional
    @Test
    public void deleteRoomTypeById() {
        Boolean result = roomTypeDao.deleteRoomTypeById("123",1);
        Assert.assertTrue(result);
    }

    @Transactional
    @Test
    public void addSimplePic() {
        Boolean result = roomTypeDao.addSimplePic("123",1,"123456789");
        Assert.assertTrue(result);
    }

    @Transactional
    @Test
    public void deleteSimplePicById() {
        Boolean result = roomTypeDao.deleteSimplePicById("123",1);
        Assert.assertTrue(result);
    }

    @Transactional
    @Test
    public void updateLayout() {
        Boolean result = roomTypeDao.updateLayout("123",1,"4567890");
        Assert.assertTrue(result);
    }

    @Transactional
    @Test
    public void updatePanorama() {
        Boolean result = roomTypeDao.updatePanorama("123",1,"4567890");
        Assert.assertTrue(result);
    }

    @Test
    public void selectRoomTypeById() {
        RoomType roomType = roomTypeDao.selectRoomTypeById("123",1);
        Assert.assertNotNull(roomType);
    }

    @Test
    public void selectSimplePicById() {
        RoomType roomType = roomTypeDao.selectSimplePicById("123",1);
        Assert.assertNotNull(roomType.getSimplePicUrl());
    }
}
package cn.edu.cqupt.mislab.excellentroom.service.impl;

import cn.edu.cqupt.mislab.excellentroom.dao.RoomTypeDao;
import cn.edu.cqupt.mislab.excellentroom.domain.entity.RoomType;
import cn.edu.cqupt.mislab.excellentroom.service.RoomTypeService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @Author HanSiyue
 * @Date 2019/8/26 下午5:07
 */

@Service
public class RoomTypeServiceImpl implements RoomTypeService {
    @Resource
    private RoomTypeDao roomTypeDao;

    @Override
    public Boolean addRoomType(String projectId, Integer type) {
        if (roomTypeDao.selectRoomTypeById(projectId, type)==null){
            return roomTypeDao.addRoomType(projectId,type);
        }
        return null;
    }

    @Override
    public Boolean deleteRoomTypeById(String projectId, Integer id) {
        if (roomTypeDao.selectRoomTypeById(projectId,id)!=null){
            return roomTypeDao.deleteRoomTypeById(projectId, id);
        }
        return null;
    }

    @Override
    public Boolean addSimplePic(String projectId, Integer type, String simplePicUrl) {
        Boolean result = roomTypeDao.addSimplePic(projectId, type, simplePicUrl);
        return result;
    }

    @Override
    public Boolean deleteSimplePicById(String projectId, Integer id) {
        if (roomTypeDao.selectSimplePicById(projectId, id)!=null){
            return roomTypeDao.deleteSimplePicById(projectId, id);
        }else {
            return null;
        }
    }

    @Override
    public Boolean updateLayout(String projectId, Integer type, String layoutUrl) {
        Boolean result = roomTypeDao.updateLayout(projectId, type, layoutUrl);
        return result;
    }

    @Override
    public Boolean updatePanorama(String projectId, Integer type, String panoramaUrl){
        Boolean result = roomTypeDao.updatePanorama(projectId,type,panoramaUrl);
        return result;
    }

    @Override
    public RoomType selectRoomTypeById(String projectId, Integer type) {
        RoomType roomType = roomTypeDao.selectRoomTypeById(projectId, type);
        if (roomType!=null){
            return roomType;
        }else {
            return null;
        }
    }

    @Override
    public RoomType selectSimplePicById(String projectId, Integer id) {
        RoomType roomType = roomTypeDao.selectSimplePicById(projectId, id);
        if (roomType != null) {
            return roomType;
        } else {
            return null;
        }
    }
}

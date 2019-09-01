package cn.edu.cqupt.mislab.excellentroom.service.impl;

import cn.edu.cqupt.mislab.excellentroom.dao.SurroundDao;
import cn.edu.cqupt.mislab.excellentroom.domain.entity.Landscape;
import cn.edu.cqupt.mislab.excellentroom.domain.entity.PublicUtility;
import cn.edu.cqupt.mislab.excellentroom.service.SurroundService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Author HanSiyue
 * @Date 2019/8/27 上午11:43
 */

@Service
public class SurroundServiceImpl implements SurroundService {
    @Resource
    private SurroundDao surroundDao;

    @Override
    public Boolean addLandscape(String projectId, String landscapeUrl, String text) {
        return surroundDao.addLandscape(projectId,landscapeUrl,text);
    }

    @Override
    public Boolean deleteLandscapeById(String projectId, Integer id) {
        if (surroundDao.selectLandscapeById(projectId, id)!=null){
            Boolean result = surroundDao.deleteLandscapeById(projectId, id);
            return result;
        }else {
            return false;
        }
    }

    @Override
    public List<Landscape> findAllLandscape(String projectId) {
        return surroundDao.findAllLandscape(projectId);
    }

    @Override
    public Boolean addPublicUtility(String projectId, String publicUtilityUrl, String text) {
        return surroundDao.addPublicUtility(projectId, publicUtilityUrl, text);
    }

    @Override
    public Boolean deletePublicUtilityById(String projectId, Integer id) {
        if (surroundDao.selectPublicUtilityById(projectId, id)!=null){
            Boolean result = surroundDao.deletePublicUtilityById(projectId, id);
            return result;
        }else {
            return false;
        }
    }

    @Override
    public List<PublicUtility> findAllPublicUtility(String projectId) {
        return surroundDao.findAllPublicUtility(projectId);
    }

    @Override
    public Landscape selectLandscapeById(String projectId, Integer id){
        Landscape landscape = surroundDao.selectLandscapeById(projectId, id);
        if (landscape!=null){
            return landscape;
        }else {
            return null;
        }
    }

    @Override
    public PublicUtility selectPublicUtilityById(String projectId, Integer id){
        PublicUtility publicUtility = surroundDao.selectPublicUtilityById(projectId, id);
        if (publicUtility!=null){
            return publicUtility;
        }else {
            return null;
        }
    }
}

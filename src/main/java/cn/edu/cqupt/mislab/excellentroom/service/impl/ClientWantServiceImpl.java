package cn.edu.cqupt.mislab.excellentroom.service.impl;

import cn.edu.cqupt.mislab.excellentroom.dao.ClientWantDao;
import cn.edu.cqupt.mislab.excellentroom.domain.entity.ClientWant;
import cn.edu.cqupt.mislab.excellentroom.service.ClientWantService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Author HanSiyue
 * @Date 2019/8/25 下午10:25
 */

@Service
public class ClientWantServiceImpl implements ClientWantService {
    @Resource
    private ClientWantDao clientWantDao;

    @Override
    public Boolean addClientWant(String projectId, String tel, Integer price, Integer type){
        Boolean result = clientWantDao.addClientWant(projectId,tel,price,type);
        return result;
    }

    @Override
    public List<ClientWant>findAll(String projectId){
        return clientWantDao.findAll(projectId);
    }
}

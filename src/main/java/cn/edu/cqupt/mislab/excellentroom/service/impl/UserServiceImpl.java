package cn.edu.cqupt.mislab.excellentroom.service.impl;

import cn.edu.cqupt.mislab.excellentroom.dao.UserDao;
import cn.edu.cqupt.mislab.excellentroom.domain.dto.UserDto;
import cn.edu.cqupt.mislab.excellentroom.domain.entity.User;
import cn.edu.cqupt.mislab.excellentroom.domain.po.UserPo;
import cn.edu.cqupt.mislab.excellentroom.service.UserService;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Resource
    private UserDao userDao;
    @Override
    public UserPo login(UserDto userDto) {
        User user = userDao.login(userDto.getUserName(),userDto.getPassword());
        if (user != null) {
            UserPo userPo = new UserPo();
            BeanUtils.copyProperties(user, userPo);
            return userPo;
        }else{
            return null;
        }
    }
    @Override
    public Boolean addUser(UserDto userDto) {
        Boolean result = userDao.add(userDto.getUserName(),userDto.getPassword());
        return true;
    }
    @Override
    public Boolean deleteUserByuserName(String userName) {
        if (userDao.delete(userName)){
            return true;
        }else {
            return false;
        }
    }
    private List<UserPo> allUser(){
        return null;
    }
}
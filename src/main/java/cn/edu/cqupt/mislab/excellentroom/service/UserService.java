package cn.edu.cqupt.mislab.excellentroom.service;

import cn.edu.cqupt.mislab.excellentroom.domain.dto.UserDto;
import cn.edu.cqupt.mislab.excellentroom.domain.entity.User;
import cn.edu.cqupt.mislab.excellentroom.domain.po.UserPo;
import org.springframework.stereotype.Service;

@Service
public interface UserService {
    /**
     * 用户登陆 添加管理员 删除管理员
     *@param userDto,userName;
     *@return UserPo,Boolean
     */

    UserPo login(UserDto userDto);
    Boolean addUser(UserDto userDto);
    Boolean deleteUserByuserName(String userName);
}
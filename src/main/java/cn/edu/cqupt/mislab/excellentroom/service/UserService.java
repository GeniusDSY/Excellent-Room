package cn.edu.cqupt.mislab.excellentroom.service;

import cn.edu.cqupt.mislab.excellentroom.domain.dto.UserDto;
import cn.edu.cqupt.mislab.excellentroom.domain.entity.User;
import cn.edu.cqupt.mislab.excellentroom.domain.po.UserPo;
import org.springframework.stereotype.Service;

@Service
public interface UserService {
    /**
     *
     * */

    UserPo login(UserDto userDto);
    Boolean add(UserDto userDto);
    Boolean delete(String userName);
}
package cn.edu.cqupt.mislab.excellentroom.service;

import cn.edu.cqupt.mislab.excellentroom.domain.dto.UserDto;
import cn.edu.cqupt.mislab.excellentroom.domain.entity.User;
import cn.edu.cqupt.mislab.excellentroom.domain.po.UserPo;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author HanSiyue
 */
@Service
public interface UserService {

    /**
     * 登陆
     * @param userDto userDto
     * @return
     */
    UserPo login(UserDto userDto);

    /**
     * 添加管理员
     * @param userDto userDto
     * @return
     */
    Boolean addUser(UserDto userDto);

    /**
     * 根据姓名删除管理员
     * @param userName 姓名
     * @return
     */
    Boolean deleteUserByuserName(String userName);

    /**
     * 展示所有人员
     * @return
     */
    List<User> findAll();

    /**
     *
     * @param id
     * @return
     */
    UserPo selectUserById(Integer id);

    /**
     * 生成验证码
     * @return
     */
    Object verifyCode();
}
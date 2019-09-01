package cn.edu.cqupt.mislab.excellentroom.dao;

import cn.edu.cqupt.mislab.excellentroom.domain.entity.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserDao {

    /**
     * 登陆
     * @param userName 用户名
     * @param password 密码
     * @return
     */
    User login(@Param("userName") String userName,@Param("password") String password);

    /**
     * 添加管理员
     * @param userName 用户名
     * @param password 密码
     * @return
     */
    Boolean addUser(@Param("userName") String userName,@Param("password") String password);

    /**
     * 根据用户名删除管理员
     * @param userName 用户名
     * @return
     */
    Boolean deleteUserByuserName(@Param("userName") String userName);

    /**
     * 查询所有人员
     * @return
     */
    List<User> findAll();

    /**
     * 通过id查询人员
     * @param id
     * @return
     */
    User selectUserById(@Param("id") Integer id);
}
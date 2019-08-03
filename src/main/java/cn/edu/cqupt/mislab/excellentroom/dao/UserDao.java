package cn.edu.cqupt.mislab.excellentroom.dao;

import cn.edu.cqupt.mislab.excellentroom.domain.entity.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDao {
    User login(@Param("userName") String userName,@Param("password") String password);
    Boolean add(@Param("userName") String userName,@Param("password") String password);
    Boolean delete(@Param("userName") String userName);
}
package cn.edu.cqupt.mislab.excellentroom;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.session.data.redis.config.annotation.web.http.EnableRedisHttpSession;

@MapperScan("cn.edu.cqupt.mislab.excellentroom.dao")
@SpringBootApplication
@EnableRedisHttpSession
public class ExcellentRoomApplication {

    public static void main(String[] args) {
        SpringApplication.run(ExcellentRoomApplication.class, args);
    }

}

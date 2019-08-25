package cn.edu.cqupt.mislab.excellentroom.util;

import org.springframework.data.redis.core.RedisTemplate;

/**
 * @Author HanSiyue
 * @Date 2019/8/25 下午4:24
 */
public class RedisTemplateUtil {

    private RedisTemplate<String, String> redisTemplate;

    /**
     * 用于spring注入.
     * @param redisTemplate 模版
     */
    public void setRedisTemplate(RedisTemplate<String, String> redisTemplate) {
        this.redisTemplate = redisTemplate;
    }

    /**
     * 获取模板redis对象.
     * @return redisTemplate
     */
    public RedisTemplate<String, String> getRedisTemplate() {
        return redisTemplate;
    }

}

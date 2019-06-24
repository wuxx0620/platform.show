package com.sureal.redis;

import com.sureal.serializer.RedisObjectSerializer;
import com.sureal.serializer.StringRedisSerializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;


/**
 * @author Wuxx
 * @date 2019/5/28 10:44
 * @PackageName com.sureal.redis
 * @ClassName RedisConfig
 * @Description Redis配置
 */
@Configuration
public class RedisConfig {
    /**
     * shiro-redis配置
     * @param factory
     * @return
     */
    @Bean(name = "shiro_redis")
    public RedisTemplate<Object, Object> redisTemplate(RedisConnectionFactory factory) {
        RedisTemplate<Object, Object> template = new RedisTemplate<Object, Object>();
        template.setConnectionFactory(factory);
        template.setKeySerializer(new StringRedisSerializer());
        template.setValueSerializer(new RedisObjectSerializer());
        return template;
    }
}

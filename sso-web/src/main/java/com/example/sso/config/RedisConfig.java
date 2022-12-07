package com.example.sso.config;

import com.example.sso.service.RedisService;
import com.example.sso.service.impl.RedisServiceImpl;
import config.BaseRedisConfig;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * yzw
 * 2022/12/7
 */
@Configuration
public class RedisConfig extends BaseRedisConfig {
    @Bean
    public RedisService redisService(){
        return new RedisServiceImpl();
    }
}

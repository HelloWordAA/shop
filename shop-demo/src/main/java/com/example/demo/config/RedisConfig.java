package com.example.demo.config;

import base.BaseRedisConfig;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Configuration;

/**
 * yzw
 * 2022/12/5
 */
@Configuration
@EnableCaching
public class RedisConfig extends BaseRedisConfig {
}

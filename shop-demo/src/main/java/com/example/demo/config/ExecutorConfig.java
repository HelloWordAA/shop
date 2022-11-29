package com.example.demo.config;

import lombok.Data;
import org.springframework.stereotype.Component;

import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * yzw
 * 2022/11/27
 * 线程配置
 */
@Component
@Data
public class ExecutorConfig {
    /**
     * 核心线程数
     */
    private int corePoolSize;
    /**
     * 最大线程数
     */
    private int maxPoolSize;
    /**
     * 队列容量
     */
    private int queueCapacity;
    /**
     * 活跃时间
     */
    private int keepAliveTime;
    /**
     * 名称前缀
     */
//    private String preFix;

    ThreadPoolExecutor executor = new ThreadPoolExecutor(5,10,100, TimeUnit.SECONDS,new LinkedBlockingDeque<>(100));

//
//    @Bean("myExecutor")
//    public Executor myExecutor() {
////        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
//        ThreadPoolExecutor executor = new ThreadPoolExecutor();
//        executor.setCorePoolSize(corePoolSize);
//        executor.setMaxPoolSize(maxPoolSize);
//        executor.setQueueCapacity(queueCapacity);
//        executor.setKeepAliveSeconds(keepAliveTime);
////        executor.setThreadNamePrefix(preFix);
//        executor.setRejectedExecutionHandler(new ThreadPoolExecutor.AbortPolicy() );
//        executor.initialize();
//        return executor;
//    }
}

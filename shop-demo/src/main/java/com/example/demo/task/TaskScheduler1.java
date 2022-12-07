package com.example.demo.task;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * yzw
 * 2022/12/3
 * 定时任务类
 * 默认单线程执行任务，多线程同时执行需要配置线程池
 */
@Component
//@ConditionalOnProperty(prefix = "scheduling",name = "enable",havingValue = "true") //定时任务开关  value不同时则不生效
public class TaskScheduler1 {
    /**
     * 定时任务开关
     */
    @Value("${scheduling.cronTaskSwitch.enable}")
    private Boolean cronTaskSwitch;

    @Value("${scheduling.task2Switch.enable}")
    private Boolean task2Switch;

    @Scheduled(cron = "0 10/1 21 * * ?")//开启一个定时任务、
    public void cron() throws InterruptedException{
        if (!cronTaskSwitch){
            return;
        }
            Thread.sleep(5000);
        System.out.println("开启一个定时任务:"+new Date());
    }
    @Scheduled(cron = "0 10/1 21 * * ?")
    public void task2() {
        if (!task2Switch){
            return;
        }
        System.out.println("定时任务2："+new Date());
    }
}

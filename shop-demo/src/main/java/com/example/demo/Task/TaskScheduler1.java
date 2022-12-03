package com.example.demo.Task;

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
public class TaskScheduler1 {
    @Scheduled(cron = "0 10/1 20 * * ?")//开启一个定时任务
    public void cron(){
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("开启一个定时任务:"+new Date());
    }
    @Scheduled(cron = "0 20/1 20 * * ?")
    public void task2() {
        System.out.println("定时任务2："+new Date());
    }
}

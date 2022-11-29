package com.example.demo.Task;

import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.stereotype.Component;

import java.util.concurrent.Future;

/**
 * yzw
 * 2022/11/27
 * 异步任务
 */
@Component
public class MyAsyncTask {

    @Async/*("myExecutor")*/
    public Future<String> myTask(){
        String name = "异步方法，你好！！";
        return new AsyncResult<>(name);
    }
}

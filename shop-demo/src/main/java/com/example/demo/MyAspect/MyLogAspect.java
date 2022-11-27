package com.example.demo.MyAspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * yzw
 * 2022/11/26
 * 定义切面
 */
@Component
@Aspect
public class MyLogAspect {
    private static final Logger log = LoggerFactory.getLogger(MyLogAspect.class);

    /**
     * 只要用到了MyLog这个注解的就是目标类
     */
    @Pointcut("@annotation(com.example.demo.MyAspect.MyLog)")
    private void MyValid(){}

    public void before(JoinPoint joinPoint){
        MethodSignature sinSignature = (MethodSignature) joinPoint.getSignature();
        MyLog myLog = sinSignature.getMethod().getAnnotation(MyLog.class);
        System.out.println("["+sinSignature.getName()+":start...]");
        System.out.println("[目标对象方法被调用的时候产生的日志，记录到日志表]"+myLog.desc());
    }
}

package com.example.demo.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

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
    @Pointcut("@annotation(com.example.demo.aspect.MyLog)")
    private void logPointCut(){}

    //如果方法返回成功，则将函数标记为在切入点覆盖的方法之前执行的通知
    @AfterReturning("logPointCut()")
    public void logAfter(JoinPoint joinPoint){
        //反射机制获取织入点处的方法
        MethodSignature sinSignature = (MethodSignature) joinPoint.getSignature();
        //获取织入点所在的方法
        Method method = sinSignature.getMethod();
        //获取注解
        MyLog myLog = method.getAnnotation(MyLog.class);
        //获取注解属性
        String desc = myLog.desc();
        //获取请求的类名
        String name = joinPoint.getTarget().getClass().getName();
        //获取请求的方法名
        String methodName = method.getName();
        //获取请求的参数
        Object[] args = joinPoint.getArgs();
        //将参数转换成json
//        String s = JSON.toJSONString(args);
        System.out.println("请求的方法名:"+methodName);
        System.out.println("获取请求的类名"+name);
        System.out.println("获取注解属性"+desc);
        System.out.println("[目标对象方法被调用的时候产生的日志，记录到日志表]"+myLog.desc());
    }
}

package com.example.demo.interceptor;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * yzw
 * 2022/12/4
 * 拦截器
 */
public class MyInterceptor implements HandlerInterceptor {
    /**
     * 前置拦截
     * 这个方法将在请求处理之前进行调用。
     * 注意：如果该方法的返回值为false ，将视为当前请求结束，
     * 不仅自身的拦截器会失效，还会导致其他的拦截器也不再执行。
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        System.out.println("前置拦截-->");
        return true;
    }

    /**
     *只有在 preHandle() 方法返回值为true 时才会执行。
     * 会在Controller 中的方法调用之后，DispatcherServlet 返回渲染视图之前被调用。
     * postHandle() 方法被调用的顺序跟 preHandle() 是相反的，
     * 先声明的拦截器 preHandle() 方法先执行，而postHandle()方法反而会后执行。
     */
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        System.out.println("拦截器处理中-->");
    }

    /**
     *只有在 preHandle() 方法返回值为true 时才会执行。
     * 在整个请求结束之后， DispatcherServlet 渲染了对应的视图之后执行。
     */
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        System.out.println("拦截器后置-->");
    }
}

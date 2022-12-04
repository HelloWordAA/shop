package com.example.demo.filter;

import javax.servlet.*;
import java.io.IOException;

/**
 * yzw
 * 2022/12/4
 * 过滤器
 * 顺序:过滤器->拦截器->过滤器
 */
public class MyFilter implements Filter {
    /**
     * 该方法在容器启动初始化过滤器时被调用，
     * 它在 Filter 的整个生命周期只会被调用一次。
     * 注意：这个方法必须执行成功，否则过滤器会不起作用。
     * @param filterConfig
     * @throws ServletException
     */
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("过滤器前置-->");
    }

    /**
     * 容器中的每一次请求都会调用该方法， FilterChain 用来调用下一个过滤器 Filter。
     * @param servletRequest
     * @param servletResponse
     * @param filterChain
     * @throws IOException
     * @throws ServletException
     */
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        //TODO
        System.out.println("处理中----->");
        //调用filter链中的下一个filter
        filterChain.doFilter(servletRequest,servletResponse);
    }

    /**
     *  当容器销毁 过滤器实例时调用该方法，一般在方法中销毁或关闭资源，
     *  在过滤器 Filter 的整个生命周期也只会被调用一次
     */
    @Override
    public void destroy() {
        System.out.println("Filter后置");
    }
}

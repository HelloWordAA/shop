//package com.gateway.filter;
//
//import com.netflix.zuul.ZuulFilter;
//import com.netflix.zuul.context.RequestContext;
//import com.netflix.zuul.exception.ZuulException;
//import org.springframework.stereotype.Component;
//
//import javax.servlet.http.HttpServletRequest;
//import java.io.IOException;
//
///**
// * yzw
// * 2022/11/30
// *
// */
//@Component
//public class MyZuulFilter extends ZuulFilter {
//    /**
//     * filterType
//     *     返回一个字符串代表过滤器的类型，
//     *     在zuul中定义了四种不同生命周期的过滤器类型
//     *     pre：路由之前
//     *     routing：路由之时
//     *     post： 路由之后
//     *     error：发生错误调用
//     * @return
//     */
//    @Override
//    public String filterType() {
////        鉴权/限流：pre
////        日志：post
//        return "pre";
//    }
//
//    /**
//     * 过滤的顺序
//     * @return
//     */
//    @Override
//    public int filterOrder() {
//        return 0;
//    }
//
//    /**
//     * 是否要过滤
//     * @return
//     */
//    @Override
//    public boolean shouldFilter() {
//        return true;
//    }
//
//    /**
//     * 过滤器的具体逻辑
//     * @return
//     * @throws ZuulException
//     */
//    @Override
//    public Object run() throws ZuulException {
//        RequestContext ctx = RequestContext.getCurrentContext();
//        HttpServletRequest request = ctx.getRequest();
//        System.out.println("拦截请求-------->"+request.getRequestURI());
//        String token = request.getParameter("token");
//        if (token == null) {
//            ctx.setSendZuulResponse(false);
//            try {
//                ctx.getResponse().getWriter().print("Token is null");
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//        }
//
//        return null;
//    }
//}

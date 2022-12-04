package com.example.demo.exception;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.web.error.ErrorAttributeOptions;
import org.springframework.boot.web.servlet.error.DefaultErrorAttributes;
import org.springframework.boot.web.servlet.error.ErrorAttributes;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

/**
 * yzw
 * 2022/12/4
 * 其他异常处理
 * 未在全局异常中定义的其他异常，包括404、500等异常。
 */
@Slf4j
@RestController
public class MyErrorController implements ErrorController {
    @RequestMapping(value = {"/error"})
    public Object error(HttpServletRequest request, WebRequest webRequest) {
        Map<String,Object> body = new HashMap<>();
        Map<String,Object> dataMap = new HashMap<>();
        //获取springboot原生报错返回信息
        final ErrorAttributeOptions errorAttributeOptions = ErrorAttributeOptions.of(ErrorAttributeOptions.Include.STACK_TRACE);
        ErrorAttributes errorAttributes = new DefaultErrorAttributes();
        dataMap = errorAttributes.getErrorAttributes(webRequest,errorAttributeOptions);
        dataMap.remove("trace");//移除trace以免抛出错误详情信息
        body.put("code",dataMap.get("status"));
        body.put("message","请求失败");
        body.put("data",dataMap);
        log.info(String.valueOf(body));
        return body;
    }
}

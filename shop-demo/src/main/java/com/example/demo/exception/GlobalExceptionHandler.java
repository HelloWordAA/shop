package com.example.demo.exception;

import enumEntity.ResultCode;
import pojo.ResultBean;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * yzw
 * 2022/12/4
 * 全局异常处理
 */
@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {
    /**
     * 用户异常处理
     * @param e
     * @return
     * @throws Exception
     */
    @ResponseBody
    @ExceptionHandler(UserException.class)
    public Object handleBusinessException(UserException e)throws Exception{
        log.error("UserNotExistException error", e);
        return ResultBean.create(ResultCode.USER_NOT_LOGGED_IN);
//        return "全局异常，失败";
    }

//    /**
//     * 处理所有Service层异常
//     */
//    @ResponseBody
//    @ExceptionHandler(value = ServiceException.class)
//    public CommonResult handle(ServiceException e) {
//        if (e.getErrorCode() != null) {
//            return CommonResult.failed(e.getErrorCode());
//        }
//        return CommonResult.failed(e.getMessage());
//    }
//    /**
//     * 处理所有不可知的异常
//     */
//    @ResponseBody
//    @ExceptionHandler(Exception.class)
//    public CommonResult exceptionHandler(HttpServletRequest request, Exception exception) throws Exception {
//
//        Map<String, Object> result = new HashMap<>(3);
//        String message =exception.getMessage()+request.getRequestURL().toString();
//        return CommonResult.failed(message);
//    }
}

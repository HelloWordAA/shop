package com.example.demo.exception;

/**
 * yzw
 * 2022/12/4
 * 用户异常定义类
 */
public class UserException extends RuntimeException {
    public UserException(){
        super("自定义异常：用户名或密码错误");
    }
    public UserException(String message){
        super(message);
    }
    public UserException(String message,Throwable cause){
        super(message, cause);
    }
    public UserException(Throwable cause){
        super(cause);
    }
    public UserException(String message,Throwable cause,boolean enableSuppression ,boolean writableStackTrace){
        super(message, cause, enableSuppression, writableStackTrace);
    }
}

package com.example.demo.service;

/**
 * yzw
 * 2022/11/23
 */
public class SingleClass {

    private SingleClass(){}
//    private static SingleClass singleClass = new SingleClass();
    private static volatile SingleClass singleClass;
    public SingleClass getSingleClass(){
        if (singleClass==null){
            synchronized (SingleClass.class){
                if (singleClass==null){
                    singleClass = new SingleClass();
                }
            }
        }
        return singleClass;
    }
}

package com.cjy.proxy.cglib;
//增强
public class Advice {
    public void before(){
        System.out.println("前置增强......");
    }
    public void afterRunning(){
        System.out.println("前置增强......");
    }
}

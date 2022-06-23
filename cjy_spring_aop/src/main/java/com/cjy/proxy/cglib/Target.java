package com.cjy.proxy.cglib;


//目标，这个目标需要实现接口TargetInterface
public class Target {
    public void save() {
        System.out.println("save running.....");
    }
}

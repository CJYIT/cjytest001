package com.cjy.proxy.jdk;
//目标，这个目标需要实现接口TargetInterface
public class Target implements TargetInterface {
    public void save() {
        System.out.println("save running.....");
    }
}

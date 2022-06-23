package com.cjy.proxy.cglib;

import com.cjy.proxy.jdk.TargetInterface;
import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

//复习前面学的jdk动态
public class ProxyTest {
    public static void main(String[] args) {
//目标对象
        final Target target = new Target();//首先导入目标对象
        final Advice advice = new Advice();//获得增强对象
        //返回值 就是动态生成的代理对象，基于cglib    了解即可
        //1、创建增强器
        Enhancer enhancer = new Enhancer();
        //2、设置父类（目标）
        enhancer.setSuperclass(Target.class);
//        设置回调
        enhancer.setCallback(new MethodInterceptor() {
            public Object intercept(Object prosy, Method method, Object[] args, MethodProxy methodProxy) throws Throwable {
//                执行前置
                advice.before();
//                执行目标
                Object invoke = method.invoke(target, args);
//                执行后置
                advice.afterRunning();
                return null;
            }
        });
        //4、创建代理对象
        Target proxy = (Target) enhancer.create();
        proxy.save();
    }
}

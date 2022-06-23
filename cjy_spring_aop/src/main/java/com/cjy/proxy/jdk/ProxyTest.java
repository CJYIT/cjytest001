package com.cjy.proxy.jdk;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
//复习前面学的jdk动态
public class ProxyTest {
    public static void main(String[] args) {
//目标对象
        final Target target = new Target();//首先导入目标对象
//获得增强对象
        final Advice advice = new Advice();
        //返回值 就是动态生成的代理对象，不能用proxy接收，proxy和target是兄弟关系，需要用父类接收
        TargetInterface proxy = (TargetInterface) Proxy.newProxyInstance(
                target.getClass().getClassLoader(),//目标对象类加载器
                target.getClass().getInterfaces(),//目标对象相同的接口字节码对象数组
                new InvocationHandler() {
                    //调用对象的任何方法，实质执行的都是invoke方法里面的参数有proxy代理对象，method要执行的目标方法，args传递参数
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                        //这是底层代码，平常开发配置好后会自动给我们生成以下方法
                        advice.before();//前置方法
                        method.invoke(target, args);//执行目标方法，这里的invoke与上面的不一样，这里是反射invoke，两个参数分别是目标和实际参数
                        advice.afterRunning();//后置增强
                        return null;
                    }
                }
        );
        //调用代理对象的方法：
        proxy.save();
    }
}

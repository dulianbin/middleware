package com.dulianbin.demo.patterns.proxy.jdkproxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class JdkMeipo implements InvocationHandler {


    private Object target;

    public Object getInstance(Object target){
        this.target=target;
        Class<?> clazz=target.getClass();
        return Proxy.newProxyInstance(clazz.getClassLoader(),clazz.getInterfaces(),this);
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        before();
        Object obj=method.invoke(this.target,args);
        after();
        return obj;
    }

    private void after() {
        System.out.println("你好！我是媒婆，男票物色完成！");
    }

    private void before() {
        System.out.println("你好！我是媒婆，开始给你物色男票");
    }


}

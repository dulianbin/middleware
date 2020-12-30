package com.dulianbin.demo.patterns.proxy.carJdkProxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class JiayouCarProxy implements InvocationHandler {

    private Object target;

    public Object getInstance(Object obj){
        this.target=obj;
        Class<?> clazz=obj.getClass();
        return Proxy.newProxyInstance(clazz.getClassLoader(),clazz.getInterfaces(), this);
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        jiayouBefore();
        Object result=method.invoke(target, args);
        jiayouAfter();
        return result;
    }

    private void jiayouAfter() {
        System.out.println("您的爱车加油完毕!");
    }

    private void jiayouBefore() {
        System.out.println("我是代理加油服务员，开始为您去加油,准备读取你的加油信息!");
    }


}

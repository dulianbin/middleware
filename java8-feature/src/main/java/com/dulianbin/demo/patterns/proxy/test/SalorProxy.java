package com.dulianbin.demo.patterns.proxy.test;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class SalorProxy implements InvocationHandler {

    private Object target;

    public Object getInstance(Object object){
        this.target=object;
        Class<?> clazz=object.getClass();
        return Proxy.newProxyInstance(clazz.getClassLoader(),clazz.getInterfaces(),this);
    }


    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        proxyBefore();
        Object result=method.invoke(target,args);
        proxyAfter();
        return result;
    }

    private void proxyAfter() {
        System.out.println("--------这里执行的是 调用目标方法之后加入的代理增强代码--------");
    }

    private void proxyBefore() {
        System.out.println("--------这里执行的是 调用目标方法之前加入的代理增强代码--------");
    }


}

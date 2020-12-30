package com.dulianbin.demo.patterns.proxy.carJdkProxy;

import java.lang.reflect.Method;

public class ProxyTest {

    public static void main(String[] args) {
        try {
            Object obj=new JiayouCarProxy().getInstance(new XiaoCar("宝马X5"));
            Method method=obj.getClass().getMethod("jiayou", String.class, String.class);
            System.out.println("请求结果："+method.invoke(obj, "#95","54w5"));
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}

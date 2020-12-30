package com.dulianbin.demo.patterns.proxy.test;

import java.lang.reflect.Method;

public class ProxyTest {
    public static void main(String[] args) {
        try {
            SalorProxy proxy= new SalorProxy();
            Object object=proxy.getInstance(new CarSalor());
            Method method=object.getClass().getMethod("maihuo",String.class);
            System.out.println("通过代理调用的结果："+method.invoke(object,"宝马，玛莎拉蒂"));

            System.out.println();
            System.out.println();
            object=proxy.getInstance(new HouseSalor());
            method=object.getClass().getMethod("maihuo",String.class);
            System.out.println("通过代理调用的结果："+method.invoke(object, "别墅，商品房"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

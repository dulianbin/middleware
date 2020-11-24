package com.dulianbin.demo.patterns.proxy.jdkproxy;

import com.dulianbin.demo.patterns.proxy.Person;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class JdkProxyTest {


    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {

        Object obj=new JdkMeipo().getInstance(new Girl());
        Method m=obj.getClass().getMethod("findLove",String.class);
        String ss=(String)m.invoke(obj,"jdk动态代理是基于接口方式实现的");  //方法返回值
        System.out.println("方法返回值:"+ss);

       /* Person p=new Girl();
        Method m=p.getClass().getMethod("findLove",String.class);
        System.out.println(m.invoke(p,"哈哈"));*/
    }
}

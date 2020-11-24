package com.dulianbin.demo.patterns.proxy.staticproxy;

import com.dulianbin.demo.patterns.proxy.Person;

public class StaticProxyTest {


    public static void main(String[] args) {
        Person person=new Father(new Son());
        System.out.println("执行结果:"+person.findLove("找对象"));
    }

}

package com.dulianbin.demo.patterns.proxy.cglibproxy;

public class CglibTest {

    public static void main(String[] args) {

        DanshenGirl cmp=(DanshenGirl)new CglibMeipo().createProxy(DanshenGirl.class);
        System.out.println(cmp);
        cmp.findLove("爱");
    }

}

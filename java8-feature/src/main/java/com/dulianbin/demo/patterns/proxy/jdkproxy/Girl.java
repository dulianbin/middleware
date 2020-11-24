package com.dulianbin.demo.patterns.proxy.jdkproxy;

import com.dulianbin.demo.patterns.proxy.Person;

public class Girl implements Person {

    @Override
    public String findLove(String str) {
        System.out.println("高富帅");
        System.out.println("身高180cm");
        System.out.println("有6块腹肌");
        return "ok:"+str;
    }
}

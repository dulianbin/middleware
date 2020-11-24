package com.dulianbin.demo.patterns.proxy.staticproxy;

import com.dulianbin.demo.patterns.proxy.Person;

public class Son  implements Person {

    @Override
    public String findLove(String str) {
        System.out.println("我需要的女票是白富美");
        return str;
    }

}

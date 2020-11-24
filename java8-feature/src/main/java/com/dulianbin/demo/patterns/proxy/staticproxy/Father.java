package com.dulianbin.demo.patterns.proxy.staticproxy;

import com.dulianbin.demo.patterns.proxy.Person;

public class Father implements Person {

    private Person son;

    public Father(Person son){
        this.son=son;
    }

    @Override
    public String findLove(String str) {
        before();
        String result=son.findLove(str);
        after();
        return result;
    }

    private void after() {
        System.out.println("你好！我是媒婆，男票物色完成！");
    }

    private void before() {
        System.out.println("你好！我是媒婆，开始给你物色男票");
    }
}

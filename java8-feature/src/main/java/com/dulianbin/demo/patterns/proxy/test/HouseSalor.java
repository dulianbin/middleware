package com.dulianbin.demo.patterns.proxy.test;

public class HouseSalor implements Salor{

    @Override
    public String maihuo(String product) {
        System.out.println("我是房产置业顾问，专卖各种房产："+product);
        return "我是房产置业顾问，专卖各种房产："+product;
    }

}

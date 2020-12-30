package com.dulianbin.demo.patterns.proxy.test;

public class CarSalor implements Salor {


    @Override
    public String maihuo(String product) {
        System.out.println("我是汽车销售员，专卖各大品牌汽车："+product);
        return "我是汽车销售员，专卖各大品牌汽车："+product;
    }

}

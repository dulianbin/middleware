package com.dulianbin.demo.patterns.proxy.carJdkProxy;

public class XiaoCar implements  Car {

    private String carType;

    public XiaoCar(String carType) {
        this.carType = carType;
    }


    @Override
    public String jiayou(String type,String value) {
        System.out.println("hello，我是"+carType);
        System.out.println("我要加的汽油是:"+type);
        System.out.println("参数二:"+value);
        return "车型:"+carType+",我要加的汽油是:"+type;
    }


}

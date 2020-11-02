package com.dulianbin.demo;

import java.math.BigDecimal;

public class Test {
    public static void main(String[] args) {
        BigDecimal a=new BigDecimal(10);
        BigDecimal b=new BigDecimal(100);
        System.out.println(a.compareTo(b)<0);
    }
}

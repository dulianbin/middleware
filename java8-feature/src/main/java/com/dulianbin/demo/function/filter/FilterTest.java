package com.dulianbin.demo.function.filter;

import com.dulianbin.demo.function.groupingBy.Item;

import java.math.BigDecimal;

public class FilterTest {

    public static void main(String[] args) {
        System.out.println(new Item().getClass().getName());
        try {
            Item aa = (Item) Class.forName("com.dulianbin.demo.function.groupingBy.Item").newInstance();
            aa.setName("433");
            aa.setPrice(new BigDecimal(4));
            System.out.println(aa.getName());
        }catch (Exception e) {
            e.printStackTrace();
        }
    }
}

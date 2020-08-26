package com.dulianbin.demo.function.map;

import com.google.common.collect.Lists;

import java.util.List;

public class Test {
    public static void main(String[] args) {
        List<OrderDetail>  list= Lists.newArrayList();
        OrderDetail o=new OrderDetail();
        o.setItemPrice(10);
        o.setOrderId(132l);
        o.setBuyCount(2);

        OrderDetail o2=new OrderDetail();
        o2.setItemPrice(40);
        o2.setOrderId(132l);
        o2.setBuyCount(1);

        OrderDetail o3=new OrderDetail();
        o3.setItemPrice(40);
        o3.setOrderId(132l);
        o3.setBuyCount(1);

        list.add(o);
        list.add(o2);
        list.add(o3);

        System.out.println(list.stream().mapToInt(s->{
            return s.getItemPrice()* s.getBuyCount();
        }).sum());
    }
}

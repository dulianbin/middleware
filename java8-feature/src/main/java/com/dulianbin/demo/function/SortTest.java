package com.dulianbin.demo.function;

import com.dulianbin.demo.function.groupingBy.Item;
import com.google.common.collect.Lists;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class SortTest {

    public static void main(String[] args) {
        List<Integer> list= Arrays.asList( 100, 6, 45,432,55,54354,54,4,6 );
        //排序，对于一行的处理，可以不用return
        list.stream().sorted((e1, e2 ) -> e1.compareTo( e2 ) ).forEach(e-> System.out.println(e));

        System.out.println("----------------------三八分割线---------------------------");

        list.stream().sorted((e1, e2 ) -> {
            int result=e1.compareTo( e2 );
            return result;
        } ).forEach(e-> System.out.println(e));
    }


    private static void test(){
        List<Item> list= Lists.newArrayList();
        Random random =new Random();
        for (int i=0;i<10;i++){
            Item item =new Item("商品"+i,i,new BigDecimal(random.nextInt(1000)));
            list.add(item);
        }

        list.forEach(item -> {
            System.out.println(item.toString());
        });

        System.out.println("------------------------");

        list.stream().sorted((it1,it2)->{
            return it1.getPrice().compareTo( it2.getPrice());
        }).forEach(item -> System.out.println(item.toString()));
    }



}

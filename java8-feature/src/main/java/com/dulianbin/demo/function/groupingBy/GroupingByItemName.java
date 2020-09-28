package com.dulianbin.demo.function.groupingBy;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class GroupingByItemName {

    public static void main(String[] args) {
        List<Item> items = Arrays.asList(
                new Item("apple", 10, new BigDecimal(23.5)),
                new Item("apple", 20, new BigDecimal(32.5)),
                new Item("orange", 30, new BigDecimal(13.9)),
                new Item("orange", 20, new BigDecimal(32.5)),
                new Item("orange", 10, new BigDecimal(63.5)),
                new Item("orange", 50, new BigDecimal(41.5)),
                new Item("peach", 20, new BigDecimal(26.5)),
                new Item("peach", 30, new BigDecimal(32.5)),
                new Item("peach", 40, new BigDecimal(24.5)),
                new Item("peach", 10, new BigDecimal(12.5))
        );

        Map<String,List<Item>> itemMap=items.stream().collect(Collectors.groupingBy(item -> item.getName()));
        for (String key:itemMap.keySet()){
            System.out.println("key:"+key+",结果值:"+itemMap.get(key));
        }

    }
}

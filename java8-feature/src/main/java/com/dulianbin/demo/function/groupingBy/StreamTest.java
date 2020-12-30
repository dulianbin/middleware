package com.dulianbin.demo.function.groupingBy;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class StreamTest {

    public static void main(String[] args) {
        List<Product> list=new ArrayList<>();
        Product p1=new Product(41,"42341244",new BigDecimal(17.9),"清扬洗发水");
        Product p2=new Product(23,"89345253",new BigDecimal(164.9),"肥牛片");
        Product p3=new Product(29,"987625465",new BigDecimal(65.4),"娃哈哈整箱");

        list.add(p1);
        list.add(p2);
        list.add(p3);

        List<String> skuList=list.stream().map(p->p.getSkuNo()).collect(Collectors.toList());

        skuList.forEach(i-> System.out.println(i));

    }
}

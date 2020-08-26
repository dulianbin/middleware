package com.dulianbin.demo.function.stream;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class StreamTest {
    public static void main(String[] args) {
        List<StringAndString> stringAndStrings = new ArrayList<>();
        int l = 10;
        for (int i = 0; i < l; i++) {
            StringAndString s2 = new StringAndString();
            s2.setName("test" + (100-i));
            s2.setEmail("test" + i + "@qq.com");
            stringAndStrings.add(s2);
        }
        StringAndString s2 = new StringAndString();
        s2.setName("test" + 1);
        s2.setEmail("test" + 1+ "@qq.com");
        stringAndStrings.add(s2);
        stringAndStrings.add(stringAndStrings.get(3));
        stringAndStrings.add(stringAndStrings.get(3));


        System.out.println("原始数据+++++++++++++++++++++++++++++++++++++++++");
        stringAndStrings.stream().forEach(System.out::println);

        System.out.println("抽取list中对象的name属性+++++++++++++++++++++++++++++++++++++++++");
        stringAndStrings.stream().map(StringAndString::getName).forEach(System.out::println);

        System.out.println("剔除name是test1的+++++++++++++++++++++++++++++++++++++++++");
        stringAndStrings.stream().filter(s -> !s.getName().equals("test1")).forEach(System.out::println);

        System.out.println("以对象中的Email属性去重+++++++++++++++++++++++++++++++++++++++++");
        stringAndStrings.stream().collect(Collectors.toCollection(() ->
                new TreeSet<>(Comparator.comparing(StringAndString::getEmail))))
                .stream().forEach(System.out::println);

        System.out.println("以对象中的name属性去重+++++++++++++++++++++++++++++++++++++++++");
        stringAndStrings.stream().filter(distinctByKey(p -> p.getName())).
                collect(Collectors.toList()).stream().forEach(System.out::println);


        System.out.println("取前五个+++++++++++++++++++++++++++++++++++++++++");
        stringAndStrings.stream().limit(5).forEach(System.out::println);

        System.out.println("排序+++++++++++++++++++++++++++++++++++++++++");
        stringAndStrings.stream().sorted((P1, P2) -> P1.getName().compareTo(P2.getName())).forEach(System.out::println);

        //以上操作并不会改变list本身，如果需要改变list可以进行下面的操作
        System.out.println("可以看到上面的操作对list本身是没有影响的+++++++++++++++++++++++++++++++++++++++++");
        stringAndStrings.stream().forEach(System.out::println);
        System.out.println("排序之后的list+++++++++++++++++++++++++++++++++++++++++");
        stringAndStrings = stringAndStrings.stream().sorted((P1, P2) -> P1.getName().compareTo(P2.getName())).collect(Collectors.toList());
        stringAndStrings.stream().forEach(System.out::println);

    }

    public static <T> Predicate<T> distinctByKey(Function<? super T, Object> keyExtractor) {
        Map<Object, Boolean> seen = new ConcurrentHashMap<>();
        System.out.println("这个函数将应用到每一个item");
        return t -> seen.putIfAbsent(keyExtractor.apply(t), Boolean.TRUE) == null;
    }


}

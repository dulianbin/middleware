package com.dulianbin.demo.function.groupingBy;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class GroupingByTest {

    public static void main(String[] args) {

        List<String> items = Arrays.asList(
                "apple", "apple",
                "orange", "orange", "orange",
                "blueberry",
                "peach", "peach", "peach", "peach"
        );
        // 分组，计数
        Map<String, Long> result = items.stream()
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

        System.out.println(result);

        Map<String, Long> finalMap = new LinkedHashMap<>();
        // 排序
        result.entrySet().stream()
                .sorted(Map.Entry.<String, Long>comparingByValue().reversed())
                .forEachOrdered(e -> finalMap.put(e.getKey(), e.getValue()));

        System.out.println(finalMap);

        System.out.println("--------------------");
        test();
    }


    public static void test() {
        List<String> list = new ArrayList<>();
        list.add("x");
        list.add("b");
        list.add("y");
        list.add("z");

        list.parallelStream().forEach(x -> System.out.println(x));
        list.parallelStream().forEachOrdered(x -> System.out.println(x));

        //主要的区别在并行流的处理上
        //输出的顺序不一定（效率更高）
        Stream.of("AAA", "BBB", "CCC").parallel().forEach(s -> System.out.println("Output:" + s));
        //输出的顺序与元素的顺序严格一致
        Stream.of("AAA", "BBB", "CCC").parallel().forEachOrdered(s -> System.out.println("Output:" + s));
    }

}

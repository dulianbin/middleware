package com.dulianbin.demo.function;

import java.util.function.Function;

public class ApplyTest {
    public static void main(String[] args) {
        Function<Integer,Integer> add= i->i+1;
        Function<Integer,Integer> squat=i->i*i;

        System.out.println("这个预期结果是：50，执行结果是:"+add.compose(squat).apply(7));

        System.out.println("这个预期结果是：64，执行结果是:"+add.andThen(squat).apply(7));

        //7+1=8,8+1=9,9*9=81
        System.out.println("这个预期结果是：81，执行结果是:"+add.andThen(squat).compose(add).apply(7));

        //7+1=8,8+1=9,9*9=81, 81*81
        //10000
        System.out.println("这个预期结果是：81，执行结果是:"+add.andThen(squat).compose(add).andThen(squat).compose(add).apply(7));
        System.out.println(81*81);
    }
}

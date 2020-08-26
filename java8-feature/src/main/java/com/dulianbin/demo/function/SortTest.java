package com.dulianbin.demo.function;

import java.util.Arrays;
import java.util.List;

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

}

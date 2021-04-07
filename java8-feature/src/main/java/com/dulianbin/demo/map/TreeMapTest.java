package com.dulianbin.demo.map;

import org.checkerframework.checker.units.qual.C;

import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class TreeMapTest {


    public static void main(String[] args) {

       Scanner scanner=new Scanner(System.in);

        String temp=scanner.nextLine().toLowerCase();
        TreeMap<Character,Integer> tm=new TreeMap<Character,Integer>();
        char[] chars=temp.toCharArray();
        for(Character c:chars){
            if(tm.containsKey(c)){
                tm.put(c,tm.get(c)+1);
            }else{
                tm.put(c,1);
            }
        }

        for(Character c:tm.keySet()){
           int value= tm.get(c);
            System.out.println("key:"+c+",value:"+value);
        }



    }
}

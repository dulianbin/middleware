package com.dulianbin.demo.bishi;

public class Something {

    public static void main(String[] args) {

        Other other=new Other();
        new Something().addOne(other);
    }

    public void addOne(final Other other){
        other.i++;
    }
}

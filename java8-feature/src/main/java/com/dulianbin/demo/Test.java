package com.dulianbin.demo;

import java.math.BigDecimal;
import java.util.concurrent.CountDownLatch;

public class Test {


    public static void main(String[] args) {
        CountDownLatch countDownLatch1=new CountDownLatch(0);
        CountDownLatch countDownLatch2=new CountDownLatch(1);
        CountDownLatch countDownLatch3=new CountDownLatch(1);


    }


    class CountDownTest implements Runnable{

        private CountDownLatch preCountDown;
        private CountDownLatch nextCountDown;


        @Override
        public void run() {
            try {
                if(preCountDown!=null){
                    preCountDown.await();
                    System.out.println("当前线程:"+Thread.currentThread().getName());
                }
                nextCountDown.countDown();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

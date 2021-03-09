package com.dulianbin.demo.thread.bankAccount;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Bank {

    public static void main(String[] args) {
        MyAccount myCount=new MyAccount("95599200901215522",1000);
        ExecutorService pool= Executors.newFixedThreadPool(3);
        Thread t1 = new SaveMoneyThread("S1", myCount, 100);
        Thread t2 = new SaveMoneyThread("S2", myCount, 1000);
        Thread t3 = new DrawMoneyThread("D1", myCount, 12600);
        Thread t4 = new DrawMoneyThread("S3", myCount, 600);
        Thread t5 = new DrawMoneyThread("D2", myCount, 2300);
        Thread t6 = new DrawMoneyThread("D3", myCount, 1800);
        Thread t7 = new SaveMoneyThread("S4", myCount, 200);

        // 执行各个线程
        pool.execute(t1);
        pool.execute(t2);
        pool.execute(t3);
        pool.execute(t4);
        pool.execute(t5);
        pool.execute(t6);
        pool.execute(t7);

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        // 关闭线程池
        pool.shutdown();


    }
}

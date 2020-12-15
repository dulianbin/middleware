package com.dulianbin.demo.thread.test;

import java.util.concurrent.CountDownLatch;

public class Test extends Thread {


    public static void main(String[] args) {
        CountDownLatch c1=new CountDownLatch(0);
        CountDownLatch c2=new CountDownLatch(1);
        CountDownLatch c3=new CountDownLatch(1);

        Thread t1=new Thread(new DulianbinWork(c1,c2),"线程1");
        Thread t2=new Thread(new DulianbinWork(c2,c3),"线程2");
        Thread t3=new Thread(new DulianbinWork(c3,c3),"线程3");
        t1.start();
        t2.start();
        t3.start();
    }





    static class DulianbinWork implements Runnable{

        private CountDownLatch prevThread;
        private CountDownLatch nextThread;

        public DulianbinWork(CountDownLatch prevThread, CountDownLatch nextThread) {
            this.prevThread = prevThread;
            this.nextThread = nextThread;
        }

        @Override
        public void run() {
            try {
                prevThread.await();
                System.out.println("当前线程:"+Thread.currentThread().getName());
                nextThread.countDown();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }


        }
    }
}

package com.dulianbin.demo.thread.test;

import java.util.concurrent.CountDownLatch;

public class CountDownLatchTest {

    public static void main(String[] args) {
        CountDownLatch cd1=new CountDownLatch(0);
        CountDownLatch cd2=new CountDownLatch(1);
        CountDownLatch cd3=new CountDownLatch(1);

        Thread t1=new Thread(new CountDownWork(cd1,cd2),"线程1");
        Thread t2=new Thread(new CountDownWork(cd2,cd3),"线程2");
        Thread t3=new Thread(new CountDownWork(cd3,cd3),"线程3");
        t1.start();
        t2.start();
        t3.start();

    }

    static class CountDownWork implements Runnable{

        private CountDownLatch currentCountDown;
        private CountDownLatch nextCountDown;

        public CountDownWork(CountDownLatch currentCountDown, CountDownLatch nextCountDown) {
            this.currentCountDown = currentCountDown;
            this.nextCountDown = nextCountDown;
        }

        @Override
        public void run() {
            try {
                currentCountDown.await();
                System.out.println(Thread.currentThread().getName());
                nextCountDown.countDown();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }


    }

}


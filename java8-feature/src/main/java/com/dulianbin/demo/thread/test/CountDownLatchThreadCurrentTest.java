package com.dulianbin.demo.thread.test;

import java.util.concurrent.CountDownLatch;

/**
 * 该类通过countDownLatch实现并发测试，前期预热创建指定线程数并阻塞，
 * 当线程数都创建成功，才打开执行开关，实现线程并发，类似jemeter并发测试功能
 */
public class CountDownLatchThreadCurrentTest implements  Runnable{
    private CountDownLatch currentSwitch;
    public static void main(String[] args) {
        CountDownLatch currentSwitch=new CountDownLatch(1);
        for (int i=0;i<=10000;i++){
            new Thread(new CountDownLatchThreadCurrentTest(currentSwitch),"当前线程_"+i).start();
        }
        currentSwitch.countDown();
    }

    public CountDownLatchThreadCurrentTest(CountDownLatch currentSwitch) {
        this.currentSwitch = currentSwitch;
    }

    @Override
    public void run() {
        try {
            System.out.println("线程已经预热，等待开关释放当前时间："+System.currentTimeMillis()+",当前线程:"+Thread.currentThread().getName());
            currentSwitch.await();
            System.out.println("当前时间："+System.currentTimeMillis()+",当前线程:"+Thread.currentThread().getName()+",执行了");

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

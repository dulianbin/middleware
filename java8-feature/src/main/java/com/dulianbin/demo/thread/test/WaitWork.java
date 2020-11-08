package com.dulianbin.demo.thread.test;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

public class WaitWork implements Runnable{

    private Lock lock;
    private Condition condition;

    public WaitWork(Lock lock,Condition condition) {
        this.lock=lock;
        this.condition=condition;
    }

    @Override
    public void run() {
        try {
            lock.lock();
            System.out.println("waidWork等待-开始");
            condition.await();
            System.out.println("waidWork等待-结束");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }

}

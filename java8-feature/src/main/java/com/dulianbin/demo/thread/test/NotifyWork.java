package com.dulianbin.demo.thread.test;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

public class NotifyWork implements Runnable {
    private Condition condition;
    private Lock lock;

    public NotifyWork(Lock lock,Condition condition) {
        this.lock=lock;
        this.condition = condition;
    }

    @Override
    public void run() {
        try{
            lock.lock();
            System.out.println("notify work开始");
            condition.signal();
            System.out.println("notify work结束");
        }finally {
            lock.unlock();
        }

    }
}

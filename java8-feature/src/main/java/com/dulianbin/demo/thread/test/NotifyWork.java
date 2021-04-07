package com.dulianbin.demo.thread.test;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

public class NotifyWork implements Runnable {

    private Lock lock;

    private Condition condition;

    public NotifyWork(Lock lock, Condition condition){

        this.lock=lock;
        this.condition=condition;
    }

    @Override
    public void run() {

        try{
            lock.lock();
            System.out.println("NotifyWork 开始");
            condition.signal();
            System.out.println("NotifyWork end");




        }catch(Exception e){
            e.printStackTrace();
        }finally {
            lock.unlock();
        }


    }
}

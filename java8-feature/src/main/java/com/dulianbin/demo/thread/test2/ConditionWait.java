package com.dulianbin.demo.thread.test2;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

/**
 * 腾讯课堂搜索 咕泡学院
 * 加群获取视频：608583947
 * 风骚的Michael 老师
 */
public class ConditionWait implements Runnable{

    private Lock lock;
    private Condition condition;

    public ConditionWait(Lock lock, Condition condition) {
        this.lock = lock;
        this.condition = condition;
    }
    @Override
    public void run() {
        try {
            lock.lock(); //竞争锁
            try {
                System.out.println("开始获取资源进入等待模式 - ConditionWait");
                condition.await();//阻塞(1. 释放锁, 2.阻塞当前线程, FIFO（单向、双向）)
                System.out.println("获取了资源并结束 - ConditionWait");

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }finally {
            lock.unlock();//释放锁
        }


    }


}

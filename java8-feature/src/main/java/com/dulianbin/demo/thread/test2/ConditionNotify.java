package com.dulianbin.demo.thread.test2;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

/**
 * 腾讯课堂搜索 咕泡学院
 * 加群获取视频：608583947
 * 风骚的Michael 老师
 */
public class ConditionNotify implements Runnable{

    private Lock lock;
    private Condition condition;

    public ConditionNotify(Lock lock, Condition condition) {
        this.lock = lock;
        this.condition = condition;
    }

    @Override
    public void run() {
        try{
            lock.lock();//获得了锁.
            System.out.println("获取资源前期准备，准备唤起线程 - conditionNotify");
            condition.signal();//唤醒阻塞状态的线程

            //if(uncondition){
//                condition.await();
            // }
            //condition.notify;

            //condition.await();
            System.out.println("获取资源前期准备完了，结束线程 - conditionNotify");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock(); //释放锁
        }
    }
}

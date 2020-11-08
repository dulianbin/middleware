package com.dulianbin.demo.thread.test;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ReentratLockConditionTest {

    public static void main(String[] args) {

        Lock lock=new ReentrantLock();
        Condition condition=lock.newCondition();

        //WaitWork waitWork=new WaitWork(lock,condition);

       // NotifyWork notifyWork=new NotifyWork(lock,condition);

        Thread t1=new Thread(new WaitWork(lock,condition));
        t1.start();
        Thread t2=new Thread(new NotifyWork(lock,condition));
        t2.start();

    }

}

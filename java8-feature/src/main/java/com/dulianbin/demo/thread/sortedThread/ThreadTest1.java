package com.dulianbin.demo.thread.sortedThread;

/**
 * 该方法保证三个线程顺序执行
 * T1、T2、T3 依次顺序执行
 * thread.Join把指定的线程加入到当前线程，可以将两个交替执行的线程合并为顺序执行的线程。比如在线程B中调用了线程A的Join()方法，直到线程A执行完毕后，才会继续执行线程B
 */
public class ThreadTest1  {
    // T1、T2、T3三个线程顺序执行
    public static void main(String[] args) {
        Thread t1 = new Thread(new Work(null),"线程1");
        Thread t2 = new Thread(new Work(t1),"线程2");
        Thread t3 = new Thread(new Work(t2),"线程3");
        t1.start();
        t2.start();
        t3.start();

    }
}

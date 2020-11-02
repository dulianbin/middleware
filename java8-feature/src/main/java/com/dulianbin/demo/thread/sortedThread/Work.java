package com.dulianbin.demo.thread.sortedThread;

public class Work implements Runnable{

    private Thread beforeThread;
    public Work(Thread beforeThread) {
        this.beforeThread = beforeThread;
    }
    public void run() {
        if (beforeThread != null) {
            try {
                beforeThread.join();
                System.out.println("thread start:" + Thread.currentThread().getName()+",上一个线程名称beforeThread:"+beforeThread.getName());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        } else {
            System.out.println("thread start:" + Thread.currentThread().getName());
        }
    }
}


package com.dulianbin.demo.thread.test;

public class JoinTest implements Runnable{

    private Thread current;
    public static void main(String[] args) {
        Thread t1=new Thread(new JoinTest(null),"线程1");
        Thread t2=new Thread(new JoinTest(t1),"线程2");
        Thread t3=new Thread(new JoinTest(t2),"线程3");
        t1.start();
        t2.start();
        t3.start();
    }

    public JoinTest(Thread current) {
        this.current = current;
    }

    @Override
    public void run() {
        try {
            if(current!=null){
                current.join();
            }
            System.out.println(Thread.currentThread().getName());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}

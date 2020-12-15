package com.dulianbin.demo.thread;

public class Test2 {

    public static void main(String[] args) {

        Thread t1=new Thread(new Work(null),"线程1");
        Thread t2=new Thread(new Work(t1),"线程2");
        Thread t3=new Thread(new Work(t2),"线程3");

        t3.start();
        t1.start();
        t2.start();
    }


    static class Work implements Runnable{

        private Thread thread;

        public Work(Thread thread){
            this.thread=thread;
        }

        @Override
        public void run() {
            try {
                if(thread!=null){
                    thread.join();
                }
                System.out.println("我是线程："+Thread.currentThread().getName());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }




}

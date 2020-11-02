package com.dulianbin.demo.thread.CountDownLatchThread;

import java.util.concurrent.CountDownLatch;
/*
        CountDownLatch
        *应用场景：
        *定义2个CountDownLatch对象
        *1）startSingle：使用开始信号，作为控制所有线程的执行开关
        *2）doneSingle：具体线程执行的信号
        *描述：
        *在所有任务执行前，先初始化一系列操作，当初始化完毕后，启动startSingle，开始
        *让其他线程进行执行任务，当所有任务执行完毕后，去执行主线程的任务
        *
        *
        */
public class CountDownLatchDemo1 {
    private static final int N =3;
    void main(){
        //开始
        CountDownLatch startSingle = new CountDownLatch(1);
        //每个线程去执行任务
        CountDownLatch doneSingle= new CountDownLatch(N);

        for(int i =0;i<N;i++)
            new Thread(new WorkerRunnable(startSingle, doneSingle, i)).start();
        //控制是否开始执行任务
        startSingle.countDown();
        System.out.println("66666");
        try {
            doneSingle.await();//doneSingle计数为0才可以执行
            System.out.println("主线程执行");
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }


    class WorkerRunnable implements Runnable{
        CountDownLatch start =null;
        CountDownLatch done = null;
        int num = 0;
        public WorkerRunnable(CountDownLatch startSingle, CountDownLatch doneSingle , int i) {
            this.start=startSingle;
            this.done=doneSingle;
            this.num=i;
        }

        @Override
        public void run() {
            try {
                start.await();
                doWork(num);
                done.countDown();
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }

        }

        public void doWork(int i){
            System.out.println("任务"+i+"执行");
        }


    }

    public static void main(String[] args) {
        CountDownLatchDemo1 demo1 = new CountDownLatchDemo1();
        demo1.main();
    }

}

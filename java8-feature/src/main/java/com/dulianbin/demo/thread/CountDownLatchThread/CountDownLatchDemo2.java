package com.dulianbin.demo.thread.CountDownLatchThread;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class CountDownLatchDemo2 {

    private static final int N = 3;

    void main() throws InterruptedException {
        //定义，线程同步等待对象
        CountDownLatch doneSignal = new CountDownLatch(N);
        //定义一个线程池，执行线程任务
        Executor executor = Executors.newFixedThreadPool(3);
        for (int i = 0; i < N; i++) {
            executor.execute(new WorkerRunnable(doneSignal, i));
        }
        //等待其他所有线程执行完，才去执行主线程的任务
        doneSignal.await();
        System.out.println("主线程执行");
    }

    class WorkerRunnable implements Runnable {
        private final CountDownLatch doneSignal;
        private final int i;

        WorkerRunnable(CountDownLatch doneSignal, int i) {
            this.doneSignal = doneSignal;
            this.i = i;
        }

        public void run() {
            try {
                doWork(i);
                doneSignal.countDown();
            } catch (Exception e) {

            } // return;
        }

        void doWork(int i) {
            System.out.println("任务" + i + "执行");
        }
    }

    public static void main(String[] args) {
        CountDownLatchDemo2 d = new CountDownLatchDemo2();
        try {
            d.main();
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}

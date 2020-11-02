package com.dulianbin.demo.thread.CountDownLatchThread;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class CountDownLatchDemo {
    private static final int N =3;

    public static void main(String[] args) {
        CountDownLatchDemo ss=new CountDownLatchDemo();
        ss.doSubTask();
    }

    void doSubTask() {
       try{
           CountDownLatch doneSignal =new CountDownLatch(N);
           Executor executor =Executors.newFixedThreadPool(3);

           for (int i=0;i<N;i++){
               executor.execute(new WorkRunnable(doneSignal , i));
           }
           doneSignal.await();
           System.out.println("子任务执行完毕，才可以执行主任务。");
       }catch(InterruptedException e){

       }
    }



    class WorkRunnable implements Runnable{

        private final  CountDownLatch doneSignal;
        private final  int i;

        public WorkRunnable(CountDownLatch doneSignal, int i) {
            this.doneSignal=doneSignal;
            this.i=i;
        }

        @Override
        public void run() {
            try{
                doWork(i);
                doneSignal.countDown();
            }catch(Exception e){

            }
        }

        void doWork(int i) {
            System.out.println("任务"+i+"执行");
        }
    }
}

package com.dulianbin.demo.thread.shunxuThread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class StrangePrinter3 {

    private int max;
    private AtomicInteger atomitInteger = new AtomicInteger(1); // AtomicInteger保证可见性，也可以用volatile
    private ReentrantLock lock = new ReentrantLock();
    private Condition odd = lock.newCondition(); //奇数条件
    private Condition even = lock.newCondition();//偶数条件

    public StrangePrinter3(int max) {
        this.max = max;
    }

    public static void main(String[] args) {
        StrangePrinter3 strangePrinter = new StrangePrinter3(100);
        ExecutorService executorService = Executors.newFixedThreadPool(2);
        executorService.submit(strangePrinter.new MyPrinter("偶数线程Printer", 0));
        executorService.submit(strangePrinter.new MyPrinter("奇数线程Printer", 1));
        executorService.shutdown();
    }

    class MyPrinter implements Runnable {
        private String name;
        private int type; // 打印的类型，0：代表打印奇数，1：代表打印偶数

        public MyPrinter(String name, int type) {
            this.name = name;
            this.type = type;
        }

        @Override
        public void run() {
            if (type == 1) {
                while (atomitInteger.get() <= max) { // 打印奇数
                    lock.lock();
                    try {
                        if (atomitInteger.get() % 2 == 0) {
                            odd.await();
                        }
                        if (atomitInteger.get() <= max) {
                            System.out.println(name + " - " + atomitInteger.getAndIncrement()); // 打印奇数
                        }
                        even.signal();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    } finally {
                        lock.unlock();
                    }
                }
            } else {
                while (atomitInteger.get() <= max) { // 打印偶数
                    lock.lock();
                    try {
                        if (atomitInteger.get() % 2 != 0) {
                            even.await();
                        }
                        if (atomitInteger.get() <= max) {
                            System.out.println(name + " - " + atomitInteger.getAndIncrement()); // 打印偶数
                        }
                        odd.signal();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    } finally {
                        lock.unlock();
                    }
                }
            }
        }
    }
}


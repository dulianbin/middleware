package com.dulianbin.demo.thread.bankAccount;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class MyAccount {
    private String oid;//用户账号
    private int cash;//账户余额

    //账户锁，这里采用公平锁，挂起的取款线程优先获得锁，而不是让其它存取款线程获得锁
    private Lock lock=new ReentrantLock(true);
    private Condition _save=lock.newCondition();  //存款条件
    private Condition _draw=lock.newCondition();  //取款条件


    public MyAccount(String oid, int cash){
        this.oid=oid;
        this.cash=cash;
    }

    /**
     * 存钱
     * @param name 存款人
     * @param money 存款金额
     */
    public void save(String name, int money){
        try{
            lock.lock();
            if(money<=0){
                System.out.println("存钱必须大于0");
                return ;
            }
            this.cash += money;
            System.out.println(name + "存款" + money + "，当前余额为" + this.cash);
            _save.signalAll();
        }finally {
            lock.unlock();
        }
    }

    /**
     * 取钱
     * @param name 存款人
     * @param money 取款金额
     */
    public void draw(String name, int money){
        try{
            lock.lock();
            if(this.cash-money<0){
                System.out.println(name+"账户余额:"+this.cash+"，而需要取:"+money+",因此余额不足");
                _draw.await(2, TimeUnit.SECONDS);
            }
            if(this.cash-money>=0){
                cash=this.cash-money;
                System.out.println(name+"账户余额:"+this.cash+"，取:"+money+",剩余账户余额:"+cash);
            }else{
                System.out.println(name+"账户余额2:"+this.cash+"，而需要取:"+money+",因此余额不足");
            }
            _draw.signalAll();
        }catch (InterruptedException e){

        }finally{
            lock.unlock();
        }
    }






}

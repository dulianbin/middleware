package com.dulianbin.demo.thread.bankAccount;

public class SaveMoneyThread extends Thread {

    private MyAccount myAccount;
    private String name;
    private Integer money;

    public SaveMoneyThread(String name, MyAccount myAccount,Integer money) {
        this.myAccount = myAccount;
        this.name = name;
        this.money = money;
    }

    @Override
    public void run() {
        myAccount.save(name, money);
    }
}

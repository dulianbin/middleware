package com.dulianbin.demo.patterns.chaintest;

import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.LinkedBlockingQueue;

public class PreRequestProcessor extends Thread implements IRequestProcessor{

    private LinkedBlockingQueue<RequestVo> request=new LinkedBlockingQueue<RequestVo>();

    private IRequestProcessor nextRequestProcessor;

    private volatile boolean isFinish;

    public PreRequestProcessor(){

    }

    public PreRequestProcessor(IRequestProcessor nextRequestProcessor){
        this.nextRequestProcessor=nextRequestProcessor;
    }

    public void shutDown(){
        this.isFinish=true;
    }

    @Override
    public void run() {
        while (!isFinish){
            try {
                RequestVo requestVo= request.take();
                //处理业务逻辑
                System.out.println("预处理调用链处理器请求参数："+requestVo.toString());
                nextRequestProcessor.process(requestVo);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void process(RequestVo requestVo) {
        request.add(requestVo);
    }




}

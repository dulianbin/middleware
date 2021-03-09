package com.dulianbin.demo.patterns.chaintest;

import java.util.concurrent.LinkedBlockingQueue;

public class PrintRequestProcessor extends Thread implements IRequestProcessor {

    private LinkedBlockingQueue<RequestVo> request=new LinkedBlockingQueue();

    private IRequestProcessor nextRequestProcessor;

    private boolean isFinish;

    public PrintRequestProcessor() {
    }

    public PrintRequestProcessor(IRequestProcessor nextRequestProcessor) {
        this.nextRequestProcessor = nextRequestProcessor;
    }

    public void shutdown(){
        this.isFinish=true;
    }



    @Override
    public void run() {
        while (!isFinish){
            try {
                RequestVo requestVo = request.take();
                System.out.println("打印调用链处理器请求参数："+requestVo.toString());
                if(nextRequestProcessor!=null){
                    nextRequestProcessor.process(requestVo);
                }
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

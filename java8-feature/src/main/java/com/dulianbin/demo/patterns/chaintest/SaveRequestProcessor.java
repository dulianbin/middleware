package com.dulianbin.demo.patterns.chaintest;


import java.util.concurrent.LinkedBlockingQueue;

public class SaveRequestProcessor extends Thread implements IRequestProcessor {

    private LinkedBlockingQueue<RequestVo> request=new LinkedBlockingQueue<>();

    private IRequestProcessor nextRequestProcessor;

    private boolean isFinish;

    public SaveRequestProcessor(){

    }

    public SaveRequestProcessor(IRequestProcessor nextRequestProcessor) {
        this.nextRequestProcessor = nextRequestProcessor;
    }

    public void shutdown(){
        this.isFinish=true;
    }

    @Override
    public void run() {
        while (!isFinish){
            try {
                RequestVo requestVo=request.take();
                System.out.println("保存调用链请求参数:"+requestVo.toString());
                nextRequestProcessor.process(requestVo);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }


    @Override
    public void process(RequestVo requestVo) {
        this.request.add(requestVo);
    }


}

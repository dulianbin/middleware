package com.dulianbin.demo.patterns.chaintest;


public class ChainTest {

    static IRequestProcessor preProcessor;

    public static void main(String[] args) {
        ChainTest test=new ChainTest();
        test.up();

        RequestVo requestVo=new RequestVo();
        requestVo.setName("杜联斌");
        requestVo.setAge(29);

        preProcessor.process(requestVo);
    }

    public void up(){
        PrintRequestProcessor printProcessor=new PrintRequestProcessor();
        printProcessor.start();
        SaveRequestProcessor saveProcessor=new SaveRequestProcessor(printProcessor);
        saveProcessor.start();
        preProcessor=new PreRequestProcessor(saveProcessor);
        ((PreRequestProcessor) preProcessor).start();
    }
}

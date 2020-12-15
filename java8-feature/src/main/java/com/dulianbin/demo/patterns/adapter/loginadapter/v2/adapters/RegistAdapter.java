package com.dulianbin.demo.patterns.adapter.loginadapter.v2.adapters;


import com.dulianbin.demo.patterns.adapter.loginadapter.ResultMsg;

/**
 * Created by Tom on 2019/3/16.
 */
public interface RegistAdapter {
    boolean support(Object adapter);
    ResultMsg login(String id, Object adapter);
}

package com.dlb.tomcat.servlet;

import com.dlb.tomcat.http.DulianbinRequest;
import com.dlb.tomcat.http.DulianbinResponse;
import com.dlb.tomcat.http.DulianbinServlet;

public class SecondHelloWorldServlet extends DulianbinServlet {
    @Override
    public void doGet(DulianbinRequest request, DulianbinResponse response) throws Exception {
        this.doPost(request, response);
    }

    @Override
    public void doPost(DulianbinRequest request, DulianbinResponse response) throws Exception {
        response.write("{\"code\":0,\"message\":\"请求成功\",\"message\":\"库存添加成功\"}");
    }

}

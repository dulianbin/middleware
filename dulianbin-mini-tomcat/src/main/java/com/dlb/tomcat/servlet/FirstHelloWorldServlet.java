package com.dlb.tomcat.servlet;

import com.dlb.tomcat.http.DulianbinRequest;
import com.dlb.tomcat.http.DulianbinResponse;
import com.dlb.tomcat.http.DulianbinServlet;

public class FirstHelloWorldServlet extends DulianbinServlet {

    @Override
    public void doGet(DulianbinRequest request, DulianbinResponse response) throws Exception {
        this.doPost(request, response);
    }

    @Override
    public void doPost(DulianbinRequest request, DulianbinResponse response) throws Exception {
        String sss=request.getParameter("dulianbin");
        System.out.println("参数:"+sss);
        response.write("{\"code\":0,\"message\":\"请求成功\"}");
    }
}

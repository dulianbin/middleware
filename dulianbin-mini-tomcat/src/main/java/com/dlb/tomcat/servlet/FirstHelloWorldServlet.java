package com.dlb.tomcat.servlet;

import com.dlb.tomcat.DuLianBinTomcat;
import com.dlb.tomcat.http.DulianbinRequest;
import com.dlb.tomcat.http.DulianbinResponse;
import com.dlb.tomcat.http.DulianbinServlet;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class FirstHelloWorldServlet extends DulianbinServlet {
    private static final Logger logger = LoggerFactory.getLogger(FirstHelloWorldServlet.class);
    @Override
    public void doGet(DulianbinRequest request, DulianbinResponse response) throws Exception {
        this.doPost(request, response);
    }

    @Override
    public void doPost(DulianbinRequest request, DulianbinResponse response) throws Exception {
        String sss=request.getParameter("dulianbin");
        logger.info("参数:"+sss);
        /*String json=request.getJSONParameter();
        System.out.println("json:"+json);*/
        response.write("{\"code\":0,\"message\":\"请求成功\",\"message\":\"库存扣减成功\"}");
    }
}

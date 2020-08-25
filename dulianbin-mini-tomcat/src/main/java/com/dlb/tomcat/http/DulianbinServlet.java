package com.dlb.tomcat.http;

public abstract class DulianbinServlet {

    public void service(DulianbinRequest request, DulianbinResponse response) throws Exception{

        if("GET".equalsIgnoreCase(request.getMethod())){
            doGet(request ,response);
        }else {
            doPost(request ,response);
        }
    }

    public abstract void doPost(DulianbinRequest request, DulianbinResponse response) throws Exception;

    public abstract void doGet(DulianbinRequest request, DulianbinResponse response) throws Exception;
}

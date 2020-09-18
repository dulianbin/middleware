package com.dlb.tomcat.http;

import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.http.HttpRequest;
import io.netty.handler.codec.http.QueryStringDecoder;

import java.util.List;
import java.util.Map;

public class DulianbinRequest {
    private ChannelHandlerContext context;

    private HttpRequest req;

    public DulianbinRequest(ChannelHandlerContext context, HttpRequest req) {
        this.context = context;
        this.req = req;
    }

    public String getUrl(){
        return req.uri();
    }

    public String getMethod(){
        return req.getMethod().name();
    }

/*    public String getJSONParameter(){
        ByteBuf jsonBuf = req.;
        String jsonStr = jsonBuf.toString(CharsetUtil.UTF_8);
        *//*JSONObject jsonObj = JSONObject.fromObject(jsonStr);
        String jobType = jsonObj.getString("jobType");
        return jobType;*//*
        return jsonStr;
    }*/

    public Map<String, List<String>> getParameters(){
        QueryStringDecoder decoder = new QueryStringDecoder(req.uri());
        return decoder.parameters();
    }

    public String getParameter(String name) {
        Map<String, List<String>> params = getParameters();
        List<String> param = params.get(name);
        if (null == param) {
            return null;
        } else {
            return param.get(0);
        }
    }


}

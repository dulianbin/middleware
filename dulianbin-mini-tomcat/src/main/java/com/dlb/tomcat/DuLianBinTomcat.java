package com.dlb.tomcat;

import com.dlb.tomcat.http.DulianbinRequest;
import com.dlb.tomcat.http.DulianbinResponse;
import com.dlb.tomcat.http.DulianbinServlet;

import io.netty.handler.codec.http.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.*;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;

import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

public class DuLianBinTomcat {

    private int port = 8080;

    private Map<String, DulianbinServlet> servletMapping = new HashMap<String, DulianbinServlet>();

    private Properties webxml = new Properties();

    private String urlPattern="";

    private static final Logger logger = LoggerFactory.getLogger(DuLianBinTomcat.class);

    public static void main(String[] args) {
        new DuLianBinTomcat().start();
    }

    private void init(){
        try{
            /*String WEB_INF=this.getClass().getResource("/").getPath();
            InputStream inputStream=new FileInputStream(WEB_INF+"web.properties");*/
            InputStream inputStream=this.getClass().getResourceAsStream("/web.properties");
            webxml.load(inputStream);

            for (Object key: webxml.keySet()){
                String k=key.toString();
                if(k.endsWith(".url")){
                    String servletName=k.replaceAll("\\.url$","");
                    String url = webxml.getProperty(k).split("\\.")[0];
                    System.out.println("servletName:"+servletName+",url:"+url);
                    String className = webxml.getProperty(servletName + ".className");
                    DulianbinServlet servlet=(DulianbinServlet)Class.forName(className).newInstance();
                    servletMapping.put(url, servlet);
                }
                if("servelt.port".equals(k)){
                    port=Integer.parseInt(webxml.getProperty(k));
                }

                if("url.pattern".equals(k)){
                    urlPattern=urlPattern(webxml.getProperty(k));
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    private String urlPattern(String suffix) throws Exception{
        if(suffix==null || "".equals(suffix)|| "\\/".equals(suffix) || "\\/*".equals(suffix) ){
            return ".";
        }

        if(suffix.contains(".")){
            return "."+suffix.split("\\.")[1];
        }
        throw new Exception("配置异常");
    }

    public void start(){
        init();
        //netty封装了NIO Reactor模型，boss，work
        //boss线程
        EventLoopGroup bossGroup=new NioEventLoopGroup();
        //work线程
        EventLoopGroup workerGroup=new NioEventLoopGroup();

        try{

            ServerBootstrap server=new ServerBootstrap();

            server.group(bossGroup,workerGroup)
                    .channel(NioServerSocketChannel.class)
                    .childHandler(new ChannelInitializer<SocketChannel>() {
                        // 客户端初始化处理
                        @Override
                        protected void initChannel(SocketChannel client) throws Exception {
                            client.pipeline().addLast(new HttpResponseEncoder());
                            client.pipeline().addLast(new HttpRequestDecoder());
                            client.pipeline().addLast(new DulianbinTomcatHandler());
                        }
                    })
                    // 针对主线程的配置 分配线程最大数量 128
                    .option(ChannelOption.SO_BACKLOG,128)
                    // 针对子线程的配置 保持长连接
                    .childOption(ChannelOption.SO_KEEPALIVE,true);

            // 启动服务器
            ChannelFuture f=server.bind(port).sync();
            System.out.println("GP Tomcat 已启动，监听的端口是：" + port);
            f.channel().closeFuture().sync();
        }catch(Exception e){
            e.printStackTrace();
        }finally {
            // 关闭线程池
            bossGroup.shutdownGracefully();
            workerGroup.shutdownGracefully();
        }
    }


    public class DulianbinTomcatHandler extends ChannelInboundHandlerAdapter {

        @Override
        public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
            if (msg instanceof HttpRequest){
                HttpRequest req = (HttpRequest) msg;

                // 转交给我们自己的request实现
                DulianbinRequest request = new DulianbinRequest(ctx,req);
                // 转交给我们自己的response实现
                DulianbinResponse response = new DulianbinResponse(ctx,req);
                // 实际业务处理
                String originalUrl = request.getUrl();
                String url=getUrl(originalUrl).split("\\.")[0];
                logger.error("请求当前请求的url:"+originalUrl+",处理后的url:"+url);
                if(url!=null && servletMapping.containsKey(url)){
                    servletMapping.get(url).service(request, response);
                }else{
                    response.write("404 - Not Found");
                }

            }
        }
    }

    private String getUrl(String url){

        String tempUrl=null;
        if(url.contains("?")){
            tempUrl=url.split("\\?")[0];
        }else{
            tempUrl=url;
        }

        if(".".equals(urlPattern)){
            return tempUrl;
        }
        if(tempUrl.lastIndexOf(urlPattern)<=0){
            return null;
        }
        return tempUrl;
    }
}

package com.dulianbin.java.consumer.proxy;

import com.alibaba.fastjson.JSON;
import com.dulianbin.java.protocol.InvokerProtocol;
import io.netty.bootstrap.Bootstrap;
import io.netty.channel.*;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.codec.LengthFieldBasedFrameDecoder;
import io.netty.handler.codec.LengthFieldPrepender;
import io.netty.handler.codec.serialization.ClassResolvers;
import io.netty.handler.codec.serialization.ObjectDecoder;
import io.netty.handler.codec.serialization.ObjectEncoder;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class RpcProxy {

    public static <T> T create(Class<?> clazz){
        MethodProxy proxy=new MethodProxy(clazz);
        Class<?> [] interfaces=clazz.isInterface()? new Class[]{clazz}:clazz.getInterfaces();
        T t= (T) Proxy.newProxyInstance(clazz.getClassLoader(), interfaces,proxy);
        return t;
    }


    private static class MethodProxy implements InvocationHandler {

        private Class<?> clazz;
        public MethodProxy(Class<?> clazz){
            this.clazz = clazz;
        }

        @Override
        public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

            //如果传进来是一个已实现的具体类（本次演示略过此逻辑)
            System.out.println("这是啥:"+method.getDeclaringClass());
            if(Object.class.equals(method.getDeclaringClass())){
                try{
                    method.invoke(this, args);
                }catch(Exception e){
                    e.printStackTrace();
                }
            }else{
                return rpcInvoke(proxy,method, args);
            }
            return null;
        }

        private Object rpcInvoke(Object proxy, Method method, Object[] args) {

            InvokerProtocol invokerProtocol=new InvokerProtocol();
            invokerProtocol.setClassName(this.clazz.getName());
            invokerProtocol.setMothodName(method.getName());
            invokerProtocol.setParams(method.getParameterTypes());
            invokerProtocol.setValues(args);
            System.out.println("消费者协议参数："+ JSON.toJSONString(invokerProtocol));

            final RpcProxyHandler consumerHandler = new RpcProxyHandler();
            EventLoopGroup bossGroup=new NioEventLoopGroup();
            try{
                Bootstrap bootstrap=new Bootstrap();
                bootstrap.group(bossGroup)
                        .channel(NioSocketChannel.class)
                        .option(ChannelOption.TCP_NODELAY,true)
                        .handler(new ChannelInitializer<SocketChannel>(){
                            @Override
                            protected void initChannel(SocketChannel socketChannel) throws Exception {
                                ChannelPipeline pipeline=socketChannel.pipeline();
                                /** 入参有5个，分别解释如下
                                 maxFrameLength：框架的最大长度。如果帧的长度大于此值，则将抛出TooLongFrameException。
                                 lengthFieldOffset：长度字段的偏移量：即对应的长度字段在整个消息数据中得位置
                                 lengthFieldLength：长度字段的长度：如：长度字段是int型表示，那么这个值就是4（long型就是8）
                                 lengthAdjustment：要添加到长度字段值的补偿值
                                 initialBytesToStrip：从解码帧中去除的第一个字节数
                                 */
                                pipeline.addLast("frameDecoder", new LengthFieldBasedFrameDecoder(Integer.MAX_VALUE, 0, 4, 0, 4));
                                //自定义协议编码器
                                pipeline.addLast("frameEncoder", new LengthFieldPrepender(4));
                                //对象参数类型编码器
                                pipeline.addLast("encoder", new ObjectEncoder());
                                //对象参数类型解码器
                                pipeline.addLast("decoder", new ObjectDecoder(Integer.MAX_VALUE, ClassResolvers.cacheDisabled(null)));
                                pipeline.addLast("handler",consumerHandler);
                            }
                        });
               ChannelFuture future= bootstrap.connect("localhost",9999).sync();
                future.channel().writeAndFlush(invokerProtocol).sync();
                future.channel().closeFuture().sync();
            }catch(Exception e){
                e.printStackTrace();
            }finally {
                bossGroup.shutdownGracefully();
            }
           return consumerHandler.getResponse();
        }
    }
}

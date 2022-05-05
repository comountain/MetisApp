package com.example.activity.service;


import com.example.activity.message.CompeteMessage;
import com.example.activity.message.GamerMessage;
import com.example.activity.message.MatchMessage;

import java.util.HashMap;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.codec.string.StringDecoder;
import io.netty.handler.codec.string.StringEncoder;

public class CientService {
    private String user;
    private int competeNum = 0;
    private SocketChannel channel;
    private String[] playername = null;
    private HashMap<String, String> gameresult = new HashMap<>();
    boolean ifMatched = false;


    public boolean isIfMatched() {
        return ifMatched;
    }

    public HashMap<String, String> getGameresult()
    {
        return gameresult;
    }

    public void start()
    {
        NioEventLoopGroup group = new NioEventLoopGroup();
        try{
            Bootstrap bootstrap = new Bootstrap();
            bootstrap.channel(NioSocketChannel.class);
            bootstrap.group(group);
            bootstrap.handler(new ChannelInitializer<SocketChannel>() {
                @Override
                protected void initChannel(SocketChannel ch) throws Exception {
                    ch.pipeline().addLast(new StringDecoder());
                    ch.pipeline().addLast(new StringEncoder());
                    ch.pipeline().addLast("client handler",new ChannelInboundHandlerAdapter(){
                        @Override
                        public void channelActive(ChannelHandlerContext ctx) throws Exception{
                            new Thread(()->{
                               System.out.println("连接服务器中");
                            },"system in").start();
                        }

                        public void channelRead(ChannelHandlerContext ctx, Object msg){
                            String retmes = (String) msg;
                            String[] news = retmes.split("_");
                            switch (news[0])
                            {
                                case "1":
                                    break;
                                case "2":
                                    playername = new String[2];
                                    playername[0] = news[1];
                                    playername[1] = news[2];
                                    ifMatched = true;
                                    break;
                                case "3":
                                    if(news[1] != user)
                                        gameresult.put(news[1],news[2]);
                                    break;
                            }
                        }
                    });
                }
            });
            ChannelFuture future =bootstrap.connect("192.168.1.106",8888).sync();
            channel = (SocketChannel) future.channel();

        } catch (Exception e){
            group.shutdownGracefully();
        }
    }

    public void sendMessage(GamerMessage mes)
    {
        String msg = mes.MessageString();
        channel.writeAndFlush(msg);
    }

    public void sendMessage(MatchMessage mes)
    {
        String msg = mes.MessageString();
        channel.writeAndFlush(msg);
    }

    public void sendMessage(CompeteMessage mes)
    {
        String msg = mes.MessageString();
        channel.writeAndFlush(msg);
    }

    public void resetPlayername()
    {
        playername = null;
    }

    public void resetGameresult()
    {
        gameresult = new HashMap<String, String>();
    }
    public void resetIfMatched()
    {
        ifMatched = false;
    }

    public void setCompeteNum(int num)
    {
        competeNum = num;
    }

    public void setUser(String name)
    {
        user = name;
    }
}


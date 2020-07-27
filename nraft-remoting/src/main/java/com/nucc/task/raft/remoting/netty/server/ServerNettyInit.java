package com.nucc.task.raft.remoting.netty.server;

import com.nucc.task.raft.remoting.protocols.RpcDecoder;
import com.nucc.task.raft.remoting.protocols.RpcEncoder;
import com.nucc.task.raft.remoting.rpc.ServerService;
import com.nucc.task.raft.remoting.rpc.dto.RequestCommon;
import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;

public class ServerNettyInit {

    public static void start(String hostName, int port) {
        System.out.println("服务端通讯正在启动中...................");
        // 注入服务，不初始化，每次代理也可以
        ServerService.initService();

        EventLoopGroup bossGroup = new NioEventLoopGroup();
        EventLoopGroup workerGroup = new NioEventLoopGroup();
        try {
            ServerBootstrap bootstrap = new ServerBootstrap();
            bootstrap.group(bossGroup, workerGroup);
            bootstrap.channel(NioServerSocketChannel.class);
            bootstrap.childHandler(new ChannelInitializer<SocketChannel>() {
                protected void initChannel(SocketChannel socketChannel) throws Exception {
                    ChannelPipeline pipeline = socketChannel.pipeline();
                    pipeline.addLast(new RpcDecoder(RequestCommon.class));
                    pipeline.addLast(new RpcEncoder());
                    pipeline.addLast(new ServerNettyHandler());
                }
            });
            bootstrap.childOption(ChannelOption.SO_KEEPALIVE, true);
            bootstrap.bind(hostName, port).sync();
            System.out.println("服务端通讯启动完成...................");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}

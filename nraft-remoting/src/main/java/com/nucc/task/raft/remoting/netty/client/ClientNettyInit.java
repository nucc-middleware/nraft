package com.nucc.task.raft.remoting.netty.client;


import com.nucc.task.raft.remoting.protocols.RpcDecoder;
import com.nucc.task.raft.remoting.protocols.RpcEncoder;
import com.nucc.task.raft.remoting.rpc.dto.ResponseCommon;
import io.netty.bootstrap.Bootstrap;
import io.netty.channel.*;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;

/**
 * 初始化连接，并且保存Channel
 */
public class ClientNettyInit {

    public static Channel initConnect(String host, int port) {
        System.out.println("初始化客户端连接。。。。。" + host + ":" + port);
        NioEventLoopGroup group = new NioEventLoopGroup();
        try {
            Bootstrap bootstrap = new Bootstrap();
            bootstrap.group(group);
            bootstrap.channel(NioSocketChannel.class);
            bootstrap.handler(new ChannelInitializer<SocketChannel>() {
                protected void initChannel(SocketChannel socketChannel) throws Exception {
                    ChannelPipeline pipeline = socketChannel.pipeline();
                    pipeline.addLast(new RpcEncoder());
                    pipeline.addLast(new RpcDecoder(ResponseCommon.class));
                    pipeline.addLast(new ClientNettyHandler());
                }
            });
            bootstrap.option(ChannelOption.SO_KEEPALIVE, true);
            ChannelFuture future = bootstrap.connect(host, port).sync();
            //做个记录保存，下次不用重新初始化
            ClientSendMessage.channelMap.put(host + ":" + port, future.channel());
            System.out.println("初始化客户端连接成功。。。。。" + host + ":" + port);
            return future.channel();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}

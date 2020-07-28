package com.nucc.raft.remoting.netty.server;

import com.nucc.raft.concurrent.ExecutorsCommon;
import com.nucc.raft.remoting.rpc.dto.RequestCommon;
import com.nucc.raft.remoting.rpc.dto.ResponseCommon;
import com.nucc.raft.remoting.rpc.handler.MsgHandler;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelFutureListener;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

/**
 * 处理类，把msg强制转换，然后调用Msghandler.handler处理
 */
public class ServerNettyHandler extends ChannelInboundHandlerAdapter {

    @Override
    public void channelRead(final ChannelHandlerContext ctx, final Object msg) {
        ExecutorsCommon.nettyExecutorService.submit(new Runnable() {
            public void run() {
                final RequestCommon requestCommon = (RequestCommon) msg;
                ResponseCommon responseCommon = MsgHandler.handler(requestCommon);
                responseCommon.setRequestId(requestCommon.getRequesetId());
                ctx.writeAndFlush(responseCommon).addListener(new ChannelFutureListener() {
                    public void operationComplete(ChannelFuture channelFuture) throws Exception {
                        System.out.println("消息处理结束........" + requestCommon.getRequesetId());
                    }
                });
            }
        });
    }


}

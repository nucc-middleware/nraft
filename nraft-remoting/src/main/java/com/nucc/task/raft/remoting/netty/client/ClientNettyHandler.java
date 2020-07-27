package com.nucc.task.raft.remoting.netty.client;


import com.nucc.task.raft.remoting.rpc.MessageStore;
import com.nucc.task.raft.remoting.rpc.dto.RequestCommon;
import com.nucc.task.raft.remoting.rpc.dto.ResponseCommon;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

public class ClientNettyHandler extends SimpleChannelInboundHandler<ResponseCommon> {

    @Override
    protected void channelRead0(ChannelHandlerContext channelHandlerContext, ResponseCommon responseCommon) throws Exception {
        if (null != responseCommon.getException()) {
            throw new RuntimeException("server run error:" + responseCommon.getException());
        }
        RequestCommon requestCommon = MessageStore.map.get(responseCommon.getRequestId());
        requestCommon.setResult(responseCommon.getResult());
    }
}

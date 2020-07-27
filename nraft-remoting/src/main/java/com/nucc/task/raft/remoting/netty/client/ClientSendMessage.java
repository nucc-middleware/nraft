package com.nucc.task.raft.remoting.netty.client;


import com.nucc.task.raft.remoting.rpc.dto.RequestCommon;
import io.netty.channel.Channel;

import java.util.concurrent.ConcurrentHashMap;

public class ClientSendMessage {
    /**
     * 做缓存连接
     */
    public static ConcurrentHashMap<String, Channel> channelMap = new ConcurrentHashMap<String, Channel>();

    public static boolean sendMessage(String ip, int port, RequestCommon requestCommon) {
        boolean result = false;
        Channel channel = channelMap.get(ip + ":" + port);
        if (channel == null) {
            channel = ClientNettyInit.initConnect(ip, port);
        }
        try {
            channel.writeAndFlush(requestCommon).sync();
            result = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }
}

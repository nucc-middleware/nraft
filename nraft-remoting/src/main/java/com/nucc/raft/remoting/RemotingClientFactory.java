package com.nucc.raft.remoting;

import com.nucc.raft.remoting.rpc.ClientProxy;

public class RemotingClientFactory {
    /**
     * 等后期，把端口ip换成Node节点的id，然后根据id去配置取
     *
     * @param ip
     * @param port
     * @return
     */
    public static ClientProxy clientProxy(String ip, int port) {
        return new ClientProxy(ip, port);
    }
}

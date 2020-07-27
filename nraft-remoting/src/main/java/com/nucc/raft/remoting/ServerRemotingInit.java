package com.nucc.raft.remoting;

import com.nucc.raft.remoting.netty.server.ServerNettyInit;

public class ServerRemotingInit {

    public static void start(String hostName, int port) {
        ServerNettyInit.init(hostName, port);
    }

}

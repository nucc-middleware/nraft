package com.nucc.task.raft.remoting.start;


import com.nucc.task.raft.remoting.netty.server.ServerNettyInit;

public class ServerStartTest {
    public static void main(String[] args) {
        ServerNettyInit.start("127.0.0.1", 9095);
    }
}

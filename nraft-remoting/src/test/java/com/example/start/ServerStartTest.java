package com.example.start;


import com.example.server.MsgServiceDemoImpl;
import com.nucc.raft.remoting.ServerRemotingInit;
import com.nucc.raft.remoting.rpc.ServiceExposure;

public class ServerStartTest {
    public static void main(String[] args) {
        ServiceExposure.register(new MsgServiceDemoImpl());
        ServerRemotingInit.start("127.0.0.1", 9095);
    }
}

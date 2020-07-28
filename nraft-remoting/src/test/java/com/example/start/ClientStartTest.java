package com.example.start;

import com.example.server.MsgServiceDemo;
import com.example.server.SendResponse;
import com.nucc.raft.remoting.RemotingClientFactory;


public class ClientStartTest {
    public static void main(String[] args) {
        MsgServiceDemo msgServiceDemo = RemotingClientFactory.clientProxy("127.0.0.1", 9095).create(MsgServiceDemo.class);
        SendResponse value = msgServiceDemo.send("nucc.send", 18);
        System.out.println("value is from server:" + value);

        String ret = msgServiceDemo.sendDto("nucc.senddto", 123);
        System.out.println("ret is from server:" + ret);

    }
}

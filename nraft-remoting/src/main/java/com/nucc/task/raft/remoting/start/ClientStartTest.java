package com.nucc.task.raft.remoting.start;

import com.nucc.task.raft.remoting.demo.MsgServiceDemo;
import com.nucc.task.raft.remoting.demo.SendResponse;
import com.nucc.task.raft.remoting.rpc.CommunicateServer;

public class ClientStartTest {
    public static void main(String[] args) {
        MsgServiceDemo msgServiceDemo = new CommunicateServer("127.0.0.1", 9095).create(MsgServiceDemo.class);
        SendResponse value = msgServiceDemo.send("nucc.send", 18);
        System.out.println("value is from server:" + value);

        String ret = msgServiceDemo.sendDto("nucc.senddto", 123);
        System.out.println("ret is from server:" + ret);

    }
}

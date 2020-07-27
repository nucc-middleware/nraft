package com.nucc.task.raft.remoting.demo;


import com.nucc.task.raft.remoting.rpc.annotations.ServiceName;

@ServiceName(name = "msgServiceDemo")
public interface MsgServiceDemo {

    SendResponse send(String name, int age);

    String sendDto(String name, int age);
}

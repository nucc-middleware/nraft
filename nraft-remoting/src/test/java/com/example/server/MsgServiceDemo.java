package com.example.server;


import com.nucc.raft.annotations.RpcService;

@RpcService(name = "msgServiceDemo")
public interface MsgServiceDemo {

    SendResponse send(String name, int age);

    String sendDto(String name, int age);
}

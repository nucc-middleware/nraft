package com.example.server;


import com.nucc.raft.annotations.ServiceName;

@ServiceName(name = "msgServiceDemo")
public interface MsgServiceDemo {

    SendResponse send(String name, int age);

    String sendDto(String name, int age);
}

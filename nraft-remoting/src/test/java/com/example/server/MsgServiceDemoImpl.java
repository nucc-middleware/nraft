package com.example.server;


import com.nucc.raft.annotations.ServiceName;

/**
 * 暂不支持传参是对象的调用方式
 */
@ServiceName(name = "msgServiceDemo")
public class MsgServiceDemoImpl implements MsgServiceDemo {

    public SendResponse send(String name, int age) {
        System.out.println("server get msg from client:" + "name = " + name + ", age = " + age);
        SendResponse sendResponse = new SendResponse();
        sendResponse.setName(name + "123");
        sendResponse.setTrue(true);
        return sendResponse;
    }

    public String sendDto(String name, int age) {
        System.out.println("name = " + name + ", age = " + age);
        return name + "-" + age + ":from client";
    }


}

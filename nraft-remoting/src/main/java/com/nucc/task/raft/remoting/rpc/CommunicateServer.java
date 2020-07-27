package com.nucc.task.raft.remoting.rpc;


import com.alibaba.fastjson.JSON;
import com.nucc.task.raft.remoting.netty.client.ClientSendMessage;
import com.nucc.task.raft.remoting.rpc.annotations.ServiceName;
import com.nucc.task.raft.remoting.rpc.dto.RequestCommon;
import com.nucc.task.raft.remoting.utils.UUIDUtils;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * 创建代理,没有注册中心，需要指定对应的ip和端口
 */
public class CommunicateServer implements InvocationHandler {

    private String ip;
    private int port;

    public CommunicateServer(String ip, int port) {
        this.ip = ip;
        this.port = port;
    }

    public <T> T create(final Class<?> interfaceClass) {
        return (T) Proxy.newProxyInstance(interfaceClass.getClassLoader()
                , new Class<?>[]{interfaceClass}, this);
    }

    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        if (method.getDeclaringClass().getAnnotation(ServiceName.class) == null) {
            throw new RuntimeException("ServiceName is null");
        }
        RequestCommon requestCommon = new RequestCommon();
        requestCommon.setRequesetId(UUIDUtils.getUUID());
        requestCommon.setMethodName(method.getName());
        requestCommon.setServiceName(method.getDeclaringClass().getAnnotation(ServiceName.class).name());
        requestCommon.setParameterTypes(method.getParameterTypes());
        requestCommon.setParameters(args);
        ClientSendMessage.sendMessage(ip, port, requestCommon);
        MessageStore.map.put(requestCommon.getRequesetId(), requestCommon);
        synchronized (requestCommon) {
            requestCommon.wait();
        }
        MessageStore.map.remove(requestCommon.getRequesetId());

        if (method.getReturnType().equals(String.class)) {
            return requestCommon.getResult();
        }
        Object object = JSON.parseObject(requestCommon.getResult().toString(), method.getReturnType());
        return object;
    }
}

package com.nucc.raft.remoting.rpc;


import com.alibaba.fastjson.JSON;
import com.nucc.raft.annotations.RpcService;
import com.nucc.raft.remoting.netty.client.ClientSendMessage;
import com.nucc.raft.remoting.rpc.dto.RequestCommon;
import com.nucc.raft.utils.UUIDUtils;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * Object object = new ClientProxy(ip,port).create(class);
 * <p>
 * 创建代理,没有注册中心，需要指定对应的ip和端口
 */
public class ClientProxy implements InvocationHandler {

    private String ip;
    private int port;

    public ClientProxy(String ip, int port) {
        this.ip = ip;
        this.port = port;
    }

    public <T> T create(final Class<?> interfaceClass) {
        return (T) Proxy.newProxyInstance(interfaceClass.getClassLoader()
                , new Class<?>[]{interfaceClass}, this);
    }

    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        if (method.getDeclaringClass().getAnnotation(RpcService.class) == null) {
            throw new RuntimeException("ServiceName is null");
        }
        RequestCommon requestCommon = new RequestCommon();
        requestCommon.setRequesetId(UUIDUtils.getUUID());
        requestCommon.setMethodName(method.getName());
        requestCommon.setServiceName(method.getDeclaringClass().getAnnotation(RpcService.class).name());
        requestCommon.setParameterTypes(method.getParameterTypes());
        requestCommon.setParameters(args);
        ClientSendMessage.sendMessage(ip, port, requestCommon);
        MessageStore.map.put(requestCommon.getRequesetId(), requestCommon);
        synchronized (requestCommon) {
            requestCommon.wait(4000L);
        }
        MessageStore.map.remove(requestCommon.getRequesetId());

        if (method.getReturnType().equals(String.class)) {
            return requestCommon.getResult();
        }
        Object object = JSON.parseObject(requestCommon.getResult().toString(), method.getReturnType());
        return object;
    }
}

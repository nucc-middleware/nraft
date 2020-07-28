package com.nucc.raft.remoting.rpc;


import com.nucc.raft.annotations.RpcService;

import java.util.HashMap;
import java.util.Map;

/**
 * 服务暴露
 */
public class RemotingServiceExpoter {

    private static final Map<String, Object> handlerMap = new HashMap<String, Object>(20);

    public static void register(Object object) {
        if (object == null) {
            throw new RuntimeException("putServiceName: Object is null");
        }
        RpcService rpcService = object.getClass().getAnnotation(RpcService.class);
        if (rpcService == null) {
            throw new RuntimeException("putServiceName: serviceName is null,please add Annotation");
        }
        handlerMap.put(rpcService.name(), object);
    }

    public static Object getService(String name) {
        return handlerMap.get(name);
    }
}

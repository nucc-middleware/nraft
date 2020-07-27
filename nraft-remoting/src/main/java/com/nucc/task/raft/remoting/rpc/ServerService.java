package com.nucc.task.raft.remoting.rpc;


import com.nucc.task.raft.remoting.demo.MsgServiceDemo;
import com.nucc.task.raft.remoting.demo.MsgServiceDemoImpl;
import com.nucc.task.raft.remoting.rpc.annotations.ServiceName;

import java.util.HashMap;
import java.util.Map;

/**
 * 用来看保存注册的服务的
 */
public class ServerService {

    private static final Map<String, Object> handlerMap = new HashMap<String, Object>(20);

    public static void initService() {
        MsgServiceDemo msgServiceDemo = new MsgServiceDemoImpl();
        ServerService.putServiceName(msgServiceDemo);
    }

    public static void putServiceName(Object object) {
        if (object == null) {
            throw new RuntimeException("putServiceName: Object is null");
        }
        ServiceName serviceName = object.getClass().getAnnotation(ServiceName.class);
        if (serviceName == null) {
            throw new RuntimeException("putServiceName: serviceName is null,please add Annotation");
        }
        handlerMap.put(serviceName.name(), object);
    }


    public static Map<String, Object> getService() {
        return handlerMap;
    }
}

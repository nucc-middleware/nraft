package com.nucc.raft.remoting.rpc;


import com.nucc.raft.annotations.ServiceName;

import java.util.HashMap;
import java.util.Map;

/**
 * 服务暴露
 */
public class ServiceExposure {

    private static final Map<String, Object> handlerMap = new HashMap<String, Object>(20);

    public static void register(Object object) {
        if (object == null) {
            throw new RuntimeException("putServiceName: Object is null");
        }
        ServiceName serviceName = object.getClass().getAnnotation(ServiceName.class);
        if (serviceName == null) {
            throw new RuntimeException("putServiceName: serviceName is null,please add Annotation");
        }
        handlerMap.put(serviceName.name(), object);
    }

    public static Object getService(String name) {
        return handlerMap.get(name);
    }
}

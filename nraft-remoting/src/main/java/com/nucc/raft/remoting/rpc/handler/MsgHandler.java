package com.nucc.raft.remoting.rpc.handler;

import com.nucc.raft.remoting.rpc.RemotingServiceExpoter;
import com.nucc.raft.remoting.rpc.dto.RequestCommon;
import com.nucc.raft.remoting.rpc.dto.ResponseCommon;

import java.lang.reflect.Method;

/**
 * 主要是一个响应处理，最好是把服务暴露出来
 */
public class MsgHandler {

    public static ResponseCommon handler(RequestCommon requestCommon) {
        ResponseCommon responseCommon = new ResponseCommon();
        Object object = RemotingServiceExpoter.getService(requestCommon.getServiceName());
        if (object == null) {
            responseCommon.setException(new RuntimeException("Not Service Found:" + requestCommon.getServiceName()));
            return responseCommon;
        }
        try {
            Class<?> serviceClass = object.getClass();
            Method method = serviceClass.getMethod(requestCommon.getMethodName(), requestCommon.getParameterTypes());
            method.setAccessible(true);
            Object[] parameters = requestCommon.getParameters();
            //这块使用代理应该也能实现的
            responseCommon.setResult(method.invoke(object, parameters));
        } catch (Exception e) {
            System.out.println(e.getMessage());
            responseCommon.setResult(e);
        }
        return responseCommon;
    }
}

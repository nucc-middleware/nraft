package com.nucc.raft.remoting.rpc.dto;

import java.io.Serializable;

public class RequestCommon implements Serializable {

    private static final long serialVersionUID = 1011262369113579541L;

    private String requesetId;

    private String serviceName;

    private String methodName;

    private Class<?>[] parameterTypes;

    private Object[] parameters;

    private Object result;


    public String getRequesetId() {
        return requesetId;
    }

    public void setRequesetId(String requesetId) {
        this.requesetId = requesetId;
    }

    public String getServiceName() {
        return serviceName;
    }

    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }

    public String getMethodName() {
        return methodName;
    }

    public void setMethodName(String methodName) {
        this.methodName = methodName;
    }

    public Class<?>[] getParameterTypes() {
        return parameterTypes;
    }

    public void setParameterTypes(Class<?>[] parameterTypes) {
        this.parameterTypes = parameterTypes;
    }

    public Object getResult() {
        return result;
    }

    public void setResult(Object result) {
        synchronized (this) {
            this.result = result;
            notify();
        }
    }

    public Object[] getParameters() {
        return parameters;
    }

    public void setParameters(Object[] parameters) {
        this.parameters = parameters;
    }

}

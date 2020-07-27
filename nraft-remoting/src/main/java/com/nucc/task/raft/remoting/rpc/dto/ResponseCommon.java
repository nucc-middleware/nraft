package com.nucc.task.raft.remoting.rpc.dto;

import java.io.Serializable;

public class ResponseCommon implements Serializable {

    private static final long serialVersionUID = 3933913171321041804L;

    private String requestId;

    private Exception exception;

    private Object result;


    public String getRequestId() {
        return requestId;
    }

    public void setRequestId(String requestId) {
        this.requestId = requestId;
    }

    public Exception getException() {
        return exception;
    }

    public void setException(Exception exception) {
        this.exception = exception;
    }

    public Object getResult() {
        return result;
    }

    public void setResult(Object result) {
        this.result = result;
    }
}

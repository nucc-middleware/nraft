package com.nucc.task.raft.remoting.demo;

public class SendResponse {

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String name;

    public boolean isTrue() {
        return isTrue;
    }

    public void setTrue(boolean aTrue) {
        isTrue = aTrue;
    }

    public boolean isTrue;

    @Override
    public String toString() {
        return "SendResponse{" +
                "name='" + name + '\'' +
                ", isTrue=" + isTrue +
                '}';
    }
}

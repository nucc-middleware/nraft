package com.nucc.raft.statemachine.api;

import jdk.internal.dynalink.beans.StaticClass;

import java.io.IOException;

public interface IKvStateMachine extends IStateMachine{
    /**
     * 根据key从状态机中获取当前值。
     * @param key key
     * @return 状态机中的当前值
     */
    Object get(String key);
    void start() throws IOException, ClassNotFoundException;
}

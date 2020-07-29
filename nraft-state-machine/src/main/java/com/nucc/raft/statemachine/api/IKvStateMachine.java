package com.nucc.raft.statemachine.api;

public interface IKvStateMachine extends IStateMachine{
    /**
     * 根据key从状态机中获取当前值。
     * @param key key
     * @return 状态机中的当前值
     */
    Object get(String key);
}

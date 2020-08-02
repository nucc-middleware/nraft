package com.nucc.raft.statemachine;

import com.nucc.raft.statemachine.api.IKvStateMachine;
import com.nucc.raft.statemachine.core.KVStateMachine;

import java.io.IOException;


/**
 * 状态机。
 *
 * <code>
 * LogEntry logEntry = new LogEntry(1,1,"Tom","A");
 *         LogEntry logEntry1 = new LogEntry(2,3,"Tom");
 *
 *         StateMachineFactory.getInstance().apply(logEntry);
 *         StateMachineFactory.getInstance().apply(logEntry1);
 *</code>
 */
public class StateMachineFactory {

    private static final IKvStateMachine instance = new KVStateMachine();

    public static IKvStateMachine getInstance(){
        return instance;
    }
}

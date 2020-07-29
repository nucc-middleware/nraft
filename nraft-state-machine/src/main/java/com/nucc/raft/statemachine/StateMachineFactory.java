package com.nucc.raft.statemachine;

import com.nucc.raft.statemachine.api.IKvStateMachine;
import com.nucc.raft.statemachine.core.StateMachine;


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

    private static final IKvStateMachine instance = new StateMachine();

    public static IKvStateMachine getInstance(){
        return instance;
    }
}

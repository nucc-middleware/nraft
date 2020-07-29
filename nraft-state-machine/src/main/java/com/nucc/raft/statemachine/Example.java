package com.nucc.raft.statemachine;

import com.nucc.raft.domain.LogEntry;
import com.nucc.raft.statemachine.core.StateMachine;

/**
 * @description:
 * @author: huzhiqi
 * @email: huzhiqi@nucc.com
 * @datetime: 2020/7/28-11:44
 * @version: 1.0.0
 */
public class Example {
    public static void main(String[] args){
        LogEntry logEntry = new LogEntry(1,1,"set Tom A");
        LogEntry logEntry1 = new LogEntry(2,3,"del Tom");

        StateMachineFactory.getInstance().apply(logEntry);
        StateMachineFactory.getInstance().apply(logEntry1);
    }
}

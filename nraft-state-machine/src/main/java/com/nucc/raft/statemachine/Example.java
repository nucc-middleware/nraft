package com.nucc.raft.statemachine;

import com.nucc.raft.statemachine.domain.LogEntry;
import com.nucc.raft.statemachine.api.IKvStateMachine;
import com.nucc.raft.statemachine.domain.LogEntryDataKvImpl;

import java.io.IOException;

/**
 * @description:
 * @author: huzhiqi
 * @email: huzhiqi@nucc.com
 * @datetime: 2020/7/28-11:44
 * @version: 1.0.0
 */
public class Example {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        LogEntry logEntry = new LogEntryDataKvImpl("set Tom A");
        LogEntry logEntry1 = new LogEntryDataKvImpl("get Tom");
        LogEntry logEntry2 = new LogEntryDataKvImpl("del Tom");

        IKvStateMachine kvStateMachine = StateMachineFactory.getInstance();
        kvStateMachine.start();
        kvStateMachine.apply(logEntry);
        kvStateMachine.apply(logEntry1);
        kvStateMachine.apply(logEntry2);
        kvStateMachine.apply(logEntry1);
    }
}

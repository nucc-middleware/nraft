package com.nucc.raft.statemachine;

/**
 * @description:
 * @author: huzhiqi
 * @email: huzhiqi@nucc.com
 * @datetime: 2020/7/28-11:44
 * @version: 1.0.0
 */
public class Example {
    public static void main(String[] args){
        LogEntry logEntry = new LogEntry(1,1,"Tom","A");
        LogEntry logEntry1 = new LogEntry(2,3,"Tom");
        StateMachine statemachine = new StateMachine();
        statemachine.apply(logEntry);
        statemachine.apply(logEntry1);
    }
}

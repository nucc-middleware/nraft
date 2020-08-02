package com.nucc.raft.statemachine.domain;

/**
 * @description:
 * @author: huzhiqi
 * @email: huzhiqi@nucc.com
 * @datetime: 2020/7/30-21:55
 * @version: 1.0.0
 */
public abstract class LogEntry {
    public LogEntry(){}
    public LogEntry(String content){
        this.content = content;
    }
    public String getContent(){
        return content;
    }

    protected abstract void parseCommand(String command);
    // 命令内容
    private String content;
}

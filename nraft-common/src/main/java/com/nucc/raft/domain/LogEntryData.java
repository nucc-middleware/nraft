package com.nucc.raft.domain;

public class LogEntryData {

    protected final String content;

    public LogEntryData(String content){
        this.content = content;
    }

    public String getContent() {
        return content;
    }
}

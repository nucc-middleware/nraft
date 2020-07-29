package com.nucc.raft.domain;

import jdk.internal.util.Preconditions;

/**
 * @description:
 * @author: huzhiqi
 * @email: huzhiqi@nucc.com
 * @datetime: 2020/7/28-11:48
 * @version: 1.0.0
 */
public class LogEntry {

    private final long term;
    private final long index;
    private final LogEntryData data;

    public LogEntry(long term, long index, String data){
        this.term = term;
        this.index = index;
        this.data = new LogEntryData(data);
    }

    public LogEntry(long term, long index, LogEntryData data){
        this.term = term;
        this.index = index;
        this.data = data;
    }

    public long getTerm() {
        return term;
    }

    public long getIndex() {
        return index;
    }

    public LogEntryData getData() {
        return data;
    }
}

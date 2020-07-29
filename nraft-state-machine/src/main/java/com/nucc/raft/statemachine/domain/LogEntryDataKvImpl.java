package com.nucc.raft.statemachine.domain;

import com.nucc.raft.domain.LogEntryData;

public class LogEntryDataKvImpl extends LogEntryData {

    private KvCommandType commandType;
    private String key;
    private String value;

    public LogEntryDataKvImpl(LogEntryData logEntryData) {
        super(logEntryData.getContent());
        this.parseCommand(super.content);
    }

    public LogEntryDataKvImpl(String content) {
        super(content);
        this.parseCommand(super.content);
    }

    /**
     *
     * @param command 命令，形如： set key 10 或 get key  或  del key
     */
    private void parseCommand(String command){
        // TODO 解析命令
    }

    public KvCommandType getCommandType() {
        return commandType;
    }

    public String getKey() {
        return key;
    }

    public String getValue() {
        return value;
    }
}

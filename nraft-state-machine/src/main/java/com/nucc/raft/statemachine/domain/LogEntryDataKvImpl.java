package com.nucc.raft.statemachine.domain;

import com.nucc.raft.statemachine.domain.LogEntry;

import java.util.List;

public class LogEntryDataKvImpl extends LogEntry {

    private KvCommandType commandType;
    private String key;
    private String value;

    public LogEntryDataKvImpl(LogEntry logEntry) {
        super(logEntry.getContent());
        this.parseCommand(logEntry.getContent());
    }

    public LogEntryDataKvImpl(String content) {
        super(content);
        this.parseCommand(content);
    }

    /**
     *
     * @param command 命令，形如： set key 10 或 get key  或  del key
     */
    protected void parseCommand(String command){
        // TODO 解析命令
        String[] commandSplit = command.split(" ");
        if(commandSplit[0].equals("set")){
            commandType = KvCommandType.SET;
            key = commandSplit[1];
            value = commandSplit[2];
        } else if(commandSplit[0].equals("get")){
            commandType = KvCommandType.GET;
            key = commandSplit[1];
            value = null;
        } else {
            commandType = KvCommandType.DEL;
            key = commandSplit[1];
            value = null;
        }
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

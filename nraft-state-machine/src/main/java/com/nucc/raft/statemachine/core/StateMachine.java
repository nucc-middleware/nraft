package com.nucc.raft.statemachine.core;

import com.nucc.raft.domain.LogEntry;
import com.nucc.raft.statemachine.api.IKvStateMachine;
import com.nucc.raft.statemachine.api.IKvStorage;
import com.nucc.raft.statemachine.domain.KvCommandType;
import com.nucc.raft.statemachine.domain.LogEntryDataKvImpl;

import java.util.HashMap;
import java.util.Map;
// import com.nucc.task.raft.logEntry;
/**
 * @description:状态机
 * @author: huzhiqi
 * @email: huzhiqi@nucc.com
 * @datetime: 2020/7/27-20:28
 * @version: 1.0.0
 */
public class StateMachine implements IKvStateMachine {

    private IKvStorage storage;

    public StateMachine() {
        this.storage = new KvStorage();
        this.storage.load();
    }

    public void apply(LogEntry logEntry){
        LogEntryDataKvImpl command = new LogEntryDataKvImpl(logEntry.getData());
        KvCommandType commandType = command.getCommandType();
        // TODO  这里要根据不同的命令类型做不同处理

        String key = command.getKey();
        String value = command.getValue();
        if(value != null){
            storage.set(key,value);
        } else {
            System.out.println("key:"+key+"  value:" + storage.get(key));
        }
    }

    public Object get(String key) {
        // TODO implements this method
        return null;
    }
}

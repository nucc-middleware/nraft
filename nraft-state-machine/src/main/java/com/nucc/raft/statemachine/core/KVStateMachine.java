package com.nucc.raft.statemachine.core;

import com.nucc.raft.statemachine.api.IKvStateMachine;
import com.nucc.raft.statemachine.domain.KvCommandType;
import com.nucc.raft.statemachine.domain.LogEntry;
import com.nucc.raft.statemachine.domain.LogEntryDataKvImpl;

import javax.sound.midi.Soundbank;
import java.io.IOException;
// import com.nucc.task.raft.logEntry;
/**
 * @description:状态机
 * @author: huzhiqi
 * @email: huzhiqi@nucc.com
 * @datetime: 2020/7/27-20:28
 * @version: 1.0.0
 */
public class KVStateMachine implements IKvStateMachine {

    private KvStorage storage;

    public KVStateMachine() {
        this.storage = new KvStorage();
    }
    public void start() throws IOException, ClassNotFoundException {
        storage.load();
    }

    public void apply(LogEntry logEntry) throws IOException {
        LogEntryDataKvImpl logEntryDataKv = new LogEntryDataKvImpl(logEntry.getContent());
        String key = logEntryDataKv.getKey();
        KvCommandType commandType = logEntryDataKv.getCommandType();
        // TODO  这里要根据不同的命令类型做不同处理

        switch(commandType){
            case SET:
                String value = logEntryDataKv.getValue();
                storage.set(key,value);
                break;
            case GET:
                if(storage.get(key) != null) {
                    System.out.println(storage.get(key));
                } else {
                    System.out.println(key + " not found");
                }
                break;
            case DEL:
                storage.del(key);
                break;
            default:
                System.out.println("the command type is incorrect");
        }
    }

    public Object get(String key) {
        // TODO implements this method
        return null;
    }
}

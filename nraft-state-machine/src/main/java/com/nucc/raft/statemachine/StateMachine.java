package com.nucc.raft.statemachine;

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
public class StateMachine {
    public StateMachine() {
        this.storage = new HashMap<>();
    }

    public void apply(LogEntry logEntry){
        LogEntry.Data data = logEntry.getData();
        String key = data.getKey();
        String value = data.getValue();
        if(value != null){
            storage.put(key,value);
        } else {
            System.out.println("key:"+key+"  value:" + storage.get(key));
        }
    }

    private  Map<String, String> storage;
}

package com.nucc.task.raft.remoting.rpc;

import com.nucc.task.raft.remoting.rpc.dto.RequestCommon;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class MessageStore {

    public static Map<String, RequestCommon> map = new ConcurrentHashMap<String, RequestCommon>(100);
}

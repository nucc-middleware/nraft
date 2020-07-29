package com.nucc.raft.statemachine.core;

import com.nucc.raft.statemachine.api.IKvStorage;

import java.util.Map;

/**
 * TODO 所有操作持久化之后才可返回。
 */
public class KvStorage implements IKvStorage {

    private Map<String, String> data;

    public void load() {

    }

    public void set(String key, String value) {

    }

    public String get(String key) {
        return null;
    }

    public String del(String key) {
        return null;
    }

    public void close() {

    }
}

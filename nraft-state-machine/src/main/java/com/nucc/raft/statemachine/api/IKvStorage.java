package com.nucc.raft.statemachine.api;

public interface IKvStorage {
    /**
     * 系统启动时，从持久化磁盘加载
     */
    void load();

    void set(String key, String value);

    String get(String key);

    /**
     *
     * @param key key
     * @return 对应的value
     */
    String del(String key);

    void close();
}

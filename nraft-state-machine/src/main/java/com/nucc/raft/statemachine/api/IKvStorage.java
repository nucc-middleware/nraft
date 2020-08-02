package com.nucc.raft.statemachine.api;

import java.io.FileNotFoundException;
import java.io.IOException;

public interface IKvStorage {
    /**
     * 系统启动时，从持久化磁盘加载
     */
    void load() throws IOException, ClassNotFoundException;

    void set(String key, String value) throws IOException;

    String get(String key);

    /**
     *
     * @param key key
     * @return 对应的value
     */
    String del(String key) throws IOException;

    void close();
}

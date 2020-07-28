package com.nucc.raft.statemachine;

/**
 * @description:
 * @author: huzhiqi
 * @email: huzhiqi@nucc.com
 * @datetime: 2020/7/28-11:48
 * @version: 1.0.0
 */
public class LogEntry {
    LogEntry(long term, long index, String key, String value){
        this.term = term;
        this.index = index;
        this.data = new Data(key, value);
    }

    LogEntry(long term, long index, String key){
        this.term = term;
        this.index = index;
        this.data = new Data(key, null);
    }
    public Data getData(){
        return data;
    }

    class Data{
        Data(){}

        public Data(String key, String value) {
            this.key = key;
            this.value = value;
        }

        public String getKey() {
            return key;
        }

        public String getValue() {
            return value;
        }

        public void setKey(String key) {
            this.key = key;
        }

        public void setValue(String value) {
            this.value = value;
        }

        private String key;
        private String value;
    }
    private long term;
    private long index;
    private Data data;
}

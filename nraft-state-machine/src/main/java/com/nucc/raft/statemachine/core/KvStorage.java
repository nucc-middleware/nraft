package com.nucc.raft.statemachine.core;

import com.nucc.raft.statemachine.api.IKvStorage;
import com.nucc.raft.statemachine.domain.LogEntry;
import com.nucc.raft.statemachine.domain.LogEntryDataKvImpl;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * TODO 所有操作持久化之后才可返回。
 */
public class KvStorage implements IKvStorage {

    private Map<String, String> data;
    private List<LogEntry> logEntries;
    // 如果删除了true,没有删除false
    // private Map<String, Boolean> isOnMap;
    private final String filePath="D:\\stateMachine.txt";

    KvStorage(){
        data = new HashMap<>();
        logEntries = new ArrayList<>();
    }

    public void load() throws IOException, ClassNotFoundException {
        File file=new File(filePath);
        if(!file.exists())
        {
            try {
                file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return;
        }

        FileReader fr=new FileReader(filePath);
        BufferedReader br=new BufferedReader(fr);
        String line="";
        String[] commandSplit=null;
        while ((line=br.readLine())!=null) {
            logEntries.add(new LogEntryDataKvImpl(line));
            commandSplit = line.split(" ");
            if(commandSplit[0].equals("set")){
                data.put(commandSplit[1],commandSplit[2]);
                // isOnMap.put(commandSplit[1],true);
            } else if(commandSplit[0].equals("del")){
                data.remove(commandSplit[1]);
                // isOnMap.put(commandSplit[1],false);
            } else {
                /* if(isOnMap.get(commandSplit[1]) == true){
                    System.out.println(data.get(commandSplit[1]));
                }*/
            }
        }
        br.close();
        fr.close();
    }

    long getLastApplied(){
        return logEntries.size()-1;
    }

    // TODO 每次set都写文件效率比较低，但是不每次写，就可能宕机丢失，后续考虑异步持久化提升效率
    public void set(String key, String value) throws IOException {
        data.put(key,value);
        StringBuilder sb = new StringBuilder();
        sb.append("set ").append(key).append(" ").append(value);
        appendWriteFile(filePath, sb.toString());
    }

    public String get(String key) {
        return data.get(key);
    }

    public String del(String key) throws IOException {
        String value = data.get(key);
        data.remove(key);
        StringBuilder sb = new StringBuilder();
        sb.append("del ").append("key");
        appendWriteFile(filePath, sb.toString());
        return value;
    }

    public void close() {

    }

    public static void appendWriteFile(String fileFullPath,String content) {
        FileOutputStream fos = null;
        try {
            //true不覆盖已有内容
            fos = new FileOutputStream(fileFullPath, true);
            //写入
            fos.write(content.getBytes());
            // 写入一个换行
            fos.write("\r\n".getBytes());

        } catch (IOException e) {
            e.printStackTrace();
        }finally{
            if(fos != null){
                try {
                    fos.flush();
                    fos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}

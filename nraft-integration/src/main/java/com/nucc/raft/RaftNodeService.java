package com.nucc.raft;

import com.nucc.raft.remoting.ServerRemotingInit;

public class RaftNodeService {

    /**
     * 系统启动入口
     */
    public static void start() {
        //1.注入服务，可通过配置文件实现
        //
        //2.启动通讯
        ServerRemotingInit.start("127.0.0.1", 9095);
    }


//    /**
//     * 系统启动入口
//     */
//    public static void  start() {
//        // 扫描标注，加载类实例
//        // 创建系统类实例
//        erviceFactory.regsit("name", "");
//        //启动远程监听
//        //IP，PORT取自配置文件
//        ServerRemotingInit.start("127.0.0.1", 9095);
//
//        StartClientServ();
//    }
//
//    public void (){
//        String command  = "set x 16";
//        electionService erviceFactory.getBean("electionService");
//        Leader leader = electionService.leader():
//        if(leader==null){
//            return "xx";
//        }
//
//        if(!leader.isMe()){
//            return "leader is ";
//        }
//
//        logService = erviceFactory.getBean("logService");
//        logService.appeneLogEntry(command);
//
//        get
//
//    }
}

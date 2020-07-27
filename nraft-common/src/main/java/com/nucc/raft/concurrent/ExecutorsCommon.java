package com.nucc.raft.concurrent;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class ExecutorsCommon {
    public static ExecutorService nettyExecutorService = new ThreadPoolExecutor(5, 20,
            2L, TimeUnit.SECONDS, new ArrayBlockingQueue<Runnable>(100));
}

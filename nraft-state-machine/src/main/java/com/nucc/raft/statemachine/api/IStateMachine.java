package com.nucc.raft.statemachine.api;


import com.nucc.raft.statemachine.domain.LogEntry;

import java.io.IOException;

public interface IStateMachine {

    void apply(LogEntry logEntry) throws IOException;
    void start() throws IOException, ClassNotFoundException;
}

package com.nucc.raft.statemachine.api;

import com.nucc.raft.domain.LogEntry;

public interface IStateMachine {

    void apply(LogEntry logEntry);
}

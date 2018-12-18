package com.example;

public class ReceiveMonitor extends StateMmonitorTemplate {
    @Override
    public ProcessState getRunningState() {
        return null;
    }

    @Override
    protected boolean checkIfError(ProcessState oldPs, ProcessState newPs) {
        return false;
    }

    @Override
    protected boolean checkIfDead(ProcessState oldPs, ProcessState newPs) {
        return false;
    }
}

package com.example.domain;

import com.thoughtworks.xstream.annotations.XStreamAlias;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
@XStreamAlias("program")
public class Program {
    private String ip;
    private String user;
    private String psword;
    private String province;
    private List<Soft_Process> processes ;
    private MsgQueue msgqueue;

    public Program(String ip, String user, String psword, String province, List<Soft_Process> processes, MsgQueue msgqueue) {
        this.ip = ip;
        this.user = user;
        this.psword = psword;
        this.province = province;
        this.processes = processes;
        this.msgqueue = msgqueue;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPsword() {
        return psword;
    }

    public void setPsword(String psword) {
        this.psword = psword;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public List<Soft_Process> getProcesses() {
        return processes;
    }

    public void setProcesses(List<Soft_Process> processes) {
        this.processes = processes;
    }

    public MsgQueue getMsgqueue() {
        return msgqueue;
    }

    public void setMsgqueue(MsgQueue msgqueue) {
        this.msgqueue = msgqueue;
    }

    @Override
    public String toString() {
        return "Program{" +
                "ip='" + ip + '\'' +
                ", user='" + user + '\'' +
                ", psword='" + psword + '\'' +
                ", province='" + province + '\'' +
                ", processes=" + processes +
                ", msgqueue=" + msgqueue +
                '}';
    }
}

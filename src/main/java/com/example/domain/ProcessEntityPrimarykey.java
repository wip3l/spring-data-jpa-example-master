package com.example.domain;

import java.io.Serializable;

public class ProcessEntityPrimarykey implements Serializable {
    private static final long serialVersionUID = 1L;

    private String ip;
    private String main;
    private int pid;

    public ProcessEntityPrimarykey(){}

    public ProcessEntityPrimarykey(String ip, String main, int pid) {
        this.ip = ip;
        this.main = main;
        this.pid = pid;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public String getMain() {
        return main;
    }

    public void setMain(String main) {
        this.main = main;
    }

    public int getPid() {
        return pid;
    }

    public void setPid(int pid) {
        this.pid = pid;
    }

    @Override
    public String toString() {
        return "ProcessEntityPrimarykey{" +
                "ip='" + ip + '\'' +
                ", main='" + main + '\'' +
                ", pid='" + pid + '\'' +
                '}';
    }
}

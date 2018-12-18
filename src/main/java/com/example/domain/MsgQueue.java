package com.example.domain;

import com.thoughtworks.xstream.annotations.XStreamAlias;

@XStreamAlias("msgqueue")
public class MsgQueue {
    private String ip;
    private String cmd;
    private String user;
    private String password;

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }



    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public String getCmd() {
        return cmd;
    }

    public void setCmd(String cmd) {
        this.cmd = cmd;
    }

    @Override
    public String toString() {
        return "queue{" +
                "ip='" + ip + '\'' +
                ", cmd='" + cmd + '\'' +
                '}';
    }
}

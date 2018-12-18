package com.example.domain;

import java.io.Serializable;

public class WarnMsgPrimarykey implements Serializable {

        private static final  long serialVersionUID = 1L;
        private String ip;
        private String province;
        private String main;

        public WarnMsgPrimarykey(){}

    public WarnMsgPrimarykey(String ip, String province, String main) {
        this.ip = ip;
        this.province = province;
        this.main = main;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getMain() {
        return main;
    }

    public void setMain(String main) {
        this.main = main;
    }

    @Override
    public String toString() {
        return "WarnMsgPrimarykey{" +
                "ip='" + ip + '\'' +
                ", province='" + province + '\'' +
                ", main='" + main + '\'' +
                '}';
    }
}

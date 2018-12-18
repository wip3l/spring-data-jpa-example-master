package com.example.domain;

import java.io.Serializable;

public class TopicEntityPrimarykey implements Serializable {
    private static final long serialVersionUID = 1L;

    private String ip;
    private String province;
    private String topic_name;

    public TopicEntityPrimarykey(){}

    public TopicEntityPrimarykey(String ip, String province, String topic_name) {
        this.ip = ip;
        this.province = province;
        this.topic_name = topic_name;
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

    public String getTopic_name() {
        return topic_name;
    }

    public void setTopic_name(String topic_name) {
        this.topic_name = topic_name;
    }

    @Override
    public String toString() {
        return "TopicEntityPrimarykey{" +
                "ip='" + ip + '\'' +
                ", province='" + province + '\'' +
                ", topic_name='" + topic_name + '\'' +
                '}';
    }
}

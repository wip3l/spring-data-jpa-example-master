package com.example.domain;

import javax.persistence.*;



@Entity
@Table(name = "topic_entity")
public class TopicEntity  {

    @EmbeddedId
    private TopicEntityPrimarykey TopicEntityPK;


//    @GeneratedValue(strategy = GenerationType.AUTO)
//    private Long id;
//    @Column(name = "ip")
//    private String ip;
//    @Column(name = "province")
//    private String province;
    @Column(name = "user")
    private String user;
    @Column(name = "password")
    private String password;
//    @Column(name = "topic_name")
//    private String topic_name;
    @Column(name = "refresh_time")
    private String refresh_time;
    @Column(name = "realtime_data")
    private String realtime_data;
    @Column(name = "total_data")
    private String total_data;
    @Column(name = "cmd")
    private String cmd;
    @Column(name = "state")
    private String state;
    @Column(name = "topic_log")
    private String topic_log;


    public TopicEntityPrimarykey getTopicEntityPK() {
        return TopicEntityPK;
    }

    public void setTopicEntityPK(TopicEntityPrimarykey topicEntityPK) {
        TopicEntityPK = topicEntityPK;
    }

    public String getTopic_log() {
        return topic_log;
    }

    public void setTopic_log(String topic_log) {
        this.topic_log = topic_log;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

//    public Long getId() {
//        return id;
//    }
//
//    public void setId(Long id) {
//        this.id = id;
//    }

//    public String getIp() {
//        return ip;
//    }
//
//    public void setIp(String ip) {
//        this.ip = ip;
//    }

//    public String getProvince() {
//        return province;
//    }
//
//    public void setProvince(String province) {
//        this.province = province;
//    }

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

//    public String getTopic_name() {
//        return topic_name;
//    }
//
//    public void setTopic_name(String topic_name) {
//        this.topic_name = topic_name;
//    }

    public String getRefresh_time() {
        return refresh_time;
    }

    public void setRefresh_time(String refresh_time) {
        this.refresh_time = refresh_time;
    }

    public String getRealtime_data() {
        return realtime_data;
    }

    public void setRealtime_data(String realtime_data) {
        this.realtime_data = realtime_data;
    }

    public String getTotal_data() {
        return total_data;
    }

    public void setTotal_data(String total_data) {
        this.total_data = total_data;
    }

    public String getCmd() {
        return cmd;
    }

    public void setCmd(String cmd) {
        this.cmd = cmd;
    }


    @Override
    public String toString() {
        return "TopicEntity{" +
                "TopicEntityPK=" + TopicEntityPK +
//                ", id=" + id +
                ", user='" + user + '\'' +
                ", password='" + password + '\'' +
                ", refresh_time='" + refresh_time + '\'' +
                ", realtime_data='" + realtime_data + '\'' +
                ", total_data='" + total_data + '\'' +
                ", cmd='" + cmd + '\'' +
                ", state='" + state + '\'' +
                ", topic_log='" + topic_log + '\'' +
                '}';
    }
}

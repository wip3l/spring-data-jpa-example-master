package com.example.domain;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "warn_msg")
public class WarnMsg  {

    @EmbeddedId
    private WarnMsgPrimarykey warnMsgPrimarykey;
//    @Id
//    @GeneratedValue(strategy = GenerationType.AUTO)
//    private int id;
//    @Column(name = "province")
//    private String province;
//    @Column(name = "ip")
//    private String ip;
//    @Column(name = "main")
//    private String main;
    @Column(name = "msg")
    private String msg;
    @Column(name = "warn_time")
    private Timestamp warn_time;

//    public int getId() {
//        return id;
//    }
//
//    public void setId(int id) {
//        this.id = id;
//    }
//
//    public String getProvince() {
//        return province;
//    }
//
//    public void setProvince(String province) {
//        this.province = province;
//    }
//
//    public String getIp() {
//        return ip;
//    }
//
//    public void setIp(String ip) {
//        this.ip = ip;
//    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Timestamp getWarn_time() {
        return warn_time;
    }

    public void setWarn_time(Timestamp warn_time) {
        this.warn_time = warn_time;
    }

    public WarnMsgPrimarykey getWarnMsgPrimarykey() {
        return warnMsgPrimarykey;
    }

    public void setWarnMsgPrimarykey(WarnMsgPrimarykey warnMsgPrimarykey) {
        this.warnMsgPrimarykey = warnMsgPrimarykey;
    }


    //    public String getMain() {
//        return main;
//    }
//
//    public void setMain(String main) {
//        this.main = main;
//    }


    @Override
    public String toString() {
        return "WarnMsg{" +
                "warnMsgPrimarykey=" + warnMsgPrimarykey +
                ", msg='" + msg + '\'' +
                ", warn_time=" + warn_time +
                '}';
    }
}

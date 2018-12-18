package com.example.domain;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "process_entity")
public class ProcessEntity implements Serializable {
    //    private long id;
    private static final long serialVersionUID = 1L;

    @EmbeddedId
    private ProcessEntityPrimarykey processEntityPK;
    @Column(name = "province")
    private String province;
    @Column(name = "type")
    private String type;
    @Column(name = "run_dir")
    private String run_dir;
    @Column(name = "log_file")
    private String log_file;
    @Column(name = "dead_rule")
    private String dead_rule;
    @Column(name = "kill_cmd")
    private String kill_cmd;
    @Column(name = "restart_cmd")
    private String restart_cmd;
    @Column(name = "user")
    private String user;
    @Column(name = "psword")
    private String psword;
    @Column(name = "run_state")
    private String run_state;
    @Column(name = "time_state")
    private String time_state;

    public ProcessEntityPrimarykey getProcessEntityPK() {
        return processEntityPK;
    }

    public void setProcessEntityPK(ProcessEntityPrimarykey processEntityPK) {
        this.processEntityPK = processEntityPK;
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

    public String getRun_state() {
        return run_state;
    }

    public void setRun_state(String run_state) {
        this.run_state = run_state;
    }

    public String getTime_state() {
        return time_state;
    }

    public void setTime_state(String time_state) {
        this.time_state = time_state;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getRun_dir() {
        return run_dir;
    }

    public void setRun_dir(String run_dir) {
        this.run_dir = run_dir;
    }

    public String getLog_file() {
        return log_file;
    }

    public void setLog_file(String log_file) {
        this.log_file = log_file;
    }

    public String getDead_rule() {
        return dead_rule;
    }

    public void setDead_rule(String dead_rule) {
        this.dead_rule = dead_rule;
    }

    public String getKill_cmd() {
        return kill_cmd;
    }

    public void setKill_cmd(String kill_cmd) {
        this.kill_cmd = kill_cmd;
    }

    public String getRestart_cmd() {
        return restart_cmd;
    }

    public void setRestart_cmd(String restart_cmd) {
        this.restart_cmd = restart_cmd;
    }

    @Override
    public String toString() {
        return "Soft_Process{" +
//                "main='" + main + '\'' +
                ", type='" + type + '\'' +
                ", run_dir='" + run_dir + '\'' +
                ", log_file='" + log_file + '\'' +
                ", dead_rule='" + dead_rule + '\'' +
                ", kill_cmd='" + kill_cmd + '\'' +
                ", restart_cmd='" + restart_cmd + '\'' +
                '}';
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }


}

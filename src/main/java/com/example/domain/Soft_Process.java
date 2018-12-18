package com.example.domain;

import com.thoughtworks.xstream.annotations.XStreamAlias;


@XStreamAlias("soft_Process")
public class Soft_Process {

//    private long id;
    private int pid;
    private String main;
    private String type;
    private String run_dir;
    private String log_file;
    private String dead_rule;
    private String kill_cmd;
    private String restart_cmd;
    private String run_state;
    private String time_state;

    public int getPid() {
        return pid;
    }

    public void setPid(int pid) {
        this.pid = pid;
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


//    private String state;
//
//    public String getState() {
//        return state;
//    }
//
//    public void setState(String state) {
//        this.state = state;
//    }

    public Soft_Process(int pid,String main, String type, String run_dir, String log_file, String dead_rule, String kill_cmd, String restart_cmd,String run_state,String time_state) {
        this.pid = pid;
        this.main = main;
        this.type = type;
        this.run_dir = run_dir;
        this.log_file = log_file;
        this.dead_rule = dead_rule;
        this.kill_cmd = kill_cmd;
        this.restart_cmd = restart_cmd;
        this.run_state = run_state;
        this.time_state = time_state;
    }

    public String getMain() {
        return main;
    }

    public void setMain(String main) {
        this.main = main;
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
                "pid='" + pid + '\'' +
                "main='" + main + '\'' +
                ", type='" + type + '\'' +
                ", run_dir='" + run_dir + '\'' +
                ", log_file='" + log_file + '\'' +
                ", dead_rule='" + dead_rule + '\'' +
                ", kill_cmd='" + kill_cmd + '\'' +
                ", restart_cmd='" + restart_cmd + '\'' +
                ", run_state='" + run_state + '\'' +
                ", time_state='" + time_state + '\'' +
                '}';
    }
}

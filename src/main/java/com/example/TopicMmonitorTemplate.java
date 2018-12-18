package com.example;

import com.example.domain.ProcessEntity;
import com.example.domain.TopicEntity;
import com.example.domain.WarnMsg;
import com.example.service.IProcessService;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public abstract class TopicMmonitorTemplate extends Thread {
    protected  boolean killed = false;
    protected  RmtShellExecutor rse = null;
    protected  TopicEntity topicEntity;
    protected  WarnMsg warnMsg = new WarnMsg();
    public static IProcessService ips;


    public void init(TopicEntity pe){
        //todo
        this.topicEntity = pe;
        rse = new RmtShellExecutor(pe.getTopicEntityPK().getIp(),pe.getUser(),pe.getPassword());
    }



    public void run(){

        while(!killed){
                ProcessState newPs = getRunningState();
            try {
                Thread.sleep(180000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public abstract ProcessState getRunningState();

    protected abstract boolean checkIfError(ProcessState oldPs, ProcessState newPs);

    protected abstract boolean checkIfDead(ProcessState oldPs, ProcessState newPs);
    
    
}

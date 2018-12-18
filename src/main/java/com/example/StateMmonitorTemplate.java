package com.example;

import com.example.domain.ProcessEntity;
import com.example.domain.WarnMsg;
import com.example.domain.WarnMsgPrimarykey;
import com.example.service.IProcessService;


import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public abstract class StateMmonitorTemplate extends Thread {
    protected  boolean killed = false;
    protected  RmtShellExecutor rse = null;
    protected  ProcessEntity processEntity;
    protected  WarnMsg warnMsg = new WarnMsg();
    protected WarnMsgPrimarykey warnMsgPrimarykey = new WarnMsgPrimarykey();
    public static IProcessService ips;
//    protected Logger log = Logger.getLogger(StateMmonitorTemplate.class);

    public void init(ProcessEntity pe){
        //todo
        this.processEntity = pe;
        rse = new RmtShellExecutor(pe.getProcessEntityPK().getIp(),pe.getUser(),pe.getPsword());
    }



    public void run(){
        while(!killed){
            try {
                ProcessState newPs = getRunningState();
                Date now = new Date();
                SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//日期格式
                String time_now = dateFormat.format( now );
                Timestamp timestamp = new Timestamp(dateFormat.parse(time_now).getTime());

//                System.out.println("ProcessState runState = "+newPs.getRunState());
//                System.out.println("-----"+processEntity.getRun_state()==null);
                if(processEntity.getRun_state()=="Stop")
                {
                    processEntity.setTime_state(time_now);
                    ips.addProcess(processEntity);
                }
                else {
                    if(newPs.getRunState()=="Error"){
                        processEntity.setRun_state("Error");
                        processEntity.setTime_state(time_now);
                        ips.addProcess(processEntity);
                        warnMsgPrimarykey.setIp(processEntity.getProcessEntityPK().getIp());
                        warnMsgPrimarykey.setProvince(processEntity.getProvince());
                        warnMsgPrimarykey.setMain(processEntity.getProcessEntityPK().getMain());
                        warnMsg.setWarnMsgPrimarykey(warnMsgPrimarykey);
                        warnMsg.setWarn_time(timestamp);
                        warnMsg.setMsg(processEntity.getProcessEntityPK().getMain()+"日志有误");
                        ips.addWarnMsg(warnMsg);

                    }
                    if(newPs.getRunState()=="Normal"){
                        processEntity.setRun_state("Normal");
                        processEntity.setTime_state(time_now);
                        ips.addProcess(processEntity);
                    }

                }

            } catch (ParseException e) {
                e.printStackTrace();
//                log.info(e);
            }

//            if(checkIfDead(oldPs,newPs)){
//                //todo
//                //write process dead info into mysql
//                processEntity.setRun_state("Dead");
//                processEntity.setTime_state(time_now);
//                ips.findByNameById(processEntity);
//
//            }
//            if(checkIfError(oldPs,newPs)){
//                //todo
//                processEntity.setRun_state("Error");
//                processEntity.setTime_state(time_now);
//                ips.addProcess(processEntity);
//                //write process error info into mysql
//            }
            try {
                Thread.sleep(60000);
            } catch (InterruptedException e) {
                e.printStackTrace();
//                log.info(e);
            }
        }
    }

    public abstract ProcessState getRunningState();

    protected abstract boolean checkIfError(ProcessState oldPs, ProcessState newPs);

    protected abstract boolean checkIfDead(ProcessState oldPs, ProcessState newPs);
    
    
}

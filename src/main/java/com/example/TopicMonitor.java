package com.example;

import com.example.domain.TopicEntity;
import com.example.domain.TopicEntityPrimarykey;
import com.example.domain.WarnMsg;
import com.example.domain.WarnMsgPrimarykey;


import java.io.BufferedReader;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TopicMonitor extends TopicMmonitorTemplate {
    ProcessState processState = new ProcessState();
    protected WarnMsg warnMsg = new WarnMsg();
    protected WarnMsgPrimarykey warnMsgPrimarykey = new WarnMsgPrimarykey();
//    protected Logger log = Logger.getLogger(TopicMonitor.class);
    @Override
    public ProcessState getRunningState() {
        Date logTime = null;
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//日期格式


           //通过读取日志，分析当前Topic状态
        try {
            System.out.println("Topic_IP："+topicEntity.getTopicEntityPK().getIp());
            System.out.println("Topic_cmd："+topicEntity.getCmd());
            String result1 = rse.execmq(topicEntity.getCmd());

            String result = rse.exec("cd /home/swmid/alibaba-rocketmq/bin;cat checkmq.log");
//            String result = rse.exec("");
            //打印字符串String
            System.out.println("TOPICstring:"+result);
            Date now = new Date();
            String time_now = dateFormat.format( now );
            Timestamp timestamp = new Timestamp(dateFormat.parse(time_now).getTime());
            String[] sourceStrArray = result.split("\n");
            for (int i=1;i<sourceStrArray.length;i++){
                System.out.println("sourceStrArray---length:"+sourceStrArray.length);
                String[] str = sourceStrArray[i].split(" ");
                TopicEntity te = new TopicEntity();
                TopicEntityPrimarykey tep = new TopicEntityPrimarykey();
                tep.setProvince(topicEntity.getTopicEntityPK().getProvince());
                tep.setIp(topicEntity.getTopicEntityPK().getIp());
                System.out.println("setTopic_name---:"+str[0]);
                tep.setTopic_name(str[0]);
                te.setTopicEntityPK(tep);
                te.setTotal_data(str[str.length-1]);
                System.out.println("str[str.length-9]:"+str[str.length-9]);
                System.out.println("str[str.length-10]:"+str[str.length-10]);
                te.setRealtime_data(str[str.length-9]);


                if(Integer.valueOf(str[str.length-1].trim())>100000){
                    warnMsgPrimarykey.setIp(topicEntity.getTopicEntityPK().getIp());
                    warnMsgPrimarykey.setProvince(topicEntity.getTopicEntityPK().getProvince());
                    warnMsgPrimarykey.setMain(str[0]);
                    warnMsg.setWarnMsgPrimarykey(warnMsgPrimarykey);
                    warnMsg.setWarn_time(timestamp);
                    warnMsg.setMsg(str[0]+"日志有误");
                    te.setState("Warn");
                    ips.addWarnMsg(warnMsg);

                }
                else{
                    te.setState("Normal");
                }
                te.setCmd(topicEntity.getCmd());
                te.setUser(topicEntity.getUser());
                te.setPassword(topicEntity.getPassword());
                te.setRefresh_time(time_now);
                ips.addTopic(te);

            }
//                System.out.println("Topic第 "+i+"行的数据！"+sourceStrArray[i]);

        } catch (Exception e) {
            e.printStackTrace();
//            log.info(e);
        }
        return processState;
    }

    @Override
    protected boolean checkIfError(ProcessState oldPs, ProcessState newPs) {
        try {

            String result = rse.exec("");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return true;
    }

    @Override
    protected boolean checkIfDead(ProcessState oldPs, ProcessState newPs) {
        try {
//            String result = rse.exec("");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return true;
    }
}

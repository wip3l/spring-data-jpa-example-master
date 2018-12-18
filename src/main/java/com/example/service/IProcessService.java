package com.example.service;

import com.example.domain.ProcessEntity;
import com.example.domain.TopicEntity;
import com.example.domain.User;
import com.example.domain.WarnMsg;
import org.springframework.context.annotation.Bean;

import java.util.List;

public interface IProcessService
{
    public String findByIp(String ip,String main,int pid);

    public void addProcess(ProcessEntity process);

    public void addWarnMsg(WarnMsg warnMsg);

    public void findByNameById(ProcessEntity process);

    public void addTopic(TopicEntity topicEntity);


//    List<ProcessEntity> init() throws Exception ;

}

package com.example.service.impl;

import com.example.domain.ProcessEntity;
import com.example.domain.TopicEntity;
import com.example.domain.WarnMsg;
import com.example.repository.ProcessJpaRepository;
import com.example.repository.ProcessRepository;
import com.example.repository.TopicJpaRepository;
import com.example.repository.WarnMsgJpaRepository;
import com.example.service.IProcessService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Service
@Transactional
public class ProcessServiceImpl implements IProcessService
{

    @Autowired
    private ProcessJpaRepository processJpaRepository;
    @Autowired
    private ProcessRepository processRepository;
    @Autowired
    private WarnMsgJpaRepository warnMsgJpaRepository;
    @Autowired
    private TopicJpaRepository topicJpaRepository;

    public void addWarnMsg(WarnMsg warnMsg){
        warnMsgJpaRepository.save(warnMsg);
    }

    public String findByIp(String ip ,String main ,int pid)
    {
        return processRepository.findByIp(ip,main,pid);
    }

    public void addTopic(TopicEntity topicEntity){

        topicJpaRepository.save(topicEntity);
    }
//    @CachePut(value = "user",key = "#user.id")
    public void addProcess(ProcessEntity process)
    {

        processJpaRepository.save(process);
    }

    public void findByNameById(ProcessEntity process){
        processJpaRepository.updateNameById(process.getProcessEntityPK().getIp(),process.getProcessEntityPK().getMain(),String.valueOf(process.getProcessEntityPK().getPid()),process.getRun_state());

    }
//    public List<ProcessEntity> init() throws Exception {
//
//        list_ProcessEntity = read_config.read();
//        for(int i= 0;i<list_ProcessEntity.size();i++)
//            processJpaRepository.save(list_ProcessEntity.get(i));
//
//        return list_ProcessEntity;
//    }
}

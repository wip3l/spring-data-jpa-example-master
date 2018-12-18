package com.example;

import com.example.domain.*;
import org.w3c.dom.Document;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


public class ReadConfig {

    public static Programs programs;

    public static List<TopicEntity> topicEntityList = new ArrayList<TopicEntity>();

//    public static ProcessEntityPrimarykey processEntityPrimarykey = new ProcessEntityPrimarykey();

//    private static String ip;
    public static List<ProcessEntity>  read(String xmlFile) throws Exception {

//        List  list = new ArrayList();
        List<ProcessEntity> listProcessEntity = new ArrayList<ProcessEntity>();
        /**
         *  利用XStream在Java对象和XML之间相互转换
         */
        XStreamTransfer xsStreamTransfer = new XStreamTransfer();
        //Document 读取 XML
        DocumentBuilder builder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
        // 文件的位置在工作空间的根目录（位置随意，只要写对就ok）
        Document document = builder.parse(new File(xmlFile));
        GetXml getXml = new GetXml();
        String str = null;
        try {
            str = getXml.xmlToString(document);
            System.out.println("--------" + str);
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
        programs = xsStreamTransfer.testBean2XML(str);
        System.out.println(programs.toString());
        //构造processEntity 用于接口初始化配置数据

        for (Iterator it = programs.getPrograms().iterator(); it.hasNext(); ) {
            Program pro = (Program) it.next();
//                    ip = pro.getIp();
            for (Iterator it1 = pro.getProcesses().iterator(); it1.hasNext(); ) {
                ProcessEntity processEntity = new ProcessEntity();
                ProcessEntityPrimarykey processEntityPKey =new ProcessEntityPrimarykey();
                Soft_Process soft_pro = (Soft_Process) it1.next();
                processEntityPKey.setIp(pro.getIp());
                processEntityPKey.setPid(soft_pro.getPid());
                processEntityPKey.setMain(soft_pro.getMain());
                processEntity.setProcessEntityPK(processEntityPKey);
                processEntity.setUser(pro.getUser());
                processEntity.setPsword(pro.getPsword());
                processEntity.setProvince(pro.getProvince());
                processEntity.setType(soft_pro.getType());
                processEntity.setRun_dir(soft_pro.getRun_dir());
                processEntity.setDead_rule(soft_pro.getDead_rule());
                processEntity.setLog_file(soft_pro.getLog_file());
                processEntity.setKill_cmd(soft_pro.getKill_cmd());
                processEntity.setRestart_cmd(soft_pro.getRestart_cmd());
                System.out.println("------Ip--" + pro.getIp() + "---Main--" + soft_pro.getMain());
                listProcessEntity.add(processEntity);
            }

            TopicEntity topicEntity = new TopicEntity();
            TopicEntityPrimarykey topicEntityPrimarykey = new TopicEntityPrimarykey();
            topicEntityPrimarykey.setIp(pro.getMsgqueue().getIp());
            topicEntityPrimarykey.setProvince(pro.getProvince());
            topicEntity.setUser(pro.getMsgqueue().getUser());
            topicEntity.setPassword(pro.getMsgqueue().getPassword());
            topicEntity.setCmd(pro.getMsgqueue().getCmd());
            topicEntity.setTopicEntityPK(topicEntityPrimarykey);
            topicEntityList.add(topicEntity);
        }




//        list.add(listProcessEntity);
//        list.add(topicEntity);
        return listProcessEntity;
    }

}

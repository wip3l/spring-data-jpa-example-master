package com.example;

import com.example.domain.ProcessEntity;
import com.example.domain.Programs;
import com.example.domain.TopicEntity;
import com.example.service.IProcessService;
import com.example.service.impl.ProcessServiceImpl;
import com.example.web.ProcessController;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.ApplicationContext;
import org.w3c.dom.Document;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;


@SpringBootApplication
public class SpringDataJpaExampleApplication {
    private static String log_Path ="/root/xyq/logs/test10.txt";
    public static Programs programs;
	public static List<ProcessEntity> list_ProcessEntity = new ArrayList<>();
	public static List<LoaderMonitor> loaderMonitorList = new ArrayList<LoaderMonitor>();
	public static List<TopicEntity> topicEntityList = new ArrayList<TopicEntity>();
//	protected Logger log = Logger.getLogger(SpringDataJpaExampleApplication.class);
	public static void main(String[] args) throws Exception{
		String xmlFile = null;
		if(args.length<1){
			xmlFile = "ProgramConf.xml";
//			System.out.println("args: [xml_file]");
		}else{
			xmlFile = args[0];
		}
		ApplicationContext context = SpringApplication.run(SpringDataJpaExampleApplication.class, args);

		IProcessService ips = context.getBean(IProcessService.class);
		LoaderMonitor.ips = ips;
		TopicMonitor.ips = ips;

		list_ProcessEntity = ReadConfig.read(xmlFile);
		topicEntityList = ReadConfig.topicEntityList;
//		System.out.println("====="+topicEntity.getCmd()+topicEntity.getTopicEntityPK().getIp());
//		ips.addTopic(topicEntity);
		for(int j =0;j<topicEntityList.size();j++){
			TopicMonitor tm = new TopicMonitor();
			tm.init(topicEntityList.get(j));
			tm.start();
		}


        for(int i= 0;i<list_ProcessEntity.size();i++){
			ips.addProcess(list_ProcessEntity.get(i));
//			System.out.println("Main函数 中 打印的id"+list_ProcessEntity.get(i).getId());
			//保存进程实体，在接口控制类中使用
			ProcessController.pemap.put(list_ProcessEntity.get(i).getProcessEntityPK().getIp()+"_"
					+list_ProcessEntity.get(i).getProcessEntityPK().getMain()+"_"
					+list_ProcessEntity.get(i).getProcessEntityPK().getPid(),
						list_ProcessEntity.get(i));
			LoaderMonitor lm = new LoaderMonitor();
			lm.init(list_ProcessEntity.get(i));
			lm.start();
			loaderMonitorList.add(lm);
		}







//		//定时任务
//		TimerTask task=new TimerTask(){
//			@Override
//			public void run() {
//				System.out.println("now : "+ LocalDateTime.now());
//				//执行shell脚本命令
//				RmtShellExecutor exe = new RmtShellExecutor("121.43.183.37", "root", "data@609");
//				// 执行test3.sh 参数为 param  "sh /root/xyq/test3.sh param"
//				// 打印test3.sh 无参数
//				//System.out.println(exe.exec("sh /root/xyq/test3.sh "));
//				try {
//					//打印读取的日志文件
////					System.out.println(exe.exec("cat "+log_Path));
//					System.out.println(exe.exec("tail -5 "+log_Path));
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//				//执行本地shell命令
//			}
//		};
//
//		Timer timer=new Timer();
//		long delay=0;
//		long period=1000*5;
//		timer.scheduleAtFixedRate(task,delay,period);


	}
}

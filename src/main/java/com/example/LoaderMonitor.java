package com.example;



import java.text.SimpleDateFormat;
import java.util.Date;

public class LoaderMonitor extends StateMmonitorTemplate {
    ProcessState processState = new ProcessState();
//    protected Logger log = Logger.getLogger(LoaderMonitor.class);
    @Override
    public ProcessState getRunningState() {
        Date logTime = null;
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//日期格式
//        String time_now = dateFormat.format( now );

           //通过读取日志，分析当前进程状态
        try {
//            System.out.println("日志文件地址："+processEntity.getLog_file());
            String result = rse.exec("cat "+processEntity.getLog_file()+"|grep -v ^$|tail -n 1");
            Date now = new Date();
//            System.out.println("分析当前进程状态:"+result);
            String[] sourceStrArray = result.split(" ");
            logTime =dateFormat.parse(sourceStrArray[0]+" "+sourceStrArray[1]);
            long time_diff = now.getTime() - logTime.getTime();
//            System.out.println("时间差 :"+time_diff/(1000*60));
//            if(processState.getRunState()=="Stop")
//            {
//
//            }
//            else{
                if(time_diff/(1000*60)>20)
                    processState.setRunState("Error");
                else
                    processState.setRunState("Normal");
//            }


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

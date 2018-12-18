package com.example.web;

import com.example.RmtShellExecutor;
import com.example.domain.ProcessEntity;
import com.example.domain.ProcessEntityPrimarykey;
import com.example.service.IProcessService;
import com.google.gson.Gson;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.*;
import javax.servlet.http.HttpServletRequest;
import java.util.*;

@RestController
@RequestMapping(value = "/Process")
public class ProcessController
{
//    protected Logger log = Logger.getLogger(ProcessController.class);
    public static Map<String,ProcessEntity> pemap = new HashMap<String,ProcessEntity>();
    private RmtShellExecutor exe = null;
    @Autowired
    private IProcessService processService;

    @RequestMapping(value = "/add/{id}/{province}/{ip}",method =RequestMethod.POST)
    public ProcessEntity addProcess(@PathVariable Long id,@PathVariable String province,@PathVariable String ip,@PathVariable String main,@PathVariable String type,@PathVariable String run_dir,@PathVariable String log_file,@PathVariable String dead_rule,@PathVariable String kill_cmd,@PathVariable String restart_cmd)
    {
        ProcessEntity processEntity = new ProcessEntity();
        ProcessEntityPrimarykey processEntityPrimarykey = new ProcessEntityPrimarykey();
        processEntityPrimarykey.setIp(ip);
        processEntityPrimarykey.setMain(main);
        processEntity.setProcessEntityPK(processEntityPrimarykey);
        processEntity.setType(type);
        processEntity.setRun_dir(run_dir);
        processEntity.setRun_dir(log_file);
        processEntity.setRun_dir(dead_rule);
        processEntity.setRun_dir(kill_cmd);
        processEntity.setRun_dir(restart_cmd);
        processService.addProcess(processEntity);
        return processEntity;
    }


    @RequestMapping(value = "/restart",method =RequestMethod.GET)
public String restart(HttpServletRequest req,@Param("ip") String ip,@Param("main") String main,@Param("pid") String pid) {
        String str = null;
        ProcessEntity pe = pemap.get(ip+"_"+main+"_"+pid);
        String callback = req.getParameter("callback");
        Gson gson=new Gson();
        Map<String,String> map=new HashMap<>();
        if(null!=pe){

            try {
                exe = new RmtShellExecutor(pe.getProcessEntityPK().getIp(),pe.getUser(),pe.getPsword());
                str = exe.exec(pe.getRestart_cmd());
                pe.setRun_state("ReStart");
                processService.addProcess(pe);
                map.put("restart_msg","重启成功！");
//                map.put("ret_code","200");
//                System.out.println(str);
//                System.out.println("ReStart id为:"+pe.getId()+"的进程!");
            } catch (Exception e) {
                e.printStackTrace();
//                log.info(e);
            }

        }
        else {
            map.put("restart_msg","未找到"+pe.getProcessEntityPK().getMain()+"服务");
//            log.info("restart_msg 未找到"+pe.getProcessEntityPK().getMain()+"服务");
//            map.put("ret_code","400");
        }

        return callback+"("+gson.toJson(map)+")";

//           }



}

    @RequestMapping(value = "/kill",method =RequestMethod.GET)
    public String kill(HttpServletRequest req,@Param("ip") String ip, @Param("main") String main, @Param("pid") String pid) {
        String str = null;
        ProcessEntity pe = pemap.get(ip+"_"+main+"_"+pid);
        String callback = req.getParameter("callback");
        Gson gson=new Gson();
        Map<String,String> map=new HashMap<>();
        if(null!=pe){

            try {
                exe = new RmtShellExecutor(pe.getProcessEntityPK().getIp(),pe.getUser(),pe.getPsword());
                str = exe.exec(pe.getKill_cmd());
                pe.setRun_state("Stop");
                processService.addProcess(pe);
                map.put("kill_msg","强制Kill成功！");
                map.put("ret_code","200");
//                System.out.println(str);
            } catch (Exception e) {
                e.printStackTrace();
            }

        }
        else {
            map.put("kill_msg","未找到"+pe.getProcessEntityPK().getMain()+"服务");
            map.put("ret_code","400");
        }

        return callback+"("+gson.toJson(map)+")";
    }




    @ResponseBody
    @RequestMapping(value = "/log",method =RequestMethod.GET)
    public String getLog(HttpServletRequest req, @Param("ip") String ip, @Param("main") String main, @Param("pid") String pid) {
        String str = null;
        ProcessEntity pe = pemap.get(ip+"_"+main+"_"+pid);
//        System.out.println("******日志文件"+pe.getLog_file());
        String callback = req.getParameter("callback");
        Gson gson=new Gson();
        Map<String,String> map=new HashMap<>();
        if(null!=pe){
            try {
                exe = new RmtShellExecutor(pe.getProcessEntityPK().getIp(),pe.getUser(),pe.getPsword());
//              str = exe.exec("tail -n 30 "+pe.getLog_file()+"grep -v \"^$\"");
                str = exe.exec("cat "+pe.getLog_file()+"|grep -v ^$|tail -n 20");
//                System.out.println(str);
                map.put("log_msg","\""+str+"\"");
                map.put("ret_code","200");
            } catch (Exception e) {
                e.printStackTrace();
            }
//            System.out.println(callback+"("+gson.toJson(map)+")");
        }
        else{
            map.put("ret_code","400");
            map.put("log_msg","未找到"+pe.getProcessEntityPK().getMain()+"服务！");
//            str = "未找到服务！";
        }
//        String retStr = callback+"("+gson.toJson(map)+")";

        return callback+"("+gson.toJson(map)+")";


    }


    @ResponseBody
    @RequestMapping(value = "/edit",method =RequestMethod.GET)
    public String getEdit(HttpServletRequest req, @Param("ip") String ip, @Param("main") String main, @Param("pid") String pid,@Param("user") String user, @Param("psword") String psword, @Param("dead_rule") String dead_rule,@Param("kill_cmd") String kill_cmd, @Param("log_file") String log_file, @Param("restart_cmd") String restart_cmd,@Param("run_dir") String run_dir, @Param("province") String province) {
        String str = null;
        ProcessEntity pe = pemap.get(ip+"_"+main+"_"+pid);
//        System.out.println((null!=pe));
        System.out.println("******日志文件"+pe.getLog_file());
        String callback = req.getParameter("callback");
        Gson gson=new Gson();
        Map<String,String> map=new HashMap<>();
        if(null!=pe){
            pe.setPsword(psword);
            pe.setUser(user);
            pe.setRestart_cmd(restart_cmd);
            pe.setKill_cmd(kill_cmd);
            pe.setProvince(province);
            pe.setLog_file(log_file);
            pe.setDead_rule(dead_rule);
            pe.setRun_dir(run_dir);
            processService.addProcess(pe);
            pemap.remove(ip+"_"+main+"_"+pid);
            pemap.put(ip+"_"+main+"_"+pid,pe);
            map.put("edit_msg","修改成功");
            map.put("ret_code","200");
        }
        else{
            map.put("ret_code","400");
            map.put("edit_msg","未找到"+main+"服务！");
//            str = "未找到服务！";
        }

        return callback+"("+gson.toJson(map)+")";

    }


//
//    @RequestMapping(value = "/findid/{id}",method =RequestMethod.GET)
//    public User find(@PathVariable Long id){
//        return userService.findById(id);
//    }
//
//
//    @RequestMapping(value = "/getall",method = RequestMethod.GET)
//    public List<User> getUsers()
//    {
//        return userService.getAll();
//    }

}

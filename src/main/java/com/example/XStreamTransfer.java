package com.example;

import com.example.domain.Program;
import com.example.domain.Programs;
import com.example.domain.Soft_Process;
import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;
import java.util.ArrayList;
import java.util.List;

public class XStreamTransfer {

 /**
 * 生成一个Programs对象
 *
 * @return Programs对象
 */
//  public static Programs getPrograms(){

//      Soft_Process pro = new Soft_Process( "main","type","run_dir","log_file","dead_rule","kill_cmd","restart_cmd","run_state","time_state");
//      Soft_Process pro1 = new Soft_Process( "main1","type1","run_dir1","log_file1","dead_rule1","kill_cmd1","restart_cmd1","run_state1","time_state1");
//
//      List<Soft_Process>  soft_Process_list = new ArrayList<Soft_Process>();
//      soft_Process_list.add(pro);
//      soft_Process_list.add(pro1);
//
//      Soft_Process pro2 = new Soft_Process( "main2","type2","run_dir2","log_file2","dead_rule2","kill_cmd2","restart_cmd2","run_state2","time_state2");
//      Soft_Process pro3 = new Soft_Process( "main3","type3","run_dir3","log_file3","dead_rule3","kill_cmd3","restart_cmd3","run_state3","time_state3");
//
//      List<Soft_Process>  soft_Process_list1 = new ArrayList<Soft_Process>();
//      soft_Process_list1.add(pro2);
//      soft_Process_list1.add(pro3);
//
//      Program program = new Program("ip","user","psword",soft_Process_list);
//
//      Program program1 = new Program("ip1","user1","psword1",soft_Process_list1);
//
//      List<Program> program_list = new ArrayList<Program>();
//
//      program_list.add(program);
//      program_list.add(program1);
//      Programs programs = new Programs("province",program_list,"msgqueue");

//     return programs;

//  }

          /**
      * 利用XStream在Java对象和XML之间相互转换
      */
    public static Programs testBean2XML(String xmlString) {
//    System.out.println("将Java对象转换为xml！\n");
//    Programs programs = getPrograms();
    //XStream xstream = new XStream(); //需要XPP3库
    XStream xstream = new XStream(new DomDriver());//不需要XPP3库
//    XStream xstream= newXStream(newStaxDriver());//不需要XPP3库开始使用Java6

//        PrintWriter pw = null;
//        try {
//            pw = new PrintWriter("ProgramConf.xml","utf-8");
////            pw.write("<?xml version=\"1.0\" encoding=\"UTF-8\" ?>\n");
//            //设置Xstream解析注解
////            xstream.autodetectAnnotations(true);
//            //设置类的别名
//            xstream.alias("soft_Process", Soft_Process.class);//为类重命名：Xstream.alias()方法
//            xstream.alias("program", Program.class);
//            xstream.alias("allprograms", Programs.class);
//            xstream.toXML(programs,pw);
//
//
//        } catch (FileNotFoundException e) {
//            e.printStackTrace();
//        } catch (UnsupportedEncodingException e) {
//            e.printStackTrace();
//        }
//
//        String xml = xstream.toXML(programs);
//        System.out.println(xml);

//        //设置Xstream解析注解
//        xstream.autodetectAnnotations(true);
//        //设置类的别名
//        xstream.alias("soft_Process", Soft_Process.class);//为类重命名：Xstream.alias()方法
//        xstream.alias("program", Program.class);
//        xstream.alias("allprograms", Programs.class);
    System.out.println("\n将xml转换为Java对象！");
        xstream.processAnnotations(Programs.class);
        xstream.processAnnotations(Program.class);
        xstream.processAnnotations(Soft_Process.class);
        Programs cre_programs = (Programs) xstream.fromXML(xmlString);
//        System.out.println("-------第一个进程--"+cre_programs.getPrograms().get(0).getIp());
//    System.out.println(cre_programs.toString());
    return cre_programs;
}

//    public static void main(String args[]) {
//        testBean2XML();
//    }

}

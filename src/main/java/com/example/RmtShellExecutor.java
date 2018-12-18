package com.example;


import ch.ethz.ssh2.ChannelCondition;
import ch.ethz.ssh2.Connection;
import ch.ethz.ssh2.Session;
import ch.ethz.ssh2.StreamGobbler;

import org.apache.tomcat.util.http.fileupload.IOUtils;


import java.io.IOException;
import java.io.InputStream;

import java.io.PrintWriter;
import java.nio.charset.Charset;

public class RmtShellExecutor {

//    protected Logger log = Logger.getLogger(RmtShellExecutor.class);
        /**  */
        private Connection conn;
        /** 远程机器IP */
        private String     ip;
        /** 用户名 */
        private String     usr;
        /** 密码 */
        private String     psword;
        private String     charset = Charset.defaultCharset().toString();

        private static final int TIME_OUT = 1000 * 60*60;

        /**
         * 构造函数
         * @param ip
         * @param usr
         * @param ps
         */
        public RmtShellExecutor(String ip, String usr, String ps) {
            this.ip = ip;
            this.usr = usr;
            this.psword = ps;
        }

        /**
         * 登录
         *
         * @return
         * @throws IOException
         */
        private boolean login() throws IOException {
            conn = new Connection(ip);
            conn.connect();
            return conn.authenticateWithPassword(usr, psword);
        }

        /**
         * 执行脚本
         *
         * @param cmds
         * @return
         * @throws Exception
         */
        public String exec(String cmds) throws Exception {
            InputStream stdOut = null;
            InputStream stdErr = null;
            String outStr = "";
            String outErr = "";
            int ret = -1;
            try {
                if (login()) {

                    Session session = conn.openSession();
                    session.execCommand(cmds);
                    stdOut = new StreamGobbler(session.getStdout());
                    outStr = processStream(stdOut, charset);
                    stdErr = new StreamGobbler(session.getStderr());
                    outErr = processStream(stdErr, charset);
                    session.waitForCondition(ChannelCondition.EXIT_STATUS, TIME_OUT);
                    ret = session.getExitStatus();
                    System.out.println("outStr "+outStr+"outErr "+ outErr+"ret "+ret+"stdout "+stdOut);

                } else {
                   System.out.println("登录失败！");
                }
            } finally {
                if (conn != null) {
                    conn.close();
                }
                IOUtils.closeQuietly(stdOut);
                IOUtils.closeQuietly(stdErr);
            }
            return outStr;
        }

        public String execmq(String cmds) throws Exception{

            InputStream stdOut = null;
            InputStream stdErr = null;
            String outStr = "";
            String outErr = "";
            int ret = -1;
            try {
                if (login()) {

                    Session session = conn.openSession();
                    session.requestPTY("bash");
                    session.startShell();
                    // 准备输入命令
                    PrintWriter out = new PrintWriter(session.getStdin());
                    // 输入待执行命令
                   out.println(cmds);
                   out.println("exit");
                   // 6. 关闭输入流
                   out.close();
//                   session.execCommand(cmds);

                   // 7. 等待，除非1.连接关闭；2.输出数据传送完毕；3.进程状态为退出；4.超时
                   session.waitForCondition(ChannelCondition.CLOSED | ChannelCondition.EOF | ChannelCondition.EXIT_STATUS , TIME_OUT);
//                    Thread.sleep(30*1000);
                    stdOut = new StreamGobbler(session.getStdout());
                    outStr = processStream(stdOut, charset);
                    stdErr = new StreamGobbler(session.getStderr());
                    outErr = processStream(stdErr, charset);
//                    session.waitForCondition(ChannelCondition.EXIT_STATUS, TIME_OUT);
                    ret = session.getExitStatus();
                    System.out.println("outStr "+outStr+"outErr "+ outErr+"ret "+ret+"stdout "+stdOut);

                } else {
                    System.out.println("登录失败！");
                }
            } finally {
                if (conn != null) {
                    conn.close();
                }
                IOUtils.closeQuietly(stdOut);
                IOUtils.closeQuietly(stdErr);
            }
            return outStr;
        }
//        /**
//         * @param in
//         * @param charset
//         * @return
//         * @throws IOException
//         * @throws UnsupportedEncodingException
//         */
        private String processStream(InputStream in, String charset) throws Exception {
            byte[] buf = new byte[1024];
            StringBuilder sb = new StringBuilder();
            int n ;
            while ((n = in.read(buf)) != -1) {
                sb.append(new String(buf, 0,n));
            }
            System.out.println("TOPICstring: " +sb.toString()+" ;OVER");
            return sb.toString();
        }

}

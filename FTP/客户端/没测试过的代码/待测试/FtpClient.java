package com.ismp.service.ftp.impl;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.net.SocketException;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.commons.net.PrintCommandListener;
import org.apache.commons.net.ftp.FTP;
import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPClientConfig;
import org.apache.commons.net.ftp.FTPFile;
import org.apache.commons.net.ftp.FTPReply;

/** 
 *  
 *  FTP客户端
 * 
 * @author bleet (mailto:liuqiang2004456@163.com) 
 */  
public class FtpClient {  
    private FTPClient client = null;  
      
    private static FtpClient instance = null;  
      
    private FtpClientConfig config = null;  
	private final Log log = LogFactory.getLog(getClass());
      
    /** 当前工作目录，每次关闭连接要回复到null，因为当前类是单例类 */  
    private String workDirectory = null;  
      
    /** 是否手工控制连接 */  
    private boolean handSwitch = false;  
      
    /** true表示已经登录到ftp服务器 */  
    private boolean ready = false;  
  
    /** 
     *  初始化参数配置及创建commons.net.ftp的客户端 
     * 
     */  
    private FtpClient(String configFile){  
        client = new FTPClient();  
        config = FtpClientConfig.getInstance(configFile);  
          
        /** 日志输出 */  
        client.addProtocolCommandListener( new  PrintCommandListener( new  PrintWriter(System.out)));  
        client.setControlEncoding(config.getRemoteEncoding());  
          
        // 设置当前工作目录  
        workDirectory = config.getRootPath();  
    }  
      
    /** 
     *  获取ftp客户端的实例 
     * @return 
     */  
    public static FtpClient getInstance(String configFile) {  
        if(instance == null) instance = new FtpClient(configFile);  
        return instance;  
    }  
      
    /** 
     *  连接ftp 
     * @return 
     * @throws SocketException 
     * @throws IOException 
     */  
    private boolean connect() throws SocketException, IOException {  
        client.connect(config.getServer(), Integer.valueOf(config.getPort()));  
        int reply;  
        reply = client.getReplyCode();  
  
        if (!FTPReply.isPositiveCompletion(reply)){  
            client.disconnect();  
            log.info("FTP server refused connection.");  
            return false;  
        }  
        return true;  
    }  
      
    /** 
     * 登入ftp 
     * @return 
     * @throws IOException 
     */  
    private boolean login() throws IOException{  
        if (!client.login(config.getUsername(), config.getPassword())) {  
            client.logout();  
            log.info("FTP server login fail.");  
            return false;  
        }  
        return true;  
    }  
      
    /** 
     * 连接然后登入统一入口 
     * @return 
     * @throws SocketException 
     * @throws IOException 
     */  
    public boolean ready() throws SocketException, IOException {  
        if(connect() && login()){  
            setConfig();  
            ready = true;  
            return true;  
        }  
        return false;  
    }  
      
    /** 
     *  ftp运行环境参数配置 
     * @throws IOException 
     */  
    private void setConfig() throws IOException{  
        FTPClientConfig conf = new FTPClientConfig(config.getFTPStyle());  
        client.configure(conf);  
          
        // 被动传输模式  
        if(config.getPassiveMode())  
            client.enterLocalPassiveMode();  
          
        // 二进制传输模式  
        if (config.getBinaryFileType())  
            client.setFileType(FTP.BINARY_FILE_TYPE);  
          
        // 设置当前工作目录  
        client.changeWorkingDirectory(getWorkDirectory());  
    }  
      
    /** 
     * 关闭连接 
     * @throws IOException 
     */  
    public void close() throws IOException {  
        if(client.isConnected()){  
            client.logout();  
            client.disconnect();  
              
            // 也可设置为null  
            workDirectory = config.getRootPath();  
        }  
        ready = false;  
    }  
      
    /** 
     * 获取当前工作目录的文件列表 
     * @return 
     * @throws IOException 
     */  
    public String[] listFiles() throws IOException {  
        if (!setReady()) {  
            return null;  
        }  
        FTPFile[] files = client.listFiles();  
        int filesLength = files.length;  
        String[] fileNameArr = new String[filesLength];  
        for (int i = 0; i < filesLength; i++) {  
            fileNameArr[i] = files[i].getName();  
        }  
        setClose();  
        return fileNameArr;  
    }  
      
    /** 
     * 上传文件，文件名方式 
     * @param path 
     * @param name 
     * @return 
     * @throws IOException 
     */  
    public boolean upload(String localPath, String localFileName, String remoteName) throws IOException {  
        if (!setReady()) {  
            return false;  
        }  
        FileInputStream fis = new FileInputStream(localPath+localFileName);  
        if(client.storeFile(getWorkDirectory()+remoteName, fis)){  
            log.info(" upload success !!! ");  
            fis.close(); 
            setClose();  
            return true;  
        }  
        fis.close();  
        setClose();  
        log.info(" upload fail !!! ");  
        return false;  
    }  
      
    /** 
     * 上传文件,流方式 
     * @param path 
     * @param name 
     * @return 
     * @throws IOException 
     */  
    public boolean upload (InputStream stream, String name, String remoteName) throws IOException {  
        if (!setReady()) {  
            return false; 
        }  
        if(client.storeFile(getWorkDirectory() + remoteName, stream)){  
            log.info(" upload success !!! ");  
            stream.close();  
            setClose();  
            return true;  
        }  
        stream.close();  
        setClose();  
        log.info(" upload fail !!! ");  
        return false;  
    }  
      
    /** 
     *  下载文件 
     * @param path 
     * @param name 
     * @return 
     * @throws UnsupportedEncodingException 
     * @throws IOException 
     */  
    public boolean download (String path, String name) throws UnsupportedEncodingException, IOException {  
        if (!setReady()) {  
            return false;  
        }  
        FileOutputStream fos = new FileOutputStream(path + name);  
  
        if (client.retrieveFile(new String(name.getBytes(config.getLocalEncoding()),config.getRemoteEncoding()), fos)) {  
            log.info("download success !!! ");  
            fos.close();  
            setClose();  
            return true;  
        }  
        fos.close();  
        setClose();  
        log.info(" download fail !!! ");  
        return false;  
    }  
      
    /** 
     *  删除文件 
     * @param path 
     * @param name 
     * @return 
     * @throws IOException 
     */  
    public boolean removeFile(String path, String name) throws IOException {  
        if (!setReady()) {  
            return false;  
        }  
        client.changeWorkingDirectory(config.getRootPath()+path);  
        if(client.deleteFile(name)){  
            log.info("remove file success !!! ");  
            setClose();  
            return true;  
        }  
        setClose();  
        log.info(" remove file fail !!! ");  
        return false;  
    }  
      
    /** 
     * 改变工作目录 
     * @param path 
     * @throws IOException 
     */  
    public void setWorkDirectory(String path) throws IOException {  
        workDirectory = (config.getRootPath()+path);  
          
        // 如果是手动控制可以设置改变工作目录  
        if(handSwitch){  
            client.changeWorkingDirectory(workDirectory);  
        }  
    }  
      
    /** 
     * 创建目录 
     * @param pathname 
     * @return 
     * @throws IOException 
     */  
    public boolean createDirectory(String pathname) throws IOException {  
        if (!setReady()) {  
            return false;  
        }  
        boolean okFlag = client.makeDirectory(pathname);  
        setClose();  
        return okFlag;  
    }  
      
    /** 
     *  获取当前工作目录 
     * @return 
     */  
    public String getWorkDirectory() {  
        return workDirectory;  
    }  
      
    /** 
     *  准备FTP连接环境 
     * @return 
     * @throws SocketException 
     * @throws IOException 
     */  
    private boolean setReady() throws SocketException, IOException{  
        if (!ready) {  
            if (!ready()) {  
                log.error("Ftp ready fail.");  
                if(client.isConnected())  
                    client.disconnect();  
                return false;  
            }  
        }  
        ready = true;  
        return true;  
    }  
      
    /** 
     *  设置是否ftp连接 
     * @throws IOException 
     */  
    private void setClose() throws IOException{  
        if(!handSwitch) close();  
    }  
      
    /** 
     *  打开手动连接 
     * 
     */  
    public void openHandSwitch() {  
        handSwitch = true;  
    }  
      
    /** 
     *  关闭手动连接 
     * 
     */  
    public void closeHandSwitch() {  
        handSwitch = false;  
    }  
}  


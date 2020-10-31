package com.ismp.service.ftp.impl;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.SocketException;
import java.util.Properties;

import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPFile;
import org.apache.commons.net.ftp.FTPListParseEngine;
  
public class FtpClientHandler {  
  
    private FTPClient ftpClient              = new FTPClient();  
  
    private String    host           = "59.108.44.42";  
  
    private String    username       = "xjgz";  
  
    private String    password       = "xjgz";  
  
    private String    r_workDirector = "./";  
  
    private String    l_workDirector = "../";  
  
    private String    config_file    = "../config/boss-config.properties";  
  
    private String    remote_files   = "*";  
  
    private String    local_files    = "*";  
  
    public FtpClientHandler() throws IOException {  
        super();  
        init();  
    }  
  
    public void init() throws IOException {  
        FileInputStream fis = new FileInputStream(config_file);  
        Properties config = new Properties();  
        config.load(fis);  
        host = config.getProperty("Boss_FTP_Url");  
        username = config.getProperty("Username");  
        password = config.getProperty("Password");  
        r_workDirector = config.getProperty("Remote_workdirector");  
        l_workDirector = config.getProperty("Local_workdirector");  
  
        remote_files = config.getProperty("Remote_download_files");  
        local_files = config.getProperty("Local_upload_files");  
  
    }  
  
    private void connection() throws SocketException, IOException {  
        ftpClient.connect(host);  
        ftpClient.login(username, password);  
        ftpClient.changeWorkingDirectory(r_workDirector);  
    }  
  
    private void close() throws IOException {  
        if (ftpClient != null)  
            ftpClient.disconnect();  
    }  
  
    public void DeleteFiles() throws IOException {  
        connection();  
        FTPListParseEngine engine = ftpClient.initiateListParsing(remote_files);  
        FTPFile[] files = engine.getFiles();  
        for (int i = 0; i < files.length; i++) {  
            System.out.print(i + ">>");  
            System.out.println(files[i].getRawListing());  
            ftpClient.dele(files[i].getName());  
        }  
        close();  
    }  
  
    public void DownloadFiles() throws FileNotFoundException, IOException {  
        connection();  
        FTPListParseEngine engine = ftpClient.initiateListParsing(remote_files);  
        FTPFile[] files = engine.getFiles();  
        for (int i = 0; i < files.length; i++) {  
            System.out.print(i + ">>");  
            System.out.println(files[i].getRawListing());  
            ftpClient.retrieveFile(files[i].getName(), new FileOutputStream(new File(l_workDirector + files[i].getName())));  
        }  
        close();  
    }  
  

}
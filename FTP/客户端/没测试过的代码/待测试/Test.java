package com.ismp.service.ftp.impl;

import java.io.IOException;

public class Test {  
    private static FtpClient client = FtpClient.getInstance("D:/ftpconf.properties");  
  
    /** 
     * @param args 
     */  
    public static void main(String[] args) {  
        try {  
            //getFileList();  
            //download("C:/", "startadmin.sh");  
            //uoload();  
            oneconnect();  
        } catch (IOException e) {  
            e.printStackTrace();  
        }  
    }  
      
    public static void getFileList() throws IOException{  
        String [] res = client.listFiles();  
        for (int i = 0; i < res.length; i++) {  
            System.out.println("---------------"+i+"--------------"+res[i]);  
              
        }  
    }  
      
    public static void download(String path, String filename) throws IOException{  
        client.download(path, filename);  
    }  
  
    /** 
     *  三个变量顺次为 本地路径 本地文件名 远端文件名 
     * @throws IOException 
     */  
    public static void uoload() throws IOException{  
        client.upload("C:/", "a.txt", "b.txt");  
    }  
      
    public static void oneconnect() throws IOException{  
        client.openHandSwitch();  
        if(!client.ready()){  
            client.close();  
        }else {  
            getFileList();  
            download("C:/", "startadmin.sh");  
            uoload();  
        }  
        client.close();  
        client.closeHandSwitch();  
    }  
      
} 

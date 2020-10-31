//package com.ismp.service.ftp.impl;
//import com.enterprisedt.net.ftp.FTPException;
//import com.enterprisedt.net.ftp.FTPFile;
//import com.enterprisedt.net.ftp.FileTransferClient;
//import com.enterprisedt.net.ftp.WriteMode;
//import org.apache.commons.logging.Log;
//import org.apache.commons.logging.LogFactory;
//import com.enterprisedt.net.ftp.EventAdapter;
//import com.enterprisedt.net.ftp.FileTransferClient;
//
//
//import java.io.File;
//import java.io.IOException;
//import java.text.ParseException;
//
///**
// * edtftpj是一个java FTP工具包，使用非常方便，感觉比Apache的好用，但Apache更灵活。edtftpj有多种版本，分别是java、.net和js版本。对于Java版的有一个免费版本。我用的就是免费版本。其余的均为商业版本。
//* edtftpj-2.0.3 工具简单封装测试
//*
//* @author leizhimin 2008-9-19 13:33:03
//*/
//public class FtpUtil {
//        private static Log log = LogFactory.getLog(FtpUtil.class);
//        private FileTransferClient client = null;
//
//        public static void main(String[] args) throws FTPException, IOException {
//                FtpUtil ftp = new FtpUtil();
////                ftp.connectServer();
//                File file = new File("C:\\ooo\\upx");
//                UploadListener listener = new UploadListener(ftp.client);
//                ftp.ftpUploadFolder(file, listener);
//
//
//                ftp.ftpDownload("c:\\new1111.gif", "/upx/down.gif");
//
//
//                ftp.disconnect();
//        }
//
//        public FtpUtil() {
//                this.connectServer();
//        }
//
//        public FileTransferClient getClient() {
//                return client;
//        }
//
//        /**
//         * 连接ftp服务器
//         *
//         * @return 连接成功标识
//         */
//        public boolean connectServer() {
//                boolean flag = false;
//                client = new FileTransferClient();
//                try {
//                        client.setUserName("admin");
//                        client.setPassword("123");
//                        client.setRemoteHost("localhost");
//                        client.setRemotePort(21);
//                        client.setTimeout(1200);
//
//                        client.setEventListener(new UploadListener(client));
//                        client.getAdvancedSettings().setTransferBufferSize(1000);
//                        client.getAdvancedSettings().setTransferNotifyInterval(5000);
//                        client.getAdvancedSettings().setControlEncoding("GBK");
//                        client.connect();
//                        flag = true;
//
//                } catch (FTPException e) {
//                        e.printStackTrace();
//                } catch (IOException e) {
//                        e.printStackTrace();
//                }
//                return flag;
//        }
//
//        /**
//         * 关闭FTP客户端连接
//         *
//         * @return 关闭成功标识
//         */
//        public boolean disconnect() {
//                boolean flag = false;
//                try {
//                        client.disconnect();
//                        flag = true;
//                } catch (FTPException e) {
//                        e.printStackTrace();
//                } catch (IOException e) {
//                        e.printStackTrace();
//                }
//                return flag;
//        }
//
//        /**
//         * 上传文件
//         *
//         * @param file 文件
//         * @param ul     监听器
//         */
//        public void ftpUploadFile(File file, UploadListener ul) {
//                String fileName = file.getName();
//                String filePath = file.getPath();
//                try {
//                        client.uploadFile(filePath, fileName, WriteMode.RESUME);
//                        int len = (int) client.getSize(fileName);
//                        log.info("上传文件" + filePath + "完成，大小为" + len + "字节！");
//                } catch (FTPException e) {
//                        e.printStackTrace();
//                } catch (IOException e) {
//                        e.printStackTrace();
//                }
//        }
//
//        /**
//         * 上传文件（夹）
//         *
//         * @param file 上传文件
//         * @param ul     上传监听器
//         */
//        public void ftpUploadFolder(File file, UploadListener ul) {
//                if (file.isFile()) {
//                        ftpUploadFile(file, ul);
//                }
//                try {
//                        if (file.isDirectory()) {
//                                FTPFile[] ftpFiles = client.directoryList();
//                                boolean isExist = false;
//                                //遍历FTP当前目录的文件文件名，如果存在则停止查找，如果不存在则设计标记为不存在
//                                for (FTPFile ftpFile : ftpFiles) {
//                                        if (ftpFile.getName().equals(file.getName())) {
//                                                isExist = true;
//                                                break;
//                                        }
//                                }
//                                //如果要上传的目录不存在，则创建上传目录
//                                if (!isExist) {
//                                        client.createDirectory(file.getName());
//                                }
//                                //设置当前目录 
//                                client.changeDirectory(file.getName());
//
//                                //上传文件的列表
//                                File[] upFiles = file.listFiles();
//                                for (File upFile : upFiles) {
//                                        if (upFile.isFile()) {
//                                                ftpUploadFile(upFile, ul);
//                                        } else if (upFile.isDirectory()) {
//                                                ftpUploadFolder(upFile, ul);
//                                        }
//                                }
//                                client.changeToParentDirectory();
//                        }
//                } catch (FTPException e) {
//                        e.printStackTrace();
//                } catch (IOException e) {
//                        e.printStackTrace();
//                } catch (ParseException e) {
//                        e.printStackTrace();
//                }
//        }
//
//        /**
//         * 下载文件
//         *
//         * @param localFileName    本地文件名
//         * @param remoteFileName 远程文件名
//         * @throws FTPException
//         * @throws IOException
//         */
//        public void ftpDownload(String localFileName, String remoteFileName) throws FTPException, IOException {
//                client.downloadFile(localFileName, remoteFileName, WriteMode.OVERWRITE);
//        }
//        
//        
//        /**
//        * 上传过程监听类
//        *
//        * @author leizhimin 2008-9-22 16:05:53
//        */
//        class UploadListener extends EventAdapter {
//                private long bytesTransferred = 0;
//                private FileTransferClient ftpClient;
//
//                public UploadListener(FileTransferClient ftpClient) {
//                        this.ftpClient = ftpClient;
//                }
//
//                public void bytesTransferred(String connId, String remoteFilename, long bytes) {
//                        bytesTransferred = bytes;
//                }
//        }
//}
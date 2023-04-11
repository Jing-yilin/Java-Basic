package com.hspedu.socket;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @ClassName SocketTCP04Server
 * @Description 服务端
 * 1. 编写一个服务端，和一个客户端
 * 2. 服务器端在9999端口监听
 * 3. 客户端连接到服务端，发送一张图片e:\\qie.png
 * 4. 服务器端接收到客户端发送的图片，保存到src下，发送“收到图片”再退出
 * 5. 客户端接收到服务端发送的“收到图片”，再退出
 * 6. 该程序要求使用 StreamUtils.java
 * @Author Jing Yilin
 * @Date 2022/2/4 11:44
 * @Version 1.0
 **/
@SuppressWarnings("all")
public class SocketTCP04Server {
    public static void main(String[] args) throws IOException {
        //新建服务器主机端口
        ServerSocket serverSocket = new ServerSocket(9999);
        System.out.println("--------------等待来自客户端的请求-------------");
        Socket socket = serverSocket.accept();
        System.out.println("--------------收到来自客户端的请求-------------");

        //接受来自客户端的信息流
        System.out.println("--------------开始保存来自客户端的图片-------------");
        String fileName = "src\\testpic.png";
        BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(fileName));
        BufferedInputStream bis = new BufferedInputStream(socket.getInputStream());
        byte[] buf = new byte[1024];
        int readLen;
        while ((readLen = bis.read(buf)) != -1){
            bos.write(buf, 0, readLen);
        }
        bos.flush();
        socket.shutdownInput();
        System.out.println("--------------图片保存成功-------------");

        //向客户端发送收到图片的信息
        System.out.println("--------------向客户端发送反馈-------------");
        String msg = "收到信息";
        OutputStream outputStream = socket.getOutputStream();
        outputStream.write("收到信息".getBytes());
        outputStream.flush();
        socket.shutdownOutput();
        System.out.println("--------------成功发送反馈-------------");

        //关闭流
        outputStream.close();
        bos.close();
        bis.close();
        socket.close();
        serverSocket.close();
        System.out.println("--------------服务器端退出-------------");


    }
}

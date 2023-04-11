package com.hspedu.socket;

import java.io.*;
import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.Socket;

/**
 * @ClassName SocketTCP04Client
 * @Description 客户端
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
public class SocketTCP04Client {
    public static void main(String[] args) throws IOException {
        //建立socket连接
        Socket socket = new Socket(InetAddress.getLocalHost(), 9999);
        System.out.println("--------------与客户端建立连接-------------");

        //客户端向服务端发送图片
        System.out.println("--------------开始发送图片-------------");
        String fileName = "D:\\Test\\testpic.png";
        BufferedOutputStream bos = new BufferedOutputStream(socket.getOutputStream());
        BufferedInputStream bis = new BufferedInputStream(new FileInputStream(fileName));
        byte[] buf = new byte[1024];
        int readLen;
        while ((readLen = bis.read(buf)) != -1){
            bos.write(buf);
        }
        bos.flush();
        socket.shutdownOutput();
        System.out.println("--------------图片发送完毕-------------");

        //接受来自客户端的反馈
        String msg = "收到信息";
        InputStream inputStream = socket.getInputStream();
        byte[] bytes = new byte[1024];
        inputStream.read(bytes);
        socket.shutdownInput();
        String s = bytes.toString();
        if (s.equals(msg)){
            System.out.println("--------------收到服务端接受成功的信息,开始执行退出-----------");
        }

        //关闭流
        inputStream.close();
        bis.close();
        bos.close();
        socket.close();
        System.out.println("--------------客户端退出-------------");

    }
}

package com.hspedu.socket;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

/**
 * @ClassName SocketTCP02Client
 * @Description 案例2的客户端
 * @Author Jing Yilin
 * @Date 2022/2/3 19:26
 * @Version 1.0
 **/
public class SocketTCP02Client {
    public static void main(String[] args) throws IOException {
        //建立socket连接
        Socket socket = new Socket(InetAddress.getLocalHost(), 9999);
        //向服务端发送信息
        OutputStream outputStream = socket.getOutputStream();
        outputStream.write("Hello, server!".getBytes());
        socket.shutdownOutput();//关闭输出流，表示输出结束
        //读取并输出来自服务端的信息
        System.out.println("收到来自服务端的信息:");
        InputStream inputStream = socket.getInputStream();
        byte[] buf = new byte[1024];
        int readLen;
        while ((readLen = inputStream.read(buf)) != -1) {
            System.out.println(new String(buf, 0, readLen));
        }
        socket.shutdownInput();//关闭输入流，表示输入结束
        //关闭客户端
        inputStream.close();
        outputStream.close();
        socket.close();
        System.out.println("--------------客户端退出-------------");
    }
}

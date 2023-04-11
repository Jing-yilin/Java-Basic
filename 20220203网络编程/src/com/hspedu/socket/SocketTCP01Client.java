package com.hspedu.socket;

import java.io.IOException;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

/**
 * @ClassName SocketTCP01Client
 * @Description 客户端
 * @Author Jing Yilin
 * @Date 2022/2/3 18:54
 * @Version 1.0
 **/
public class SocketTCP01Client {
    public static void main(String[] args) throws IOException {
        //1. 连接服务端（需要IP和端口9999）
        //   public Socket(InetAddress address, int port)
        //   如果连接成功，返回一个socket对象
        Socket socket = new Socket(InetAddress.getLocalHost(), 9999);
        System.out.println("客户端socket返回 = " + socket.getClass());

        //2. 通过socket.getOutputStream()得到和socket对象关联的输出流对象
        OutputStream socketOutputStream = socket.getOutputStream();
        //3. 通过是输出流，写入数据到 数据通道
        socketOutputStream.write("hello, server!".getBytes());
        //4. 关闭流对象和socket
        socketOutputStream.close();
        socket.close();
        System.out.println("客户端退出");
    }
}

package com.hspedu.socket;

import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @ClassName SocketTCP01Server
 * @Description 服务端
 * @Author Jing Yilin
 * @Date 2022/2/3 18:49
 * @Version 1.0
 **/
public class SocketTCP01Server {
    public static void main(String[] args) throws IOException {
        //1. 在本机的9999端口监听，等待连接(要求9999端口没有被占用)
        ServerSocket serverSocket = new ServerSocket(9999);
        System.out.println("服务器在9999端口监听，等待连接...");
        //2.当没有客户端连接9999端口时，程序会阻塞，等待连接
        //  如果有客户端连接，则会返回一个socket对象，程序继续
        Socket socket = serverSocket.accept();
        System.out.println("服务器端socket = " + socket.getClass());
        //3. 通过socket.getInputStream()得到和socket对象关联的输出流对象
        InputStream socketInputStream = socket.getInputStream();
        //4. IO读取
        byte[] buf = new byte[1024];
        int readLen = 0;
        while ((readLen = socketInputStream.read(buf)) != -1){
            System.out.println(new String(buf, 0, readLen));
        }
        //5. 关闭流对象、socket和serverSocket
        socketInputStream.close();
        socket.close();
        serverSocket.close();


    }
}

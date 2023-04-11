package com.hspedu.socket;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.StandardCharsets;

/**
 * @ClassName SocketTCP02Server
 * @Description 案例2的服务器端
 * @Author Jing Yilin
 * @Date 2022/2/3 19:26
 * @Version 1.0
 **/
public class SocketTCP02Server {
    public static void main(String[] args) throws IOException {
        //新建服务器主机端口
        ServerSocket serverSocket = new ServerSocket(9999);
        System.out.println("--------------等待来自客户端的请求-------------");
        Socket socket = serverSocket.accept();
        System.out.println("--------------收到来自客户端的请求-------------");

        //读取并输出来自客户端的信息
        System.out.println("收到来自客户端的信息:");
        InputStream inputStream = socket.getInputStream();
        byte[] buf = new byte[1024];
        int readLen;
        while ((readLen = inputStream.read(buf)) != -1) {
            System.out.println(new String(buf, 0, readLen));
        }
        socket.shutdownInput();//关闭输入流，表示输入结束
        //向客户端发送信息
        OutputStream outputStream = socket.getOutputStream();
        outputStream.write("Hello, client!".getBytes());
        socket.shutdownOutput();//关闭输出流，表示输出结束
        //关闭服务器端
        inputStream.close();
        outputStream.close();
        socket.close();
        serverSocket.close();
        System.out.println("--------------服务器端退出-------------");
    }
}

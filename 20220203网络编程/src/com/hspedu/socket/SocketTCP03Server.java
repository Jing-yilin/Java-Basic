package com.hspedu.socket;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @ClassName SocketTCP03Server
 * @Description 使用字符流
 * @Author Jing Yilin
 * @Date 2022/2/3 19:55
 * @Version 1.0
 **/
@SuppressWarnings("all")
public class SocketTCP03Server {
    public static void main(String[] args) throws IOException {
        //新建服务器主机端口
        ServerSocket serverSocket = new ServerSocket(9999);
        System.out.println("--------------等待来自客户端的请求-------------");
        Socket socket = serverSocket.accept();
        System.out.println("--------------收到来自客户端的请求-------------");

        //读取并输出来自客户端的信息
        System.out.println("收到来自客户端的信息:");
        InputStream inputStream = socket.getInputStream();
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
        String s = bufferedReader.readLine();
        System.out.println(s);
        //向客户端发送信息
        OutputStream outputStream = socket.getOutputStream();
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream));
        bufferedWriter.write("Hello, client!");
        bufferedWriter.newLine();//插入一个换行符，表示写入结束
        bufferedWriter.flush();//如果使用字符流，需要手动刷新

        //关闭服务器端
        bufferedReader.close();
        bufferedWriter.close();
        socket.close();
        serverSocket.close();
        System.out.println("--------------服务器端退出-------------");
    }
}

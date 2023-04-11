package com.hspedu.socket;

import java.io.*;
import java.net.InetAddress;
import java.net.Socket;

/**
 * @ClassName SocketTCP03Client
 * @Description 使用字符流
 * @Author Jing Yilin
 * @Date 2022/2/3 19:55
 * @Version 1.0
 **/
@SuppressWarnings("all")
public class SocketTCP03Client {
    public static void main(String[] args) throws IOException {
        //建立socket连接
        Socket socket = new Socket(InetAddress.getLocalHost(), 9999);
        //向服务端发送信息
        OutputStream outputStream = socket.getOutputStream();
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream));
        bufferedWriter.write("Hello, server!");
        bufferedWriter.newLine();//插入一个换行符，表示写入结束，此时要求读取时使用readLine()
        bufferedWriter.flush();//如果使用字符流，需要手动刷新
        //读取并输出来自服务端的信息
        System.out.println("收到来自服务端的信息:");
        InputStream inputStream = socket.getInputStream();
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
        String s = bufferedReader.readLine();
        System.out.println(s);
        //关闭客户端
        bufferedReader.close();
        bufferedWriter.close();
        socket.close();
        System.out.println("--------------客户端退出-------------");
    }
}

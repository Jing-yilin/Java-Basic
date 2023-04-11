package com.hspedu.homeworks;

import java.io.*;
import java.net.InetAddress;
import java.net.Socket;

/**
 * @ClassName Homework01Client
 * @Description (1)使用字符流的方式，编写一个客户端程序和服务器端程序，
 *              (2)客户端发送"name",服务器端接收到后，返回"我是nova",nova是你自己的名字
 *              (3)客户端发送"hobby",服务器端接收到后，返回"编写java程序"
 *              (4)不是这两个问题，回复"你说啥呢"
 * @Author Jing Yilin
 * @Date 2022/2/6 16:45
 * @Version 1.0
 **/
public class Homework01Client {
    public static void main(String[] args) throws IOException {
        Socket socket = new Socket(InetAddress.getLocalHost(), 9955);
        //向服务端发送信息
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
        bw.write("name");
        bw.newLine();
        bw.flush();
        socket.shutdownOutput();
        //接受回应
        BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        System.out.println("来自服务端的回应是:");
        String s = br.readLine();
        System.out.println(s);
        socket.shutdownInput();

        //关闭socket
        bw.close();
        br.close();
        socket.close();
        System.out.println("---------------客户端退出---------------");

    }
}

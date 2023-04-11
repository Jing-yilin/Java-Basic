package com.hspedu.homeworks;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @ClassName Homework01Server
 * @Description (1)使用字符流的方式，编写一个客户端程序和服务器端程序，
 * (2)客户端发送"name",服务器端接收到后，返回"我是nova",nova是你自己的名字
 * (3)客户端发送"hobby",服务器端接收到后，返回"编写java程序"
 * (4)不是这两个问题，回复"你说啥呢"
 * @Author Jing Yilin
 * @Date 2022/2/6 16:45
 * @Version 1.0
 **/
@SuppressWarnings("all")
public class Homework01Server {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(9955);
        Socket socket = serverSocket.accept();

        //接受来自客户端的信息
        BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        String s = br.readLine();
        System.out.println("收到来自客户端的信息为:");
        System.out.println(s);
        socket.shutdownInput();

        String name = "我是nova";
        String hobby = "编写Java程序";
        String res = "你说啥呢";

        switch (s) {
            case "name":
                res = name;
                break;
            case "hobby":
                res = hobby;
                break;
            default:
                break;
        }
        //向客户端发送回应
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
        bw.write(res);
        bw.newLine();
        bw.flush();
        socket.shutdownOutput();

        //关闭socket
        br.close();
        bw.close();

        socket.close();
        serverSocket.close();

        System.out.println("---------------服务端退出---------------");

    }
}

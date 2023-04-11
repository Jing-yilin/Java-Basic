package com.hspedu.homeworks;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

/**
 * @ClassName Homework02SenderB
 * @Description (1)编写一个接收端A, 和一个发送端B, 使用UDP协议完成
 *              (2)接收端在8888端口等待接收数据（receive)
 *              (3)发送端向接收端发送数据“四大名著是哪些”
 *              (4)接收端接收到发送端发送的问题后，返回“四大名著是<<红楼梦>>…",否则返what ?
 *              (5)接收端和发送端程序退出
 * @Author Jing Yilin
 * @Date 2022/2/6 17:33
 * @Version 1.0
 **/
public class Homework02SenderB {
    public static void main(String[] args) throws IOException {
        DatagramSocket socket = new DatagramSocket(9998);
        byte[] bytes = "四大名著是哪些".getBytes();
        DatagramPacket packet = new DatagramPacket(bytes, bytes.length, InetAddress.getByName("192.168.0.109"), 8888);
        socket.send(packet);
        System.out.println("---------------消息已发送----------------");
        System.out.println("---------------以下为接收端的反馈----------------");
        byte[] buf = new byte[1024];
        DatagramPacket packet1 = new DatagramPacket(buf, buf.length);
        socket.receive(packet1);
        byte[] data = packet1.getData();
        int length = packet1.getLength();
        String s = new String(data, 0, length);
        System.out.println(s);

        System.out.println("-----------------发送端退出-----------------");


    }
}

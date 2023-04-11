package com.hspedu.homeworks;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

/**
 * @ClassName Homework02ReceiverA
 * @Description (1)编写一个接收端A, 和一个发送端B, 使用UDP协议完成
 *              (2)接收端在8888端口等待接收数据（receive)
 *              (3)发送端向接收端发送数据“四大名著是哪些”
 *              (4)接收端接收到发送端发送的问题后，返回“四大名著是<<红楼梦>>…",否则返what ?
 *              (5)接收端和发送端程序退出
 * @Author Jing Yilin
 * @Date 2022/2/6 17:32
 * @Version 1.0
 **/
public class Homework02ReceiverA {
    public static void main(String[] args) throws IOException {
        DatagramSocket socket = new DatagramSocket(8888);
        System.out.println("----------------等待发送端消息-----------------");
        byte[] buf = new byte[1024];
        DatagramPacket packet = new DatagramPacket(buf, buf.length);
        socket.receive(packet);
        byte[] data = packet.getData();
        int length = packet.getLength();
        String s = new String(data, 0, length);
        String ans;
        if (s.equals("四大名著是哪些")){
            ans = "四大名著是<<红楼梦>>…";

        }else {
            ans = "What?";
        }
        byte[] ansBytes = ans.getBytes();
        DatagramPacket packet1 = new DatagramPacket(ansBytes, ansBytes.length, InetAddress.getByName("192.168.0.109"), 9998);
        socket.send(packet1);
        socket.close();
        System.out.println("-----------------接收端退出-----------------");
    }
}

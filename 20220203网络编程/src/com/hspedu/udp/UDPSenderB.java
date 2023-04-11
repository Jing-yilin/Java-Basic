package com.hspedu.udp;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

/**
 * @ClassName UDPSenderB
 * @Description 发送端
 * @Author Jing Yilin
 * @Date 2022/2/4 16:19
 * @Version 1.0
 **/
public class UDPSenderB {
    public static void main(String[] args) throws IOException {
        //1. 创建一个 DatagramSocket对象，准备在9999端口接受数据
        //   因为发送端也可以接收数据，所以也需要一个端口
        DatagramSocket socket = new DatagramSocket(9998);

        //2. 构建一个 DatagramPacket对象，放入要发送的数据
        byte[] bytes = "Hello, 今晚吃火锅吗?".getBytes();
        DatagramPacket packet = new DatagramPacket(bytes, bytes.length, InetAddress.getByName("192.168.0.109"), 9999);

        //3. 发送数据包
        socket.send(packet);

        //4. 接受并拆解数据包
        System.out.println("---------------接受来自接受端A的消息---------------");
        byte[] buf = new byte[1024];
        DatagramPacket packet1 = new DatagramPacket(buf, buf.length);
        socket.receive(packet1);
        int length = packet1.getLength();
        byte[] data = packet1.getData();
        String s = new String(data, 0, length);
        System.out.println(s);

        //5. 关闭socket
        socket.close();
        System.out.println("---------------发送端B退出---------------");

    }
}

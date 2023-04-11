package com.hspedu.udp;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

/**
 * @ClassName UDPReceiverA
 * @Description 接收端
 * @Author Jing Yilin
 * @Date 2022/2/4 16:19
 * @Version 1.0
 **/
public class UDPReceiverA {
    public static void main(String[] args)  throws IOException {
        //1. 创建一个 DatagramSocket对象，在9999端口监听
        DatagramSocket socket = new DatagramSocket(9999);

        //2. 构建一个 DatagramPacket对象，准备接受数据
        //   数据包最大为64KB
        byte[] buf = new byte[1024];
        DatagramPacket packet = new DatagramPacket(buf, buf.length);

        //3. 调用接收方法，将 通过网络传输的packet对象 填充到 我们的空的packet
        //   当有数据包发送到本机的9999端口，就会接收数据
        //   如果没有收到数据，就会堵塞
        System.out.println("---------------接收端A等待接收数据---------------");
        socket.receive(packet);

        //4. 可以对packet进行拆包，取出数据，并显示
        int length = packet.getLength();
        byte[] data = packet.getData();
        String s = new String(data, 0, length);
        System.out.println(s);

        //5. 发送反馈
        byte[] bytes = "好的，明天见啦~".getBytes();
        DatagramPacket packet1 = new DatagramPacket(bytes, bytes.length, InetAddress.getByName("192.168.0.109"), 9998);
        socket.send(packet1);

        //6. 关闭socket
        socket.close();
        System.out.println("---------------接收端A退出---------------");
    }
}

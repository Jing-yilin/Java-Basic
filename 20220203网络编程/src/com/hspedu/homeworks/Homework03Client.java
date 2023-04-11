package com.hspedu.homeworks;

import java.io.*;
import java.net.InetAddress;
import java.net.Socket;

/**
 * @ClassName Homework04Client
 * @Description (1)编写客户端程序和服务器端程序
 *              (2)客户端可以输入一个音乐文件名，比如高山流水，服务端收到音乐名后，
 *              可以给客户端返回这个音乐文件，如果服务器没有这个文件，返回一个默认的音乐即可.
 *              (3)客户端收到文件后，保存到本地e:\\
 *              (4)提示：该程序可以使用 StreamUtils.java
 * @Author Jing Yilin
 * @Date 2022/2/6 18:15
 * @Version 1.0
 **/
public class Homework03Client {
    public static void main(String[] args) throws IOException {
        Socket socket = new Socket(InetAddress.getLocalHost(), 9999);
        String musicName = "Enter Sandman.mp3";
        //向服务端发送名称
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
        bw.write(musicName);
        bw.newLine();
        bw.flush();
        socket.shutdownOutput();

        //收取来自服务器的文件,并保存到D:\\Test目录下
        InputStream is = socket.getInputStream();
        byte[] bytes = new byte[1024];
        int readLen;
        String fileSavePath = "D:\\Test\\" + musicName;
        BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(fileSavePath));
        while ((readLen = is.read(bytes)) != -1){
            bos.write(bytes, 0, readLen);
        }
        bos.flush();
        socket.shutdownInput();
        System.out.println("接收完毕");

        //关闭客户端
        bos.close();
        is.close();
        bw.close();
        socket.close();
    }
}

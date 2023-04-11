package com.hspedu.homeworks;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @ClassName Homework03Server
 * @Description (1)编写客户端程序和服务器端程序
 *              (2)客户端可以输入一个音乐文件名，比如高山流水，服务端收到音乐名后，
 *              可以给客户端返回这个音乐文件，如果服务器没有这个文件，返回一个默认的音乐即可.
 *              (3)客户端收到文件后，保存到本地e:\\
 *              (4)提示：该程序可以使用 StreamUtils.java
 * @Author Jing Yilin
 * @Date 2022/2/6 18:14
 * @Version 1.0
 **/
public class Homework03Server {
    public static void main(String[] args) throws IOException {
        //创建socket
        ServerSocket serverSocket = new ServerSocket(9999);
        Socket socket = serverSocket.accept();

        //获取请求的音乐名
        String defaultMusic = "Default Music.mp3";
        String req = " ";
        BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        req = br.readLine();
        socket.shutdownInput();
        File file = new File("src\\"+req);
        if (!file.exists()){
            req = defaultMusic;
        }
        //以流的方式读取文件,并发送文件
        FileInputStream fis = new FileInputStream("src\\" + req);
        byte[] buf = new byte[1024];
        int readLen;
        OutputStream os = socket.getOutputStream();
        while ((readLen = fis.read(buf)) != -1){
            os.write(buf, 0, readLen);
        }
        os.flush();
        socket.shutdownOutput();
        //关闭服务端
        os.close();
        fis.close();
        br.close();
        socket.close();
    }
}

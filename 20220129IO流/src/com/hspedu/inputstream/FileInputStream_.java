package com.hspedu.inputstream;

import org.junit.jupiter.api.Test;

import java.io.FileInputStream;
import java.io.IOException;

/**
 * @ClassName FileInputStream_
 * @Description 演示FileInputStream的使用(字节输入流 文件 --> 程序)
 * @Author Jing Yilin
 * @Date 2022/1/29 17:40
 * @Version 1.0
 **/
public class FileInputStream_ {
    public static void main(String[] args) {

    }
    //使用read()方法读取文件
    @Test
    public void readFile01() throws IOException {
        String fileName = "D:\\Test\\hello.txt";
        int readData = 0;
        //创建fileInputStream对象用于读取 文件
        FileInputStream fileInputStream = new FileInputStream(fileName);
        //public int read()从此输入流中读取一个数据字节。如果没有输入可用，则此方法将阻塞。
        //如果已到达文件末尾，则返回 -1,表示读取完毕
        while ((readData = fileInputStream.read()) != -1){
            System.out.print((char)readData);
        }
        //关闭流
        fileInputStream.close();
    }

    //使用read(byte[] b)方法读取文件
    //从此输入流中将最多 b.length 个字节的数据读入一个 byte 数组中
    @Test
    public void readFile02() throws IOException {
        String fileName = "D:\\Test\\hello.txt";
        //字节数组
        byte[] b = new byte[8]; // 一次读取8个字节
        int readLen = 0;
        //创建fileInputStream对象用于读取 文件
        FileInputStream fileInputStream = new FileInputStream(fileName);
        //如果已到达文件末尾，则返回 -1,表示读取完毕;
        //如果读取正常，就返回实际读取的字节数
        while ((readLen = fileInputStream.read(b)) != -1){
            System.out.print(new String(b,0,readLen));
        }
        fileInputStream.close();
    }
}

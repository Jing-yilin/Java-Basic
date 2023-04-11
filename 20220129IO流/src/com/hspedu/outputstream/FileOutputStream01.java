package com.hspedu.outputstream;

import org.junit.jupiter.api.Test;

import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

/**
 * @ClassName FileOutputStream_
 * @Description TODO
 * @Author Jing Yilin
 * @Date 2022/1/29 18:33
 * @Version 1.0
 **/
public class FileOutputStream01 {
    public static void main(String[] args) {

    }

    /**
     * 演示使用FileOutputStream 将数据写入文件
     * 如果该文件不存在则创建
     */
    @Test
    public void writeFile() throws IOException {

        //创建FileOutputStream对象
        //1. new FileOutputStream(fileName) 创建方式 回覆盖原先所有内容
        //2. new FileOutputStream(fileName, true) 会追加内容
        String fileName = "D:\\Test\\a.txt";
        FileOutputStream fileOutputStream = null;
        fileOutputStream = new FileOutputStream(fileName, true);
        //写入一个字节
//        fileOutputStream.write('a');

        //通过循环写入多个字节
//        String content = "Galneryus";
//        byte[] bytes = content.getBytes(StandardCharsets.UTF_8);
//        for (int i = 0; i < bytes.length; i++) {
//            fileOutputStream.write(bytes[i]);
//        }

        //一次性写入多个字节 public void write(byte b[])
//        String content = "Galneryus and X Japan";
//        byte[] bytes = content.getBytes(StandardCharsets.UTF_8);
//        fileOutputStream.write(bytes);

        //指定输入字节数  write(byte[] b, int off, int len)
        //将指定 byte 数组中从偏移量 off 开始的 len 个字节写入此文件输出流。
        String content = "Galneryus and X Japan";
        byte[] bytes = content.getBytes(StandardCharsets.UTF_8);
        fileOutputStream.write(bytes,0,10);


        System.out.println("成功写入...");
        fileOutputStream.close();
    }
}

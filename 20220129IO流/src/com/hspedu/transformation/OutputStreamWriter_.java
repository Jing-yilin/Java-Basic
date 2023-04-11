package com.hspedu.transformation;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;

/**
 * @ClassName OutputStreamWriter_
 * @Description 演示OutputStreamWriter
 * @Author Jing Yilin
 * @Date 2022/1/31 13:38
 * @Version 1.0
 **/
public class OutputStreamWriter_ {
    public static void main(String[] args) throws IOException {
        String content = "我要上清华！";
        String fileName = "D:\\Test\\b3.txt";
        FileOutputStream fileOutputStream = new FileOutputStream(fileName);
        OutputStreamWriter outputStreamWriter = new OutputStreamWriter(fileOutputStream, "gbk");
        outputStreamWriter.write(content);
        outputStreamWriter.close();
        System.out.println("-------------------------------------");
        System.out.println("以gbk编码写入完毕");
    }
}

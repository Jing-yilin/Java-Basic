package com.hspedu.transformation;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @ClassName InputStreamReader_
 * @Description 演示使用 InputStreamReader 转换流解决中文乱码问题
 *              将字节流 FileInputStream 转成字符流 InputStreamReader
 *              指定编码 gbk或者utf-8
 * @Author Jing Yilin
 * @Date 2022/1/31 13:29
 * @Version 1.0
 **/
public class InputStreamReader_ {
    public static void main(String[] args) throws IOException {
        String fileName = "D:\\Test\\b2.txt";

        FileInputStream fileInputStream = new FileInputStream(fileName);
        InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream, "gbk");
        char[] chars = new char[8];
        int readLen;
        while ((readLen = inputStreamReader.read(chars)) != -1){
            System.out.println(new String(chars, 0, readLen));
        }
        inputStreamReader.close();
        System.out.println("-------------------------------------");
        System.out.println("读取完毕");
    }
}

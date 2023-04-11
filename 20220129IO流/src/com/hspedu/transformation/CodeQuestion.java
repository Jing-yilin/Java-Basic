package com.hspedu.transformation;

import java.io.*;

/**
 * @ClassName CodeQuestion
 * @Description 看一个中文乱码问题
 * @Author Jing Yilin
 * @Date 2022/1/31 13:12
 * @Version 1.0
 **/
public class CodeQuestion {
    public static void main(String[] args) throws IOException {
        String fileName = "D:\\Test\\b2.txt";

        //1. 创建输入流
        BufferedReader br = new BufferedReader(new FileReader(fileName));
        //2. 读取,默认情况下按照UTF-8
        String s = br.readLine();
        System.out.println("读取的内容: " + s);
        br.close();

    }
}

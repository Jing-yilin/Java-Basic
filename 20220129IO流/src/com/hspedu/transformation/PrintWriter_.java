package com.hspedu.transformation;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @ClassName PrintWriter_
 * @Description 演示PrintWriter使用方式
 * @Author Jing Yilin
 * @Date 2022/2/1 14:51
 * @Version 1.0
 **/
public class PrintWriter_ {
    public static void main(String[] args) throws IOException {
//        PrintWriter printWriter = new PrintWriter(System.out);
        PrintWriter printWriter = new PrintWriter(new FileWriter("D:\\Test\\f2.txt"));
        printWriter.print("我爱Java!");
        printWriter.close();//close才会真正写入数据
    }
}

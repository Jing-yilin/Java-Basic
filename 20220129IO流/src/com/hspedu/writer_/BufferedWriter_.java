package com.hspedu.writer_;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

/**
 * @ClassName BufferedWriter_
 * @Description TODO
 * @Author Jing Yilin
 * @Date 2022/1/30 14:27
 * @Version 1.0
 **/
public class BufferedWriter_ {
    public static void main(String[] args) throws IOException {
        /**
         * 使用BufferedWriter将"Hello,world"写入文件
         */
        String fileName = "D:\\Test\\hw.txt";
        String content = "Hello,world";
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(fileName));
        bufferedWriter.write(content);
        bufferedWriter.newLine();//插入一个和系统相关的换行符
        bufferedWriter.write(content);
        bufferedWriter.close();
        System.out.println("写入成功");
    }
}

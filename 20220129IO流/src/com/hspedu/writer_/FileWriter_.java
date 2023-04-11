package com.hspedu.writer_;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

/**
 * @ClassName FileWriter_
 * @Description TODO
 * @Author Jing Yilin
 * @Date 2022/1/30 12:05
 * @Version 1.0
 **/
public class FileWriter_ {
    public static void main(String[] args) throws IOException {
        String content = "保研清华";
        String fileName = "D:\\Test\\保研清华.txt";
        FileWriter fileWriter = new FileWriter(fileName);

        //1. write(int c)
        //写入单个字符
        fileWriter.write('Q');
        //2. write(char cbuf[])
        //写入指定数组
        fileWriter.write(content.toCharArray());
        //3. write(char cbuf[], int off, int len)
        //写入指定数组的指定部分指定长度
        fileWriter.write(content.toCharArray(),0,2);
        //4. write(String str)
        //写入字符串
        fileWriter.write(content);
        //5. write(String str, int off, int len)
        //写入字符串的的指定部分指定长度
        fileWriter.write(content, 0,2);

        //一定要close()关闭或者flush()刷新
        fileWriter.close();

        System.out.println("写入成功");

    }
}

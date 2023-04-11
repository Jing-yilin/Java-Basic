package com.hspedu.homeworks;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * @ClassName Homework02
 * @Description 使用BufferedReader读取一个文本文件，为每行加上引行，再输出到屏幕上
 * @Author Jing Yilin
 * @Date 2022/2/1 20:54
 * @Version 1.0
 **/
public class Homework02 {
    public static void main(String[] args) throws IOException {
        String fileName = "D:\\Test\\b.txt";
        BufferedReader br = new BufferedReader(new FileReader(fileName));
        String line = " ";
        while ((line = br.readLine()) != null){
            System.out.println(line);
        }
        br.close();
        System.out.println("==================输出完毕=================");
    }
}

package com.hspedu.properties;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 * @ClassName Properties01
 * @Description 演示传统的读取properties的方法
 * @Author Jing Yilin
 * @Date 2022/2/1 15:08
 * @Version 1.0
 **/
public class Properties01 {
    public static void main(String[] args) throws IOException {
        //读取mysql.properties文件

        BufferedReader bufferedReader = new BufferedReader(new FileReader("src\\mysql.properties"));
        String line = " ";
        while((line = bufferedReader.readLine()) != null){
            String[] split = line.split("=");
            System.out.println(split[0] + "值是" + split[1]);
        }
        bufferedReader.close();
    }
}

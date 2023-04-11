package com.hspedu.reader_;

import java.io.FileReader;
import java.io.IOException;

/**
 * @ClassName FileReader_
 * @Description 读取"D:\\Test\\story.txt"
 * @Author Jing Yilin
 * @Date 2022/1/30 10:45
 * @Version 1.0
 **/
public class FileReader_ {
    public static void main(String[] args) throws IOException {

        String fileName = "D:\\Test\\不要温柔的走入那良宵.txt";
        //1. 创建一个FileReader
        FileReader fileReader = new FileReader(fileName);

        //2. 循环读取 使用raed()
//        int data;
//        while((data = fileReader.read()) != -1){
//            System.out.print((char) data);
//        }

        //2.或者使用数组记录
        char[] buf = new char[8];
        int readLen;
        while((readLen = fileReader.read(buf)) != -1){
            System.out.print(new String(buf,0,readLen));
        }


        //3. 关闭FileReader
        fileReader.close();
    }
}

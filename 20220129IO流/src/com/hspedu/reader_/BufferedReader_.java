package com.hspedu.reader_;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * @ClassName BufferedReader_
 * @Description 演示BufferedReader使用
 * @Author Jing Yilin
 * @Date 2022/1/30 14:17
 * @Version 1.0
 **/
public class BufferedReader_ {
    public static void main(String[] args) throws IOException {
        /**
         * 演示BufferedReader使用
         */
        String fileName = "D:\\Test\\不要温柔的走入那良宵.txt";
        //创建BufferedReader
        BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName));
        //读取
        String line;
        //readLine()按行读取文件，如果已到达流末尾，则返回 null
        while ((line = bufferedReader.readLine()) != null) {
            System.out.println(line);
        }
        //关闭流，底层会自动关闭节点流
        bufferedReader.close();
    }
}

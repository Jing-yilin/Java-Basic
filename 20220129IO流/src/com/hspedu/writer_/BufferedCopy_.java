package com.hspedu.writer_;

import java.io.*;

/**
 * @ClassName BufferedCopy_
 * @Description TODO
 * @Author Jing Yilin
 * @Date 2022/1/30 14:33
 * @Version 1.0
 **/
public class BufferedCopy_ {
    public static void main(String[] args) throws IOException {
        String originName = "D:\\Test\\不要温柔的走入那良宵.txt";
        String targetName = "D:\\Test\\不要温柔的走入那良宵_copy.txt";
        //创建bufferedReader
        BufferedReader bufferedReader = new BufferedReader(new FileReader(originName));
        //创建bufferedWriter
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(targetName));
        //按行读取文件
        String line;
        while((line = bufferedReader.readLine())!= null){
            //按行写入
            bufferedWriter.write(line);
            //换行
            bufferedWriter.newLine();
        }
        //关闭流
        bufferedReader.close();
        bufferedWriter.close();
        System.out.println("拷贝完毕");

    }
}

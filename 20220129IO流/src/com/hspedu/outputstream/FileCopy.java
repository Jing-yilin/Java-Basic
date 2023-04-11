package com.hspedu.outputstream;

import java.io.*;

/**
 * @ClassName FileCopy
 * @Description 完成文件拷贝
 * @Author Jing Yilin
 * @Date 2022/1/29 18:53
 * @Version 1.0
 **/
@SuppressWarnings("all")
public class FileCopy {
    public static void main(String[] args) throws IOException {
        /**
         * 完成文件拷贝:
         * 将"D:\\Test\\testpic.png"拷贝到"D:\\Test\\Test2\\testpic.png""
         *
         * 思路:
         * 1.创建文件输入流，将文件读取到程旭
         * 2.创建文件的输出流，将读取到的文件数据，写入指定的文件
         */
        System.out.println("程序启动...");
        long l1 = System.currentTimeMillis();
        FileInputStream fileInputStream = null;
        FileOutputStream fileOutputStream = null;
        String originPath = "D:\\Test\\testpic.png";
        String targetPath = "D:\\Test\\Test2\\testpic.png";
        fileInputStream = new FileInputStream(originPath);
        fileOutputStream = new FileOutputStream(targetPath);
        byte[] buf = new byte[1024];//定义数组，提高读取效率
        int readLen = 0;
        while((readLen = fileInputStream.read(buf)) != -1){
            fileOutputStream.write(buf,0,readLen);
        }
        fileInputStream.close();
        fileOutputStream.close();
        long l2 = System.currentTimeMillis();
        System.out.println("拷贝完毕，用时:" + ((double)l2-l1)/1000 + "秒");

    }

}

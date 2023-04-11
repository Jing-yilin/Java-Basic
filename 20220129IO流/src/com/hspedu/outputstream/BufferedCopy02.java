package com.hspedu.outputstream;

import java.io.*;

/**
 * @ClassName BufferedCopy02
 * @Description 使用BufferedInputStream和BufferedOutputStream完成图片/音乐的拷贝
 * @Author Jing Yilin
 * @Date 2022/1/30 14:52
 * @Version 1.0
 **/
@SuppressWarnings("all")
public class BufferedCopy02 {
    public static void main(String[] args) throws IOException {
        /**
         * 使用BufferedInputStream和BufferedOutputStream完成图片/音乐的拷贝
         */
        String originName = "D:\\Test\\testpicture.png";
        String targetName = "D:\\Test\\Test2\\testpicture.png";
        //创建BufferedInputStream
        BufferedInputStream bufferedInputStream = new BufferedInputStream(new FileInputStream(originName));
        //创建BufferedOutputStream
        BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(targetName));
        byte[] bytes = new byte[1024];
        int readLen;
        while ((readLen = bufferedInputStream.read(bytes))!=-1){
            bufferedOutputStream.write(bytes,0,readLen);
        }
        //关闭处理流即可
        bufferedInputStream.close();
        bufferedOutputStream.close();
        System.out.println("拷贝完毕");
    }
}

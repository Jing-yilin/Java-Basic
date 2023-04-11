package com.hspedu.file;

import org.junit.jupiter.api.Test;

import java.io.File;

/**
 * @ClassName FileInformation
 * @Description 获取文件信息
 * @Author Jing Yilin
 * @Date 2022/1/29 16:29
 * @Version 1.0
 **/
public class FileInformation {
    public static void main(String[] args) {

    }

    @Test
    public void info() {
        //先创建文件
        File file = new File("D:\\Test\\news0.txt");

        //调用相应方法得到对应信息
        //getName()
        System.out.println("文件名字 = " + file.getName());
        //getAbsolutePath()
        System.out.println("绝对路径 = " + file.getAbsolutePath());
        //getParent()
        System.out.println("文件父目录 = " + file.getParent());
        //length()
        System.out.println("文件字节大小 = " + file.length());
        //exists()
        System.out.println("文件是否存在 = " + file.exists());//false
        //isFile()
        System.out.println("是否是个文件 = " + file.isFile());//false
        //isDirectory()
        System.out.println("是否是个目录= " + file.isDirectory());//false

    }
}

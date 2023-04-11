package com.hspedu.file;

import org.junit.jupiter.api.Test;

import java.io.*;

/**
 * @ClassName FileCreate
 * @Description 演示创建文件
 * @Author Jing Yilin
 * @Date 2022/1/29 15:46
 * @Version 1.0
 **/
public class FileCreate {
    public static void main(String[] args) {

    }

    //方式1 public File(String pathname)
    @Test
    public void create01(){
        String filePath = "D:\\Test\\news1.txt";
        File file = new File(filePath);//此时文件还在内存，不会真正产生
        try {
            file.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("文件创建成功...");
    }
    //方式2 public File(File parent, String child)  //根据父目录文件+子路径构建
    @Test
    public void create02(){
        File file = new File("D:\\Test\\");
        String fileName = "news2.txt";
        File file1 = new File(file, fileName);
        try {
            file1.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("文件创建成功...");
    }

    //方式3 public File(String parent, String child)  //根据父目录+子路径构建
    @Test
    public void create03(){
        String file = "D:\\Test\\";
        String fileName = "news3.txt";
        File file1 = new File(file, fileName);
        try {
            file1.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("文件创建成功...");
    }

}

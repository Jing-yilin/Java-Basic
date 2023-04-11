package com.hspedu.homeworks;

import java.io.File;
import java.io.IOException;

/**
 * @ClassName Homework01
 * @Description TODO
 * @Author Jing Yilin
 * @Date 2022/2/1 20:41
 * @Version 1.0
 **/
public class Homework01 {
    public static void main(String[] args) throws IOException {
        /**
         * (1) 判断D:\Test3文件夹是否存在，如果没有就创建
         * (2) 在D:\Test3文件夹内创建mytemp.txt
         */
        String directoryPath = "D:\\Test3";
        File file = new File(directoryPath);
        if (file.isDirectory() && file.exists()) {
            System.out.println("文件夹已存在！");
        } else {
            file.mkdir();
            System.out.println(directoryPath + "文件夹已经已成功创建!");
        }
        String fileName = "mytemp.txt";
        File file1 = new File(file, fileName);
        if (file1.exists()) {
            System.out.println(file1 + "已存在！");
        } else {
            file1.createNewFile();
            System.out.println(file1 + "已成功创建！");
        }
    }
}

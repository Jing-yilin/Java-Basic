package com.hspedu.file;

import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;

/**
 * @ClassName Directory_
 * @Description TODO
 * @Author Jing Yilin
 * @Date 2022/1/29 16:37
 * @Version 1.0
 **/
public class Directory_ {
    public static void main(String[] args) {

    }
    //判断 "D:\\Test\\news1.txt" 是否存在，如果存在就删除
    @Test
    public void m1(){
        String filePath = "D:\\Test\\news1.txt";
        File file = new File(filePath);
        if (file.exists()){
            if (file.delete()){
                System.out.println(filePath+" was deleted...");
            } else {
                System.out.println(filePath + " was failed to deleted...");
            }
        }else {
            System.out.println("The file does not exist...");
        }
    }

    //判断 "D:\\Test01" 是否存在，如果存在就删除
    //目录也被当做一种文件
    @Test
    public void m2(){
        String filePath = "D:\\Test01";
        File file = new File(filePath);
        try {
            file.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
        if (file.exists()){
            if (file.delete()){
                System.out.println(filePath+" was deleted...");
            } else {
                System.out.println(filePath + " was failed to deleted...");
            }
        }else {
            System.out.println("The directory does not exist...");
        }
    }

    //判断"D:\\Test01" 是否存在，如果存在就提示已经存在，如果不存在就创建
    //演示创建一级目录
    @Test
    public void m3(){
        String dirPath = "D:\\Test01\\";
        File file = new File(dirPath);

        if (file.exists()){
            System.out.println(dirPath+" already exists...");
        }else {
            if (file.mkdir()) {//创建一级目录，使用mkdir
                System.out.println(dirPath+" was created successfully...");
            } else {
                System.out.println("Unable to make this directory...");
            }
        }
    }

    //演示创建多级目录
    @Test
    public void m4(){
        String dirPath = "D:\\Test01\\a\\b\\c\\";
        File file = new File(dirPath);

        if (file.exists()){
            System.out.println(dirPath+" already exists...");
        }else {
            if (file.mkdirs()) {//创建多级目录，使用mkdir
                System.out.println(dirPath+" was created successfully...");
            } else {
                System.out.println("Unable to make this directory...");
            }
        }
    }
}

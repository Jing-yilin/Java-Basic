package com.hspedu.throws_;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

/**
 * @ClassName Throws01
 * @Description TODO
 * @Author Jing Yilin
 * @Date 2021/10/7 11:37
 * @Version 1.0
 **/
public class Throws01 {
    public static void main(String[] args) {

    }

    //public void f1() throws Exception 也可以
    public void f1() throws FileNotFoundException, NullPointerException {
        //创建了一个文件流对象
        //这里的异常是一个FileNotFoundException
        //可以使用try-catch
        //也可以使用throws，抛出异常，让调用fi方法的调用者()处理
        //throws关键字后也可以是列表
        FileInputStream fis = new FileInputStream("dd.txt");
    }
}

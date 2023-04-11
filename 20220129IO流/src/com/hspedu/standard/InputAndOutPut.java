package com.hspedu.standard;

import java.sql.SQLOutput;
import java.util.Scanner;

/**
 * @ClassName InputAndOutPut
 * @Description TODO
 * @Author Jing Yilin
 * @Date 2022/1/31 12:57
 * @Version 1.0
 **/
public class InputAndOutPut {
    public static void main(String[] args) {
        //public static final InputStream in = null;
        //System.in的编译类型是 InputStream
        //System.in的运行类型是 BufferedInputStream
        //表示的是标准输入：键盘
        System.out.println(System.in.getClass());

        //public static final PrintStream out = null;
        //System.out的编译类型是 PrintStream
        //System.out的运行类型是 PrintStream
        //表示的是标准输出：屏幕
        System.out.println(System.out.getClass());

        System.out.println("尝试System.out.println()");
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入内容：");
        String next = scanner.next();
        System.out.println("next = " + next);
    }
}

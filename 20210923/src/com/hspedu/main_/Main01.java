package com.hspedu.main_;

import com.sun.tools.javac.Main;

public class Main01 {

    //非静态
    private int n = 0;

    //静态
    private static String name = "景奕林";

    public static void main(String[] args) {
        //静态方法可以直接访问本类的静态成员
        System.out.println(Main01.name);
        //错误，不能直接访问非静态
//        System.out.println(n);
        //若要访问，必须创建一个实例
        System.out.println(new Main01().n);
    }
}

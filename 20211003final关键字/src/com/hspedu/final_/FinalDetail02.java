package com.hspedu.final_;

public class FinalDetail02 {
  public static void main(String[] args) {
    //不会导致类的加载,BBB类的静态代码块不会被执行
    System.out.println(BBB.num);

    //包装类，String是final类
  }
}

class BBB {
    public final static int num = 1000;
    static {
    System.out.println("BBB 静态代码块执行!");
    }
}
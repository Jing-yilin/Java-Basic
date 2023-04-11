package com.hspedu.reflection.classload_;

/**
 * @ClassName ClassLoad03
 * @Description TODO
 * @Author Jing Yilin
 * @Date 2022/2/9 13:52
 * @Version 1.0
 **/
public class ClassLoad03 {
    public static void main(String[] args) {
        //准备阶段
        /**
         *      num = 100;
         */
        //初始化阶段，收集静态代码，并合并
        /**
         *      clinit(){
         *          System.out.println("B 静态代码块");
         *          num = 300;
         *          num = 100;
         *      }
         *
         *      ==>合并后
         *
         *      clinit(){
         *          System.out.println("B 静态代码块");
         *          num = 100;
         *      }
         */
        B b = new B();
        //B 静态代码块
        //B构造器被执行
        System.out.println(b.num);
        //100
    }
}

class B{
    static {
        System.out.println("B 静态代码块");
        num = 300;
    }
    static int num = 100;
    public B(){
        System.out.println("B构造器被执行");
    }
}

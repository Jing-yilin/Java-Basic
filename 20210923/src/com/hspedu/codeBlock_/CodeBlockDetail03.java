package com.hspedu.codeBlock_;

public class CodeBlockDetail03 {
    /*构造器的最前面其实隐藏了super和调用普通代码块*/
    public static void main(String[] args) {
    new BBB();
    }
}

class AAA {
    {
        System.out.println("AAA的普通构造!");
    }
    public AAA(){
        //这里有几句隐藏的执行
        //（1）super();    //默认使用super

        //（2）调用普通代码块

        System.out.println("AAA() 构造器被调用!");
    }
}

class BBB extends AAA{
    {
        System.out.println("BBB的普通构造!");
    }
    public BBB(){
        //(1)super()
        //(2)调用本类的普通代码块
        System.out.println("BBB() 构造器被调用!");
    }
}

package com.hspedu.inner_class;

public class InnerClass01 {

}

class Outer {   //外部类
    //私有属性
    private int n1 = 100;
    //方法
    public void m1(){
        System.out.printf("m1");
    }
    //代码块
    {
        System.out.println("代码块……");
    }

    class Inner {   //内部类

    }
}

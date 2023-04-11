package com.hspedu.interface_;

/*
* 演示多态传递
* */

public class InterfacePolyPass {
    public static void main(String[] args) {
        //
        IG ig = new Teacher();
        //IG继承了IH接口，而Teacher类实现了IG接口
        //这就是所谓的多态传递
        IH ih = new Teacher();
    }
}

interface IH{
    void hi();
}
interface IG extends IH{}
class Teacher implements IG {
    public void hi()
    {
        System.out.println("hi!");
    }
}

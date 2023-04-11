package com.hspedu.interface_;

public class InterfaceDetail01 {
    public static void main(String[] args) {
//        接口不能被实例化
//        new IA();
    }
}


interface IA{
    //默认使用public修饰
    void say();
    void hi();
}

class Cat implements IA{//快捷键Alt+Enter

    @Override
    public void say() {

    }

    @Override
    public void hi() {

    }
}

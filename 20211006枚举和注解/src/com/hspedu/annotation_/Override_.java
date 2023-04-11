package com.hspedu.annotation_;

/**
 * @ClassName Override_
 * @Description TODO
 * @Author Jing Yilin
 * @Date 2021/10/6 13:45
 * @Version 1.0
 **/
public class Override_ {
    public static void main(String[] args) {

    }
}

class Father{
    public void fly(){
        System.out.println("Father fly!");
    }
}

class Son extends Father{
    //1.@Override 表示子类重写了父类的fly方法
    //2.如果不写@Override，还是重写了
    //3.如果写了@Override,编译器就会去检查该方法是否真的重写了父类的某个方法
    //  如果的确重写了，则编译通过，如果没有通过，则编译错误
    //4.@Override只能覆写方法
    @Override
    public void fly() {
        System.out.println("Son fly!");
    }
}

package com.hspedu.exception_;

/**
 * @ClassName ClassCastException
 * @Description TODO
 * @Author Jing Yilin
 * @Date 2021/10/7 8:12
 * @Version 1.0
 **/
public class ClassCastException_ {
    public static void main(String[] args) {
        A b = new B();//向上转型
        B b2 = (B)b;//向下转型,OK的
        C c2 = (C)b;//这里会抛出ClassCastException类型转换异常
    }
}

class A {}
class B extends A {}
class C extends B {}


package com.hspedu.wrapper;

/**
 * @ClassName Integer01
 * @Description TODO 演示 int 和 Integer的装箱和拆箱
 * @Author Jing Yilin
 * @Date 2021/10/10 10:03
 * @Version 1.0
 **/
public class Integer01 {
    public static void main(String[] args) {
        //演示int<-->Integer

        //jdk5前是手动装箱和拆箱
        //演示手动装箱
        int n1 = 100;
        Integer integer = new Integer(n1);//方法1
        Integer integer1 = Integer.valueOf(n1);//方法2
        //演示手动拆箱
        //Integer -> int
        int i = integer.intValue();

        //jdk5以后，就可以自动装箱和自动拆箱
        int n2 = 200;
        //演示自动装箱
        Integer integer2 = n2; //底层还是 new Integer(n2)
        //演示自动拆箱
        int n3 = integer2; //底层还是Integer.intValue(n3)

    }
}

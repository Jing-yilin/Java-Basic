package com.hspedu.homeworks;

/**
 * @ClassName Homework05
 * @Description TODO
 * @Author Jing Yilin
 * @Date 2021/12/7 15:29
 * @Version 1.0
 **/
public class Homework05 {
    public static void main(String[] args) {
        String s1 = "hspedu";
        Animal a =new Animal(s1);
        Animal b =new Animal(s1);
        System.out.println(a == b);//false;
        System.out.println(a.equals(b));//false //因为Animal的equals()没有重写，所以本质还是判断a == b
        System.out.println(a.name == b.name);//true

        String s4 = new String("hspedu");
        String s5 = "hspedu";

        System.out.println(s1 == s4);//false
        System.out.println(s4 == s5);//false

        String t1 = "hello" + s1;
        String t2 = "hellohs[edu";
        System.out.println(t1.intern() == t2);//true

    }
}

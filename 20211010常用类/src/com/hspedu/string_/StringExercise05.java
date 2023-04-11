package com.hspedu.string_;

import java.time.Period;

/**
 * @ClassName StringExercise05
 * @Description TODO
 * @Author Jing Yilin
 * @Date 2021/10/10 21:16
 * @Version 1.0
 **/
public class StringExercise05 {
    public static void main(String[] args) {
        Person p1 = new Person();
        p1.name = "jyl";
        Person p2 = new Person();
        p2.name = "jyl";

        System.out.println(p1.name.equals(p2.name));//T
        System.out.println(p1.name == p2.name);//T
        System.out.println(p1.name == "jyl");//T

        String s1 = new String("asd");
        String s2 = new String("asd");
        System.out.println(s1 == s2);//F
    }
}

class Person {
    public String name;
}

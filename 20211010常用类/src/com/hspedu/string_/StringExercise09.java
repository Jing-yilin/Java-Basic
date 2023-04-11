package com.hspedu.string_;

/**
 * @ClassName StringExercise09
 * @Description TODO
 * @Author Jing Yilin
 * @Date 2021/10/11 21:21
 * @Version 1.0
 **/
public class StringExercise09 {
    public static void main(String[] args) {
        String s1 = "jyl";//指向池中的"jyl"
        String s2 = "java";//指向池中的"java"
        String s5 = "jyljava";//指向池中的"jyljava"
        String s6 = (s1+s2).intern();//指向池中的"jyljava"
        System.out.println(s5 == s6);//T
        System.out.println(s5.equals(s6));//T
    }
}

package com.hspedu.string_;

/**
 * @ClassName StringExercise03
 * @Description TODO
 * @Author Jing Yilin
 * @Date 2021/10/10 20:56
 * @Version 1.0
 **/
public class StringExercise03 {
    public static void main(String[] args) {
        String a = "jyl";//指向常量池的"jyl"
        String b = new String("jyl");//b指向堆中的对象
        System.out.println(a.equals(b));//true
        System.out.println(a == b);//false
        //当调用intern()方法，如果池中已经包含等于此String字符串(用equal(Object)方法确定)
        //则返回池中的字符串。否则，将此String对象添加到池中，并返回String对象的引用
        //解读：b.intern()在这里返回了常量池里"jyl"的地址
        System.out.println(a == b.intern());//true
        System.out.println(b == b.intern());//false
    }
}

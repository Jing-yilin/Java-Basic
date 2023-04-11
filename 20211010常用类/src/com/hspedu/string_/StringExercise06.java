package com.hspedu.string_;

/**
 * @ClassName StringExercise06
 * @Description TODO
 * @Author Jing Yilin
 * @Date 2021/10/10 21:28
 * @Version 1.0
 **/
@SuppressWarnings("all")
public class StringExercise06 {
    public static void main(String[] args) {
        String s1 = "hello";
        s1 = "haha";
        //以上一共创建了2个对象

        System.out.println("-------分割线------");

        String a = "wo" + "aini";
        //编译器会优化==>等价于 String a = "woaoni"
        //以上一共创建了1个对象

        String b = "hello";
        String c = "abs";
        String d = a+b;
        //以上创建了3个对象

    }
}

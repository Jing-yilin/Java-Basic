package com.hspedu.string_;

/**
 * @ClassName StringExercise08
 * @Description TODO
 * @Author Jing Yilin
 * @Date 2021/10/11 21:04
 * @Version 1.0
 **/
public class StringExercise08 {
    public static void main(String[] args) {
        String a = "hello";
        String b = "abc";
        //先创建一个StringBuilder sb = new StringBuilder()
        //执行 sb.append("hello");
        //    sb.append("abc");
        //    String s = sb.toString()
        //    最后其实是c指向堆中的对象(String) value[] -> 池中的 "helloabc"
        String c = a+b;//一共创建了几个对象呢？ 3个。

    }


}

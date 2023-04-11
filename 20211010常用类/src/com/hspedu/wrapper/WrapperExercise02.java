package com.hspedu.wrapper;

/**
 * @ClassName WrapperExercise02
 * @Description TODO
 * @Author Jing Yilin
 * @Date 2021/10/10 18:22
 * @Version 1.0
 **/
@SuppressWarnings("all")
public class WrapperExercise02 {
    public static void main(String[] args) {
        Integer i = new Integer(1);
        Integer j = new Integer(1);
        System.out.println(i == j);//判断是否是同一个对象，自然不等//false
        System.out.println(i.equals(j));//true

        System.out.println("============================");

        //如果右侧的值在[-128, 127]区间内，返回已有的对象
        Integer m = 1;//底层Integer.valueOf(1)
        Integer n = 1;//底层Integer.valueOf(1)
        System.out.println(m == n);//true
        System.out.println(m.equals(n));//true

        System.out.println("============================");

        Integer x = 128;//底层new Integer(128)
        Integer y = 128;//底层new Integer(128)
        System.out.println(x == y);//false
        System.out.println(x.equals(y));//true
    }
}

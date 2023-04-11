package com.hspedu.wrapper;

/**
 * @ClassName WrapperExercise
 * @Description TODO
 * @Author Jing Yilin
 * @Date 2021/10/10 10:12
 * @Version 1.0
 **/
@SuppressWarnings("all")
public class WrapperExercise {
    public static void main(String[] args) {
        Double d = 100d;//自动装箱
        Float f = 1.5f;//自动装箱
//        System.out.println(d);

        //三元运算符是一个整体,1的精度会被提升到1.0
        Object obj1 = true? new Integer(1): new Double(2.0);
        System.out.println(obj1);//1.0

        Object obj2;
         if (true)
             obj2 = new Integer(1);
         else
             obj2 =new Double(2.0);
        System.out.println(obj2);//1

    }
}

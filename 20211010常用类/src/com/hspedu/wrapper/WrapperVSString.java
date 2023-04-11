package com.hspedu.wrapper;

/**
 * @ClassName WrapperVSString
 * @Description TODO 演示包装类型和String的相互转换
 * @Author Jing Yilin
 * @Date 2021/10/10 10:21
 * @Version 1.0
 **/
public class WrapperVSString {
    public static void main(String[] args) {
        //包装类(Integer) --> String
        Integer i = 100;
        //方式1
        String str1 = i + "";//对原先的i没有影响
        //方式2
        String str2 = i.toString();//包装类的通用方法
        //方式3
        String str3 = String.valueOf(i);

        //String --> 包装类
        String str4 = "12345";
        //方式1
        Integer i2 = Integer.parseInt(str4);//使用到自动装箱
        //方式2
        Integer i3 = new Integer(str4);//使用构造器

        System.out.printf("OK!");


    }
}

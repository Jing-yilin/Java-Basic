package com.hspedu.string_;

/**
 * @ClassName StringMethod01
 * @Description TODO
 * @Author Jing Yilin
 * @Date 2021/10/11 22:09
 * @Version 1.0
 **/
public class StringMethod01 {
    public static void main(String[] args) {
        //1.equals()
        String str1 = "hello";
        String str2 = "Hello";
        System.out.println(str1.equals(str2));
        //2.equalsIgnoreCase() 忽略大小写
        System.out.println(str1.equalsIgnoreCase(str2));
        //3.length()
        System.out.println(str1.length());
        //4.indexOf() 获取字符(也可以是子字符串)在字符串对象中第一次出现的位置，返回第一个字符的下标
        // 找不到则返回-1
        System.out.println(str1.indexOf('l'));
        System.out.println(str1.indexOf("el"));
        //5.lastIndexOf() 获取字符在字符串对象中最后一次出现的位置，找不到则返回-1
        System.out.println(str1.lastIndexOf('l'));
        //5.substring() 截取指定范围的子串
        System.out.println(str1.substring(2));//从索引2开始截取所有//llo
        System.out.println(str1.substring(2, 4));//截取到3//ll

    }
}

package com.hspedu.homeworks;

import java.util.TreeSet;

/**
 * @ClassName Homework05
 * @Description TODO
 * @Author Jing Yilin
 * @Date 2022/1/19 19:46
 * @Version 1.0
 **/
@SuppressWarnings("all")
public class Homework05 {
    public static void main(String[] args) {
        TreeSet treeSet = new TreeSet();
        treeSet.add(new Person());

        //会出现异常吗？

        //答案：会。因为TreeSet没有传入Comparator接口的匿名内部类
        //所以底层 Comparable<? super K> k = (Comparable<? super K>) key;
        //需要把Person对象转换成Comparable接口类型
    }
}

class Person implements Comparable{
    @Override
    public int compareTo(Object o) {
        return 0;
    }
}

//class Person{ }


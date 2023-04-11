package com.hspedu.collection_;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @ClassName CollectionExercise
 * @Description TODO
 * @Author Jing Yilin
 * @Date 2021/12/7 23:34
 * @Version 1.0
 **/
public class CollectionExercise {
    public static void main(String[] args) {
        /*
        * 1.创建3个Dog{name,age}对象，放入到ArrayList中，赋给List引用
        * 2.用迭代器和增强for循环两种方式来遍历
        * 3.重写Dog 的toString方法，输出name和age
        * */

        List list = new ArrayList();
        list.add(new Dog("小黄", "13"));
        list.add(new Dog("小绿", "2"));
        list.add(new Dog("小蓝", "7"));

        //使用增强for
        for (Object dog :list) {
            System.out.println("dog = " + dog);
        }

        //使用迭代器
        Iterator iterator = list.iterator();
        while (iterator.hasNext()) {
            Object dog =  iterator.next();
            System.out.println("dog = " + dog);
        }

    }
}

class Dog
{
    String name;
    String Age;

    public Dog(String name, String age) {
        this.name = name;
        Age = age;
    }

    @Override
    public String toString() {
        return "Dog{" +
                "name='" + name + '\'' +
                ", Age='" + Age + '\'' +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return Age;
    }

    public void setAge(String age) {
        Age = age;
    }
}

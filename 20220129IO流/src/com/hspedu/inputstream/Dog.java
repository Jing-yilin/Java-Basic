package com.hspedu.inputstream;

import java.io.Serializable;

/**
 * @ClassName Dog
 * @Description TODO
 * @Author Jing Yilin
 * @Date 2022/1/31 12:35
 * @Version 1.0
 **/
public class Dog implements Serializable {
    private String name;
    private int age;

    public Dog(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Dog{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
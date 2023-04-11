package com.hspedu;

/**
 * @ClassName Cat
 * @Description TODO
 * @Author Jing Yilin
 * @Date 2022/2/9 10:29
 * @Version 1.0
 **/
public class Cat {
    private String name = "喵喵";
    public int age = 10;

    public Cat(){

    }

    public Cat(int age) {
        this.age = age;
    }

    public Cat(String name) {
        this.name = name;
    }

    public Cat(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public void hi() {
        System.out.println("你好，我是" + name);
    }

    public void addAge(){
        age++;
    }
}

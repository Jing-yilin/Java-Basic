package com.hspedu.homework;

/**
 * @ClassName Homework03
 * @Description TODO
 * @Author Jing Yilin
 * @Date 2021/10/6 22:38
 * @Version 1.0
 **/
public class Homework03 {
    public static void main(String[] args) {
        Cat cat = new Cat();
        Dog dog = new Dog();

        cat.shout();
        dog.shout();
    }
}

abstract class Animal{
    abstract void shout();
}

class Cat extends Animal{
    @Override
    void shout() {
        System.out.println("猫会喵喵叫");
    }
}

class Dog extends Animal{
    @Override
    void shout() {
        System.out.println("狗会汪汪叫");
    }
}
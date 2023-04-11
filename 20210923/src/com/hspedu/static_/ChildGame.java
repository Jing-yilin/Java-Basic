package com.hspedu.static_;

public class ChildGame {

    public static void main(String[] args) {

        Child child1 = new Child("Jack");
        Child child2 = new Child("Mike");
        Child child3 = new Child("Lisa");

        System.out.println("一共有" +Child.counter+"个小孩加入了游戏！");
    }
}

class Child {
    private String name;
    //使用static静态变量（也叫类变量）记录
    //他被所有实例共享
    public static int counter = 0;

    public Child(String name){
        this.name = name;
        counter++;
        System.out.println("现在一共有" + counter+ "人！");
    }

    public void join() {
        System.out.println(this.name + "加入了游戏!");
    }
}

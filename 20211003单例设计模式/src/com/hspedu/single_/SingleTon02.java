package com.hspedu.single_;

/*
* 演示懒汉式的单例模式
* */

import jdk.dynalink.beans.StaticClass;

import java.util.PrimitiveIterator;

public class SingleTon02 {
  public static void main(String[] args) {
    //
    Cat instance = Cat.getInstance();
    System.out.println(instance);
//    System.out.println(Cat.n1);
  }
}

class Cat {
  private String name;
  public static int n1 = 999;
  private static Cat cat;

  private Cat (String name){
    System.out.printf("构造器被调用!\n");
    this.name = name;
  }

  //存在线程安全问题！可能会有多线程同时进入这个函数
  public static Cat getInstance() {
    //可能会有多个线程同时进入这个判断
    if (cat == null) {
      cat = new Cat("红茶");
    }
    return cat;
  }

  @Override
  public String toString() {
    return "Cat{" +
            "name='" + name + '\'' +
            '}';
  }
}


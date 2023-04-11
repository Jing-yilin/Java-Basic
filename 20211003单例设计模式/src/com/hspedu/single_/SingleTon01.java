package com.hspedu.single_;


/*
 * 演示饿汉式的单例模式
 * 饿汉式存在浪费对象的风险
 * */

public class SingleTon01 {
  public static void main(String[] args) {
      GirlFriend instance = GirlFriend.getInstance();
      System.out.println(instance);
  }
}


//有一个类 GirlFriend

class GirlFriend{
    private String name;

    /* java中构造方法可以有任何访问的修饰符，
    public、private、protected或者没有修饰符 ，都可以对构造方法进行修饰
    不同于实例方法的是构造方法不能有任何非访问性质的修饰符修饰，
    例如static、final、synchronized、abstract等都不能修饰构造方法。*/
    //私有化构造对象
    private GirlFriend(String name) {
        this.name = name;
    }
    //在类中直接创建一个对象,为了能在静态方法中调用，需要static
    private static GirlFriend cx = new GirlFriend("程隰");

    public static GirlFriend getInstance(){
        return cx;
    }

    @Override
    public String toString() {
        return "GirlFriend{" +
                "name='" + name + '\'' +
                '}';
    }
}
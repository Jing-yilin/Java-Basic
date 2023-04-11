package com.hspedu.interface_;

public class InterfacePolyParameter {
    public static void main(String[] args) {

        IF if01 = new Monster();
        if01 = new Car();
        //不能使用实现类中的属性，只能用接口里的属性
        System.out.println(if01.x);

        //使用向下转型
        ((Car) if01).cry();
        System.out.println(((Car) if01).i);


        Monster dudu = new Dudu();
        System.out.println(dudu.myId);
    }
}

interface IF{
    int x = 10;
}
class Monster implements IF{
    public int myId = 1;
}
class Car implements IF{
    public static int i = 10;
    public void cry(){
        System.out.println("cry");
    }
}
class Dudu extends Monster{

}
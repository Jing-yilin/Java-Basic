package com.hspedu.interface_;

public interface AInterface {
    //属性
    public int n1 = 10;

    //方法,默认是抽象的
    //在接口中，抽象方法可以省略abstract关键字
    public void hi();

    //jdk8以后，可以有默认方法，需要default修饰
    default public void ok(){
        System.out.println("ok!");
    }

    //jdk8以后，可以有静态方法
    public static void cry(){
        System.out.println("cry!");
    }
}

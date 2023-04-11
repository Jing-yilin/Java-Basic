package com.hspedu.customgeneric;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName GenericExtends
 * @Description TODO 泛型的继承和通配符
 * @Author Jing Yilin
 * @Date 2022/1/20 14:16
 * @Version 1.0
 **/
public class GenericExtends {
    public static void main(String[] args) {
        Object o = new String("xx");//多态的体现，没有问题

        //但是泛型没有继承，不能这么写
        //ArrayList<Object> strings = new ArrayList<String>();//错误

        ArrayList<Object> list1 = new ArrayList<>();
        ArrayList<String> list2 = new ArrayList<>();
        ArrayList<AA> list3 = new ArrayList<>();
        ArrayList<BB> list4 = new ArrayList<>();
        ArrayList<CC> list5 = new ArrayList<>();

        //如果是 List<?> c,可以接受任意泛型
        printCollection1(list1);
        printCollection1(list2);
        printCollection1(list3);
        printCollection1(list4);
        printCollection1(list5);

        //如果是 List<? extends AA> c,可以接受AA以及其子类
        //printCollection2(list1);//错误
        //printCollection2(list2);//错误
        printCollection2(list3);
        printCollection2(list4);
        printCollection2(list5);

        //如果是 List<? super BB> c,可以BB及其所有父类,不限于直接父类
        printCollection3(list1);
        //printCollection3(list2);//错误
        printCollection3(list3);
        printCollection3(list4);
        //printCollection3(list5);//错误
    }

    //演示<?>，支持任意泛型
    public static void printCollection1 (List<?> c) {
        for(Object object: c) {
            System.out.println(object);
        }
    }

    // ? extends AA 表示上限，可以接受 AA 或者 AA的子类
    public static void printCollection2 (List<? extends AA> c){
        for(Object object: c) {
            System.out.println(object);
        }
    }

    // ? extends BB 表示上限，可以接受 BB 或者 bb的父类
    public static void printCollection3 (List<? super BB> c){
        for(Object object: c) {
            System.out.println(object);
        }
    }
}

class AA {

}

class BB extends AA {

}

class CC extends BB {

}

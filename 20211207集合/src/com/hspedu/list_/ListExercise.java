package com.hspedu.list_;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @ClassName ListExercise
 * @Description TODO
 * @Author Jing Yilin
 * @Date 2021/12/8 8:06
 * @Version 1.0
 **/
public class ListExercise {
    public static void main(String[] args) {
        List list = new ArrayList();
        list.add("Infinity");
        list.add("The Temple Of The King");
        list.add("Pigs");
        list.add("Vetelgyus");
        list.add("Til Death Do Us Part");
        list.add("You Really Got Me");
        list.add("Longing");
        System.out.println("list = " + list);
        list.add(1,"突然的自我");
        System.out.println("list = " + list);
        System.out.println("list.get(4) = " + list.get(4));
        list.remove(5);
        System.out.println("list = " + list);
        list.set(6,"你与我");
        System.out.println("list = " + list);

        //使用迭代器输出
        Iterator iterator = list.iterator();
        while (iterator.hasNext()) {
            Object song =  iterator.next();
            System.out.println("song = " + song);
        }
    }
}

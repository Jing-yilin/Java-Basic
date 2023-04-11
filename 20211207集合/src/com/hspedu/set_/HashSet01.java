package com.hspedu.set_;

import com.hspedu.set_.Dog1;

import java.util.HashSet;

/**
 * @ClassName HashSet01
 * @Description TODO
 * @Author Jing Yilin
 * @Date 2021/12/15 23:40
 * @Version 1.0
 **/
public class HashSet01 {
    @SuppressWarnings("all")
    public static void main(String[] args) {
//        HashSet set = new HashSet();
//        System.out.println(set.add("john"));//true
//        System.out.println(set.add("lucy"));//true
//        System.out.println(set.add("john"));//false
//        System.out.println(set.add("jack"));//true
//        System.out.println(set.add("rose"));//true
//        set.remove("john");
//        System.out.println("set = " + set);

        HashSet set = new HashSet();
        set.add("lucy");
        set.add("lucy");//加入不了
        set.add(new Dog1("tom"));
        set.add(new Dog1("tom"));
        set.add(10);
        set.add(10);//加入不了
        set.add(new Integer(10));//加入不了
        set.add(new Integer(10));//加入不了
        set.add(new String("haha"));
        set.add(new String("haha"));//加入不了

        System.out.println("set = " + set);
        //set = [com.hspedu.set_.Dog1@776ec8df, haha, 10, com.hspedu.set_.Dog1@4eec7777, lucy]
    }
}

class Dog1{
    String name;
    Dog1(String name)
    {
        this.name = name;
    }
}

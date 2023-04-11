package com.hspedu.map_;

import java.util.HashMap;
import java.util.Hashtable;

/**
 * @ClassName HashTableExercise
 * @Description TODO
 * @Author Jing Yilin
 * @Date 2022/1/19 13:03
 * @Version 1.0
 **/
@SuppressWarnings("all")
public class HashTableExercise {
    public static void main(String[] args) {
        Hashtable table = new Hashtable();
//        table.put("john", 100);//ok
////        table.put(null, 100);//空指针异常
//        //Exception in thread "main" java.lang.NullPointerException:
//        //Cannot invoke "Object.hashCode()" because "key" is null
////        table.put("john", null);//
//        //Exception in thread "main" java.lang.NullPointerException
//        table.put("lic", 100);//ok
//        table.put("lic", 88);//替换
////        System.out.println(table);//{john=100, lic=88}
//
//        //扩容机制
//        table.put("Hello1", 1);
//        table.put("Hello2", 1);
//        table.put("Hello3", 1);
//        table.put("Hello4", 1);
//        table.put("Hello5", 1);
//        table.put("Hello6", 1);
//        table.put("Hello7", 1);

        for (int i = 0; i < 10; i++) {
            table.put(new Hello(), 1);
        }
    }
}

class Hello {
    Hello(){};

    @Override
    public int hashCode() {
        return 100;
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }
}

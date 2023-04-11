package com.hspedu.list_;

import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.Vector;
import java.util.function.Consumer;

/**
 * @ClassName Vector_
 * @Description TODO
 * @Author Jing Yilin
 * @Date 2021/12/13 23:36
 * @Version 1.0
 **/
public class Vector_ {
    public static void main(String[] args) {
        Vector vector = new Vector();
        for (int i = 1; i <= 11; i++) {
            vector.add(i);
        }
        vector.add(100);
        vector.add(200);

        //遍历方法1，使用forEach()方法，ArrayList也有
        vector.forEach(new Consumer() {
            @Override
            public void accept(Object o) {
                System.out.println(o);
            }
        });

        //遍历方法2，使用Enumeration接口
        Enumeration enumeration = vector.elements();
        while(enumeration.hasMoreElements())
        {
            System.out.println(enumeration.nextElement());
        }

        //遍历方法3，增强for循环
        for (Object o :vector) {
            System.out.println(o);
        }

        //遍历方法4，使用Iterator迭代器
        Iterator iterator = vector.iterator();
        while (iterator.hasNext()) {
            Object next =  iterator.next();
            System.out.println(next);
        }


//        vector.elementAt(10);
//        vector.get(10);

//        ArrayList list = new ArrayList();
//        list.get(10);
    }
}

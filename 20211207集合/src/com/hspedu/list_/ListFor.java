package com.hspedu.list_;

import java.util.*;

/**
 * @ClassName ListFor
 * @Description TODO 演示List的三种遍历方式
 * @Author Jing Yilin
 * @Date 2021/12/8 8:15
 * @Version 1.0
 **/
public class ListFor {
    public static void main(String[] args) {
        List list = new Vector();
        list.add("Infinity");
        list.add("The Temple Of The King");
        list.add("Pigs");
        list.add("Vetelgyus");

        //方式1：使用迭代器
        Iterator iterator = list.iterator();
        while (iterator.hasNext()) {
            Object next =  iterator.next();
        }

        //方式2：使用增强for
        for (Object o :list) {
        }

        //方式3：使用普通for
        for (int i = 0; i < list.size(); i++) {
            Object o = list.get(i);
        }

    }
}

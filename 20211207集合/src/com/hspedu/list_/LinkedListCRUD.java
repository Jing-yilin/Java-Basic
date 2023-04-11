package com.hspedu.list_;

import java.util.Enumeration;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.function.Consumer;

/**
 * @ClassName LinkedListCRUD
 * @Description TODO
 * @Author Jing Yilin
 * @Date 2021/12/15 19:59
 * @Version 1.0
 **/
public class LinkedListCRUD {
    public static void main(String[] args) {
        LinkedList linkedList = new LinkedList();
       // System.out.println("linkedList.getLast() = " + linkedList.getLast());
        // Exception in thread "main" java.util.NoSuchElementException

        //演示添加节点
        linkedList.add(1);
        linkedList.add(2);
        linkedList.add(3);
        linkedList.add(4);
        linkedList.add(5);
        linkedList.add(6);
        System.out.println("linkedList = " + linkedList);

        //演示删除结点
        //初始链表：linkedList = [1, 2, 3, 4, 5, 6]
        linkedList.remove();
        //linkedList = [2, 3, 4, 5, 6]
        System.out.println("linkedList = " + linkedList);

        //演示修改
        //linkedList = [2, 3, 4, 5, 6]
        linkedList.set(1,999);
        //linkedList = [2, 999, 4, 5, 6]
        System.out.println("linkedList = " + linkedList);

        //遍历方式
        //方法一
        linkedList.forEach(new Consumer() {
            @Override
            public void accept(Object o) {
                System.out.println(o);
            }
        });

        //方法二
        for (Object o:linkedList) {
            System.out.println(o);
        }

        //方法三
        Iterator iterator = linkedList.iterator();
        while (iterator.hasNext()) {
            Object next =  iterator.next();
            System.out.println(next);
        }

        //方法四
        for (int i = 0; i < linkedList.size(); i++) {
            System.out.println(linkedList.get(i));
        }





    }
}

package com.hspedu.collection_;

import java.util.ArrayList;
import java.util.Collection;

/**
 * @ClassName CollectionFor
 * @Description TODO
 * @Author Jing Yilin
 * @Date 2021/12/7 23:26
 * @Version 1.0
 **/
public class CollectionFor {
    public static void main(String[] args) {
        Collection col = new ArrayList();
        col.add(new Book("三国演义","罗贯中",10.1));
        col.add(new Book("小李飞刀","古龙",5.1));
        col.add(new Book("红楼梦","曹雪芹",34.6));

        //使用增强for循环
        //底层任然是迭代器
        //可以理解成简化版的迭代器
        //快捷方式：I
        for(Object book : col) {
            System.out.println("book = " + book);
        }
    }
}

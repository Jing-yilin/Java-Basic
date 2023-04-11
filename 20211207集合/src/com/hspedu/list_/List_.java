package com.hspedu.list_;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName List_
 * @Description TODO
 * @Author Jing Yilin
 * @Date 2021/12/7 23:49
 * @Version 1.0
 **/
public class List_ {
    public static void main(String[] args) {
        //1. List集合中元素有序（添加顺序和取出顺序一致），且可重复
        List list = new ArrayList();
        list.add("jack");
        list.add("tom");
        list.add("mary");
        list.add("jyl");
        list.add("tom");
        System.out.println("list = " + list);
        //2. List集合中每个元素都有其对应的顺序索引
        System.out.println("list.get(3) = " + list.get(3));
        //
    }
}

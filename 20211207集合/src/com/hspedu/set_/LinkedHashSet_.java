package com.hspedu.set_;

import java.util.LinkedHashSet;

/**
 * @ClassName LinkedHashSet_
 * @Description TODO
 * @Author Jing Yilin
 * @Date 2021/12/20 18:57
 * @Version 1.0
 **/
@SuppressWarnings("all")
public class LinkedHashSet_ {
    public static void main(String[] args) {
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        linkedHashSet.add("java");
        linkedHashSet.add("python");
        linkedHashSet.add("java");
        linkedHashSet.add("C");
        linkedHashSet.add("C++");
        linkedHashSet.add("javascript");
        linkedHashSet.remove("python");
        //可以发现LinkedHashSet是有序的，插入顺序和输出顺序一致

        for (Object next : linkedHashSet) {
            System.out.println(next);
        }
    }
}

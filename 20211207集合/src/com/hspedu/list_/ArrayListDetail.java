package com.hspedu.list_;

import java.util.ArrayList;

/**
 * @ClassName ArrayListDetail
 * @Description TODO
 * @Author Jing Yilin
 * @Date 2021/12/8 8:34
 * @Version 1.0
 **/
public class ArrayListDetail {
    public static void main(String[] args) {
        //ArrayList允许加入所有的类，甚至可以加入null
        //ArrayList是由数组来实现的
        //ArrayList基本等同于Vector，但是ArrayList是线程不安全的（效率更高）
        //在多线程的情况下，建议使用Vector
        //看源码没有synchronized（线程互斥）修饰
        /*public boolean add(E e) {
                modCount++;
                add(e, elementData, size);
                return true;
        }
         */
        ArrayList arrayList = new ArrayList();
        arrayList.add(null);
        arrayList.add("jack");
        arrayList.add(null);
        System.out.println(arrayList);//[null, jack, null]
    }
}

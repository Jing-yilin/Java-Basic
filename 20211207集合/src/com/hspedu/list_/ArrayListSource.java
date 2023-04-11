package com.hspedu.list_;

import java.util.ArrayList;

/**
 * @ClassName ArrayListSource
 * @Description TODO https://www.bilibili.com/video/BV1fh411y7R8?p=510&t=478.0
 * @Author Jing Yilin
 * @Date 2021/12/8 8:43
 * @Version 1.0
 **/
@SuppressWarnings("all")
public class ArrayListSource {
    //ArrayList的底层机制和源码分析
    public static void main(String[] args) {
        //先说结论
        //ArrayList中维护了一个Object类型的数组elementData
        //transient Object[] elementData

        //使用无参构造器创建ArrayList对象
//        ArrayList list = new ArrayList();
        ArrayList list = new ArrayList(8);
        //使用for循环给list添加1-10数据
        for (int i = 1; i <= 10; i++) {
            list.add(i);
        }
        //使用for循环给list添加11-15数据
        for (int i = 11; i <= 15; i++) {
            list.add(i);
        }
        list.add(100);
        list.add(200);

    }
}

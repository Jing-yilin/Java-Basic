package com.hspedu.set_;

import java.util.Comparator;
import java.util.TreeSet;

/**
 * @ClassName TreeSet_
 * @Description TODO
 * @Author Jing Yilin
 * @Date 2022/1/19 15:48
 * @Version 1.0
 **/
@SuppressWarnings("all")
public class TreeSet_ {
    public static void main(String[] args) {
//        TreeSet treeSet = new TreeSet()
        TreeSet treeSet = new TreeSet(new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                //转换成String类型进行比较
                return (((String)o1).compareTo((String) o2));
            }
        });
        //添加数据
        treeSet.add("jack");
        treeSet.add("tom");
        treeSet.add("bc");
        treeSet.add("ab");
//        treeSet.add("程隰");
//        treeSet.add("景奕林");

        //不做处理的话TreeSet也是无序的
        System.out.println(treeSet);//[jack, tom, 景奕林, 程隰]


    }
}

package com.hspedu.collection_;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName CollectionMethod
 * @Description TODO
 * @Author Jing Yilin
 * @Date 2021/12/7 22:46
 * @Version 1.0
 **/
public class CollectionMethod {
    public static void main(String[] args) {
        //用Collection的实例ArrayList来演示
        List list = new ArrayList();
//        add:添加单个元素,放Object
        list.add("Jack");
        list.add(10);//会自动装箱,相当于list.add(new Integer(10))
        list.add(true);
        System.out.println("list = " + list);
//        remove:删除指定的元素（被重载了的）
        //list.remove(0);//删除第一个元素
        list.remove(true);//删除指定元素
        System.out.println("list = " + list);
//        contains:查找元素是否存在
        System.out.println("list.contains(10) = " + list.contains(10));
//        size:获取元素个数
        System.out.println("list.size() = " + list.size());
//        isEmpty:判断是否为空
        System.out.println("list.isEmpty() = " + list.isEmpty());
//        clear:清空
        //list.clear();
        System.out.println("list = " + list);
//        addAll:添加多个元素,传入集合
        ArrayList list1 = new ArrayList();
        list1.add("红楼梦");
        list1.add("三国演义");
        list.addAll(list1);
        System.out.println("list = " + list);
//        containsAll:查找多个元素是否都在
        System.out.println("list.containsAll(list1) = " + list.containsAll(list1));
//        removeAll:删除多个元素
        list.removeAll(list1);
        System.out.println("list = " + list);
//        说明：以ArrayList演示Collection的方法
    }
}

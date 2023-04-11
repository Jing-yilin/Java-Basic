package com.hspedu.list_;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName ListMethod
 * @Description TODO https://www.bilibili.com/video/BV1fh411y7R8?p=505&spm_id_from=pageDriver
 * @Author Jing Yilin
 * @Date 2021/12/7 23:55
 * @Version 1.0
 **/
public class ListMethod {
    @SuppressWarnings("all")
    public static void main(String[] args) {
        List list = new ArrayList();
        list.add("X Japan");
        list.add("Galneryus");

//        void add(int index, Object ele):再index得位置插入ele元素
        list.add(1, "SYU");
        System.out.println("list = " + list);//list = [X Japan, SYU, Galneryus]
//        addAll(int index, Collection eles):从index位置将eles中的所有元素加进来
        List list2 = new ArrayList();
        list2.add("Yoshiki");
        list2.add("Hide");
        list.addAll(1, list2);
        System.out.println("list = " + list);//list = [X Japan, Yoshiki, Hide, SYU, Galneryus]
//        Object get(int index):获取指定index位置的元素
//        int indexOf(Object obj):返回obj首次在集合中出现的位置
        System.out.println("list.indexOf(\"SYU\") = " + list.indexOf("SYU"));//list.indexOf("SYU") = 3
//        int lastIndexOf(Object obj):返回obj在集合中最后出现的位置
        System.out.println("list.lastIndexOf(\"Hide\") = " + list.lastIndexOf("Hide"));//list.lastIndexOf("Hide") = 2
//        Object remove(int index):移除指定位置的元素
        list.remove(0);
        System.out.println("list = " + list);//list = [Yoshiki, Hide, SYU, Galneryus]
//        Object set(int index, Object ele):设置指定index位置的元素为ele,相当于替换
        list.set(1, "Pata");
        System.out.println("list = " + list);//list = [Yoshiki, Pata, SYU, Galneryus]
//        List subList(int fromIndex, int toIndex):返回从fromIndex到toIndex-1的子集合
        List subList = list.subList(0, 2);
        System.out.println("subList = " + subList);//subList = [Yoshiki, Pata]
    }
}

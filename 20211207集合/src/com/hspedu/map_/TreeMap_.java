package com.hspedu.map_;

import java.util.Comparator;
import java.util.TreeMap;

/**
 * @ClassName TreeMap_
 * @Description TODO
 * @Author Jing Yilin
 * @Date 2022/1/19 16:19
 * @Version 1.0
 **/
@SuppressWarnings("all")
public class TreeMap_ {
    public static void main(String[] args) {

//        //使用默认构造器创建TreeMap,输出其实是无序的
//        TreeMap treeMap = new TreeMap();
//        treeMap.put("cilixx", "程隰");
//        treeMap.put("zephyr", "景奕林");
//        treeMap.put("jane", "简");
//        treeMap.put("john", "强");
//
//        System.out.println("TreeMap = " + treeMap);
//        //TreeMap = {cilixx=程隰, jane=简, john=强, zephyr=景奕林}

        //传入构造器
        TreeMap treeMap = new TreeMap(new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                //按照传入的字符串的大小进行排序
                return ((String)o1).compareTo((String)o2);
            }
        });
        treeMap.put(null, null);
        treeMap.put("cilixx", "程隰");
        treeMap.put("zephyr", "景奕林");
        treeMap.put("jane", "简");
        treeMap.put("john", "强");
        treeMap.put("abba", "阿巴乐队");
        treeMap.put("GNR", "枪花乐队");

        System.out.println("TreeMap = " + treeMap);
//        TreeMap = {GNR=枪花乐队, abba=阿巴乐队, cilixx=程隰, jane=简, john=强, zephyr=景奕林}


    }
}

package com.hspedu.map_;

import java.util.*;

@SuppressWarnings("all")
/**
 * @ClassName MapSource_
 * @Description TODO
 * @Author Jing Yilin
 * @Date 2021/12/21 13:26
 * @Version 1.0
 **/
public class MapSource_ {
    public static void main(String[] args) {
        Map map = new HashMap();
        map.put("no1", "景奕林");
        map.put("no2", "景风眠");
        map.put("no3", new Person());
        map.put("no4", new Person());
        map.put("no5", new Clock());
        map.put("no6", new Clock());


        Set set = map.entrySet();
        Collection values = map.values();


//        System.out.println(set.getClass());//class java.util.HashMap$EntrySet
        for (Object obj: set)
        {
//            System.out.println(entry.getClass());//class java.util.HashMap$Node
            Map.Entry entry = (Map.Entry) obj;//向上转型
            System.out.println(entry.getKey() + "-" + entry.getValue());
        }

    }
}

class Person{
    public Person() {
    }
}
class Clock{
    public Clock() {
    }
}

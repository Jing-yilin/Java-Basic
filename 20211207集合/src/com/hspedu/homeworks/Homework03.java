package com.hspedu.homeworks;

import java.util.*;

/**
 * @ClassName Homework03
 * @Description TODO
 * @Author Jing Yilin
 * @Date 2022/1/19 19:20
 * @Version 1.0
 *
*/
@SuppressWarnings("all")
public class Homework03 {
    public static void main(String[] args) {
        Map m = new HashMap();
        m.put("jack", 650);
        m.put("tom", 1200);
        m.put("smith", 2900);

        m.put("jack", 2600);

        Set set = m.keySet();
        Iterator iterator = set.iterator();
        while (iterator.hasNext()) {
            String next =  (String)iterator.next();
            m.put(next, (Integer)m.get(next)+100);
        }
        Iterator iterator1 = m.keySet().iterator();
        while (iterator1.hasNext()) {
            Object next = iterator1.next();
            System.out.println(next);
        }

        Collection values = m.values();
        for (Object x:values) {
            System.out.println(x);
        }

        Set entrySet = m.entrySet();
        Iterator iterator2 = entrySet.iterator();
        while (iterator2.hasNext()) {
            Map.Entry entry = (Map.Entry)iterator2.next();
            System.out.println(entry.getKey() + "-" + entry.getValue());
        }

//        tom-1300
//        smith-3000
//        jack-2700
    }
}

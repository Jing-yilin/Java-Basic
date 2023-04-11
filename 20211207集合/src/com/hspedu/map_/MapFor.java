package com.hspedu.map_;

import java.util.*;

@SuppressWarnings("all")
/**
 * @ClassName MapFor
 * @Description TODO 演示Map六大遍历方式
 * @Author Jing Yilin
 * @Date 2021/12/21 14:14
 * @Version 1.0
 **/
public class MapFor {
    public static void main(String[] args) {
        Map map = new HashMap();
        map.put("Drums", "Yoshiki");
        map.put("Guitar","Hide");
        map.put("Bass", "Pata");
        map.put("Vocal","Toshi");
        map.put(null, "Heath");

        //第一组：先取出所有的key,再通过key取出对应的value
        Set keySet = map.keySet();
        //(1) 增强for
        for (Object key : keySet) {
            System.out.println(key + "-" + map.get(key));
        }
        //(2) 迭代器
        Iterator iterator = keySet.iterator();
        while (iterator.hasNext()) {
            Object key = iterator.next();
            System.out.println(key + "-" + map.get(key));
        }
        //第二组：取出所有的value
        Collection values = map.values();
        //这里可以使用所有Collection使用的遍历方法
        //(1) 增强for
        for (Object value: values) {
            System.out.println(value);
        }
        //(2) 迭代器
        Iterator iterator1 = values.iterator();
        while (iterator1.hasNext()) {
            Object value = iterator1.next();
            System.out.println(value);
        }

        //第三组：通过EntrySet
        Set entrySet = map.entrySet();
        //(1) 增强for
        for (Object entry : entrySet)
        {
            //将entry转成Map.Entry
            Map.Entry m = (Map.Entry) entry;
            System.out.println(m.getKey() + "-" + m.getValue());
        }
        //(2) 迭代器
        Iterator iterator2 = entrySet.iterator();
        while (iterator2.hasNext()) {
            Object entry = iterator2.next();
            Map.Entry m = (Map.Entry) entry;
            System.out.println(m.getKey() + "-" + m.getValue());
        }
    }
}

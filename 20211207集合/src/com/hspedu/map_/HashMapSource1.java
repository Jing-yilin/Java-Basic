package com.hspedu.map_;

import java.util.HashMap;

@SuppressWarnings("all")
/**
 * @ClassName HashMapSource
 * @Description TODO
 * @Author Jing Yilin
 * @Date 2021/12/23 9:51
 * @Version 1.0
 **/
public class HashMapSource1 {
    public static void main(String[] args) {
        HashMap map = new HashMap();
        map.put("java", 10);
        map.put("php", 10);
        map.put("java", 20);

        System.out.println("map = " + map);

    }
}

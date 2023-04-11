package com.hspedu.map_;

import java.util.HashMap;

@SuppressWarnings("all")
/**
 * @ClassName HashMapSource2
 * @Description TODO
 * @Author Jing Yilin
 * @Date 2021/12/23 10:37
 * @Version 1.0
 **/
public class HashMapSource2 {
    public static void main(String[] args) {
        HashMap map = new HashMap();
        for (int i = 1; i <= 128; i++) {
            map.put(i, "hello");

        }
        System.out.println(map);
    }
}

class A {
    private int num;

    public A(int num) {
        this.num = num;
    }

    //所有A对象的hashCode都一样
    @Override
    public int hashCode() {
        return 100;
    }

    @Override
    public String toString() {
        return "A{" +
                "num=" + num +
                '}';
    }
}

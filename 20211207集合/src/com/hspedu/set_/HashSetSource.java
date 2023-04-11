package com.hspedu.set_;

import java.util.HashSet;

/**
 * @ClassName HashSetSource
 * @Description TODO
 * @Author Jing Yilin
 * @Date 2021/12/17 0:23
 * @Version 1.0
 **/
public class HashSetSource {
    public static void main(String[] args) {
        HashSet hashSet = new HashSet();
        hashSet.add("java");
        hashSet.add("php");
        hashSet.add("java");
        System.out.println("hashSet = " + hashSet);

        /*
        * 源码解读
        * 1.构造器
        * public HashSet() {
        map = new HashMap<>();
        }
        * 2.执行 public boolean add(E e) {
        return map.put(e, PRESENT)==null;
        }
        * */
    }
}

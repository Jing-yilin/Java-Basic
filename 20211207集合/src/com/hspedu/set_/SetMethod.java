package com.hspedu.set_;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/**
 * @ClassName SetMethod
 * @Description TODO
 * @Author Jing Yilin
 * @Date 2021/12/15 23:22
 * @Version 1.0
 **/
public class SetMethod {
    public static void main(String[] args) {
        Set set = new HashSet();
        set.add("Yoshiki");
        set.add("Yoshiki");//添加两次"Yoshiki"
        set.add("Toshi");
        set.add("Pata");
        set.add("Hide");
        set.add("Heath");
        set.add(null);
        set.add(null);//添加两次null

        System.out.println("set = " + set);//set = [Hide, null, Yoshiki, Toshi, Pata, Heath]
        //发现set里只有一个"Yoshiki"和null,说明set的元素不允许重复
        //而且发现存放之后元素是无序的（但是固定了）

        if (set.contains("Toshi")){
            System.out.println("set.contains(\"Toshi\") = true");
        }

        //遍历
        //方法一：迭代器
        Iterator iterator = set.iterator();
        while (iterator.hasNext()) {
            Object next = iterator.next();
//            System.out.println(next);
        }

        //方法二：增强for
        for (Object o:set) {
//            System.out.println(o);
        }


        //删除
        set.remove(null);

        //清空
        set.clear();


    }
}

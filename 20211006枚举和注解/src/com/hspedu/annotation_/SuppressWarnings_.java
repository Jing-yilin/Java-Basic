package com.hspedu.annotation_;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName SuppressWarnings_
 * @Description TODO
 * @Author Jing Yilin
 * @Date 2021/10/6 21:25
 * @Version 1.0
 **/

//为了省事，可以直接放在类上
@SuppressWarnings({"all"})
public class SuppressWarnings_ {
    //当我们不希望看到警告时，可以使用SuppressWarning
    @SuppressWarnings({"rawtypes", "unchecked", "unused"})
    //@SuppressWarnings({"all"})
    //SuppressWarnings 作用方法与放置位置有关
    //此时抑制警告的范围就是main方法
    public static void main(String[] args) {
        List list = new ArrayList();
        list.add("Jack");
        list.add("Mary");
        list.add("Tom");
        int i;
        System.out.println(list.get(1));
    }
}

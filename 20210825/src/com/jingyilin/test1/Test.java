package com.jingyilin.test1;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Test {
    public static void main(String[] args) {
        //1.自动导包，自动删包
        Map map = new HashMap();

        //2. if
        boolean flag = true;
        //直接输入flag.if
        if (flag) {

        }
        //输入flag.else
        if (!flag) {

        }

        //3.for/while自动生成
        //输入fori，自动生成for循环体
        for (int i = 0; i < 10; i++) {

        }
        //输入flag.while
        while (flag) {

        }

        //4.var
        //输入new String().var
        String s = new String();

        //输入sout
        System.out.println();

        //输入"Hello world".sout
        System.out.println("Hello world");

        //int num = 10/0;.try
        try {
            int num = 10/0;
        } catch (Exception e) {
            e.printStackTrace();
        }

        //8.List各种操作
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6);
        //输入list.for
        for (Integer integer : list) {
            //输入integer.sout
            System.out.println(integer);
        }

        //输入list.fori
        for (int i = 0; i < list.size(); i++) {

        }

        //输入list.forr
        for (int i = list.size() - 1; i >= 0; i--) {

        }
        
    }

    public int test() {
        //输入10.return
        return 10;
    }

}

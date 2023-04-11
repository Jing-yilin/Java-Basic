package com.hspedu.homeworks;

import java.sql.SQLOutput;
import java.time.LocalDateTime;

/**
 * @ClassName Homework01
 * @Description TODO
 * @Author Jing Yilin
 * @Date 2021/12/6 14:08
 * @Version 1.0
 **/
public class Homework01 {
    //将字符串中指定部分进行反转
    public static String reverse(String str, int start, int end)
    {
        //做一个输入验证
        if (!(str != null && start >= 0 && end > start && end < str.length()))
        {
            throw new RuntimeException("参数不正确！");
        }

        StringBuilder res = new StringBuilder(str);
        char tmp;
        while (start<end)
        {
            tmp = res.charAt(start);
            res.setCharAt(start, res.charAt(end));
            res.setCharAt(end,tmp);
            start++;
            end--;
        }
        return res.toString();
    }

    public static void main(String[] args) {
        long l1 = System.currentTimeMillis();
        String str = "大风起兮云飞扬";
        System.out.println(str);
        try {
            str = reverse(str, 1, 4);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return;
        }
        System.out.println("==========反转后==========");
        System.out.println(str);
        long l2 = System.currentTimeMillis();
        System.out.println("一共用了" + (l2-l1) + "毫秒");


    }
}

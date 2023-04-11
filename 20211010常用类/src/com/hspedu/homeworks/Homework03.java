package com.hspedu.homeworks;

import java.util.Locale;

/**
 * @ClassName Homework03
 * @Description TODO
 * @Author Jing Yilin
 * @Date 2021/12/7 9:11
 * @Version 1.0
 **/
public class Homework03 {
    /*
     * 输入：Jing Yi Lin
     * 输出：Lin,Jing .Y
     * */

    public static String nameTrans1(String s) {
        if (s == null) {
            System.out.println("字符串不能为空！");
            return null;
        }

        String[] names = s.split(" ");
        if (names.length != 3) {
            System.out.println("输入的格式有误！");
            return null;
        }

        StringBuilder res = new StringBuilder("");
        res.append(s.substring(s.lastIndexOf(" ") + 1, s.length()))
                .append(",")
                .append(s.substring(0, s.indexOf(" ")))
                .append(" .")
                .append(s.substring(s.indexOf(" ") + 1, s.indexOf(" ") + 2).toUpperCase());

        return res.toString();
    }

    public static String nameTrans2(String s) {
        if (s == null) {
            System.out.println("字符串不能为空！");
            return null;
        }

        String[] names = s.split(" ");
        if (names.length != 3) {
            System.out.println("输入的格式有误！");
            return null;
        }

        return String.format("%s,%s .%c", names[2], names[1], names[1].toUpperCase().charAt(0));
    }

    public static void main(String[] args) {
        String s = "Jing Yi Lin";
        String a = "";
//        System.out.println(nameTrans(s));
        long l1 = System.currentTimeMillis();
        for (int i = 0; i < 20000; i++) {
            a = nameTrans1(s);
        }
        long l2 = System.currentTimeMillis();
        System.out.println("使用nameTrans1耗时" + (l2-l1) + "ms");

        for (int i = 0; i < 20000; i++) {
            a = nameTrans2(s);
        }
        long l3 = System.currentTimeMillis();
        System.out.println("使用nameTrans2耗时" + (l3-l2) + "ms");
    }
}

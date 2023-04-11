package com.hspedu.homework;

import java.util.regex.Pattern;

/**
 * @ClassName Homework02
 * @Description 要求验证整数和小数
 * @Author zephyr
 * @Date 2022/6/27 21:48
 * @Version 1.0
 */
public class Homework02 {
    public static void main(String[] args) {
        /**
         * 这个题要考虑整数和负数
         * 比如：123 -345 34.56 -89.9 -0.001 0.45
         */

        String content = "-0.129";
        String regStr = "^-?(([1-9]\\d*(\\.\\d+)?)|(0\\.\\d+))$";

        if (content.matches(regStr)){
            System.out.println("格式匹配");
        } else {
            System.out.println("格式不匹配");
        }
    }
}

package com.hspedu.homework;

import java.util.regex.Pattern;

/**
 * @ClassName Homework03
 * @Description 正则解析域名
 * @Author zephyr
 * @Date 2022/6/27 21:59
 * @Version 1.0
 */
public class Homework03 {
    public static void main(String[] args) {
        /**
         * 3.对一个url进行解析 Homework03.java
         * https://www.sohu.com:8080/abc/index.htm
         * a)要求得到协议是什么？ http
         * b)域名是什么？ www.sohu.com
         * c)端口是什么？ 8080
         * d)文件名是什么？ index.htm
         */

        String content = "https://www.sohu.com:8080/abc/index.htm";
        System.out.println("协议: " + Pattern.compile("http|https").matcher(content).group(0));

    }
}

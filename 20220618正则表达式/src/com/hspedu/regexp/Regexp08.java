package com.hspedu.regexp;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @ClassName Regexp08
 * @Description 演示非捕获分组
 * @Author zephyr
 * @Date 2022/6/24 20:37
 * @Version 1.0
 */
@SuppressWarnings("all")
public class Regexp08 {
    public static void main(String[] args) {
        String content = "hello景奕林教育 景奕林老师 景奕林同学";

//        String regStr = "景奕林教育|景奕林老师|景奕林同学";
        String regStr = "景奕林(?:教育|老师|同学)"; //与上面的方法等价
        Pattern pattern = Pattern.compile(regStr);
        Matcher matcher = pattern.matcher(content);

        while (matcher.find()){
            System.out.println("group(0) = " + matcher.group(0));
        }

    }
}

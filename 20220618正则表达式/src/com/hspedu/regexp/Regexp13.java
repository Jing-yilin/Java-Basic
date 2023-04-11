package com.hspedu.regexp;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @ClassName Regexp13
 * @Description TODO
 * @Author zephyr
 * @Date 2022/6/26 21:21
 * @Version 1.0
 */
public class Regexp13 {
    public static void main(String[] args) {
        String content = "我...我要...学学学学...编程java!";

        //1. 去掉所有.
        Pattern pattern = Pattern.compile("\\.");
        Matcher matcher = pattern.matcher(content);
        content = matcher.replaceAll("");

        System.out.println("content = " + content);

        //2. 去掉重复的字
        //(1) 使用(.)\\1+

//        pattern = Pattern.compile("(.)\\1+");
//        matcher = pattern.matcher(content);
//
//        while (matcher.find()){
//            content = content.replaceFirst(matcher.group(0), matcher.group(1));
//        }
//
//        System.out.println(content);

        //3. 使用一条语句去重
        content = Pattern.compile("(.)\\1+").matcher(content).replaceAll("$1");

        System.out.println(content);

    }
}

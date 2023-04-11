package com.hspedu.regexp;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @ClassName Regexp07
 * @Description 演示正则表达式分组
 * @Author zephyr
 * @Date 2022/6/24 08:10
 * @Version 1.0
 */
public class Regexp07 {
    public static void main(String[] args) {
        String content = "jingfengmian s7788 nn1189han";
        String regStr = "(\\d\\d)(\\d\\d)"; //匹配四个数组的字符串
        Pattern pattern = Pattern.compile(regStr);
        Matcher matcher = pattern.matcher(content);

        while (matcher.find()){
            System.out.println("-------------------------------");
            System.out.println("group(0) = " + matcher.group(0));
            System.out.println("group(1) = " + matcher.group(1));
            System.out.println("group(2) = " + matcher.group(2));
        }
    }
}

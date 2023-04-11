package com.hspedu.regexp;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @ClassName Regexp12
 * @Description 测试捕获分组
 * @Author zephyr
 * @Date 2022/6/26 20:42
 * @Version 1.0
 */
public class Regexp12 {
    public static void main(String[] args) {
        String content = "hello jack tim11 jack22 yyy xxx";
        String regStr = "(\\d)\\1";
        Pattern pattern = Pattern.compile(regStr);
        Matcher matcher = pattern.matcher(content);

        while (matcher.find()){
            System.out.println(matcher.group(0));
        }
    }
}

package com.hspedu.regexp;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @ClassName Regexp02
 * @Description TODO
 * @Author zephyr
 * @Date 2022/6/19 21:01
 * @Version 1.0
 */
public class Regexp02 {
    public static void main(String[] args) {
        String content = "abc$(.abc(123(";
        //匹配(
        String regStr = "\\.";
        Pattern pattern = Pattern.compile(regStr);
        Matcher matcher = pattern.matcher(content);

        while (matcher.find()){
            System.out.println("找到: " + matcher.group(0));
        }
    }
}

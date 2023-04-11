package com.hspedu.regexp;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @ClassName Regexp04
 * @Description 选择匹配符
 * @Author zephyr
 * @Date 2022/6/19 21:59
 * @Version 1.0
 */
public class Regexp04 {
    public static void main(String[] args) {
        String content = "jingfengmian 景 奕林";
        String regStr = "jing|景.*";
        Pattern pattern = Pattern.compile(regStr);
        Matcher matcher = pattern.matcher(content);

        while (matcher.find()){
            System.out.println("找到： " + matcher.group(0));
        }
    }
}

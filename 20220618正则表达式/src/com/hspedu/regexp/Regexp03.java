package com.hspedu.regexp;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @ClassName Regexp03
 * @Description 演示字符匹配的使用
 * @Author zephyr
 * @Date 2022/6/19 21:36
 * @Version 1.0
 */
public class Regexp03 {
    public static void main(String[] args) {
        String content = "a11.cC 8";
//        String regStr = "\\S";
        String regStr = ".+";
        /*
        如何不区分大小写
        使用(?i)表示匹配的时候不区分大小写
         */
        Pattern pattern = Pattern.compile(regStr);
        Matcher matcher = pattern.matcher(content);

        while (matcher.find()){
            System.out.println("找到： " + matcher.group(0));
        }
    }


}

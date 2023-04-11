package com.hspedu.regexp;

import java.lang.reflect.Parameter;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @ClassName Regexp10
 * @Description 正则表达式的应用实例
 * @Author zephyr
 * @Date 2022/6/24 21:17
 * @Version 1.0
 */
public class Regexp10 {
    public static void main(String[] args) {
        String content = "韩顺平教育";
        //汉字
//        String regStr = "^[\u0391-\uffe5]+$";
        //邮政编码
        //要求：1-9开头的6位数，比如：123456
//        String regStr = "^[1-9]\\d{5}$";
        //QQ号
        //要求：1-9开头的一个（5-10位数）
//        String regStr = "^[1-9]\\d{4,9}$";
        //手机号码
        //要求：必须以13,14,15,18开头的11位数，比如13588889999
        String regStr = "^1[3|4|5|8]\\d{9}$";

        Pattern pattern = Pattern.compile(regStr);
        Matcher matcher = pattern.matcher(content);
        if (matcher.find()){
            System.out.println("满足格式");
        } else {
            System.out.println("不满足格式");
        }
    }
}

package com.hspedu.homework;

import java.util.regex.Pattern;

/**
 * @ClassName Homework01
 * @Description 验证电子邮件
 * @Author zephyr
 * @Date 2022/6/27 21:36
 * @Version 1.0
 */
public class Homework01 {
    public static void main(String[] args) {
        /**
         * 1.只能有一个@
         * 2.@前面是用户名，可以是a-z A-Z 0-9 -字符
         * 3.@后面是域名，并且域名只能是英文字母，比sohu.com或者tsinghua.org.cn
         * 4.写出对应的正则表达式，验证输入的字符串是否为满足规则
         */
        String content = "JingYilin@tsinghua.org.cn";
        String regStr = "^[\\w-]+@([a-zA-z]+\\.)+[a-zA-z]+$";

//        boolean matches = Pattern.compile(regStr).matcher(content).matches();
//        if (matches){
//            System.out.println("格式匹配");
//        } else {
//            System.out.println("格式不匹配");
//        }

        /*
        content.matches(regStr) 底层调用 Pattern.matches(regex, this)
         */
        if (content.matches(regStr)){
            System.out.println("格式匹配");
        } else {
            System.out.println("格式不匹配");
        }
    }
}

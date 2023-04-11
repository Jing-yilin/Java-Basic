package com.hspedu.regexp;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @ClassName Regexp11
 * @Description 正则匹配URL
 * @Author zephyr
 * @Date 2022/6/24 22:18
 * @Version 1.0
 */
public class Regexp11 {
    public static void main(String[] args) {
        String content = "https://www.bilibili.com/video/BV1YY41177NU?spm_id_from=333.1007.top_right_bar_window_history.content.click&vd_source=d1982582e601460dfd542d7ff0efae87";


        // [\\w-] 就是匹配任意字母、数字 和 符号- (减号)
//        String regStr = "^(http(s?)://)([\\w-]+\\.)+[\\w-]+(/[\\w-?=.&/%#]*)?$";
        String regStr = "^(http(s)?://)?[a-zA-Z0-9][-a-zA-Z0-9]{0,62}(\\.[a-zA-Z0-9][-a-zA-Z0-9]{0,62})+(:[0-9]{1,5})?[-a-zA-Z0-9()@:%_+.~#?&//=]*$";
        Pattern pattern = Pattern.compile(regStr);
        Matcher matcher = pattern.matcher(content);
        if (matcher.find()){
            System.out.println("满足格式");
        } else {
            System.out.println("不满足格式");
        }
    }
}

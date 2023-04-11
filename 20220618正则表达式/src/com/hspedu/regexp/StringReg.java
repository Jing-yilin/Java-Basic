package com.hspedu.regexp;

/**
 * @ClassName StringReg
 * @Description String类中使用正则表达式
 * @Author zephyr
 * @Date 2022/6/26 22:30
 * @Version 1.0
 */
public class StringReg {
    public static void main(String[] args) {
        String content = "jdk1.3 jdk1.4 jdk";

        content = content.replaceAll("jdk(1.3|1.4)", "jdk");
        System.out.println(content); //jdk jdk jdk

        // 验证一个手机号
        content = "13819121231";
        if (content.matches("1(38|92)\\d{8}")){
            System.out.println("匹配成功");
        } else {
            System.out.println("匹配失败");
        }

        // 按照 # 或 - 或 ~ 或 ?来分割
        content = "hello#world-I~love?you";
        String[] strings = content.split("[#|~|?]|-");
        for (String str: strings){
            System.out.print(str + "\t"); //hello	world	I	love	you
        }
    }
}

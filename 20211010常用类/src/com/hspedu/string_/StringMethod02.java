package com.hspedu.string_;

/**
 * @ClassName StringMethod02
 * @Description TODO
 * @Author Jing Yilin
 * @Date 2021/10/13 23:53
 * @Version 1.0
 **/
public class StringMethod02 {
    public static void main(String[] args) {
        // 1.toUpperCase()转换成大写
        System.out.println("========1.toUpperCase()转换成大写=========");
        String s = "hELLo";
        System.out.println(s.toUpperCase());
        // 2.toLowerCase()转换成小写
        System.out.println("========2.toLowerCase()转换成小写=========");
        System.out.println(s.toLowerCase());
        // 3.concat()拼接字符串
        System.out.println("========3.concat()拼接字符串=========");
        String s1 = "宝玉";
        s1 = s1.concat("林黛玉").concat("薛宝钗").concat("together");
        System.out.println(s1);
        // 4.replace()替换字符串中的字符
        System.out.println("========4.replace()替换字符串中的字符=========");
        String s2 = "宝玉 and 林黛玉 林黛玉 林   黛玉";//对s2本身没有影响
        s2 = s2.replace("林黛玉","薛宝钗");
        System.out.println(s2);
        // 5.split()分割字符,返回一个数组
        System.out.println("========5.split()分割字符,返回一个数组=========");
        String poem = "锄禾日当午,汗滴禾下土,谁知盘中餐,粒粒皆辛苦";
        String[] split = poem.split(",");
        for (String str: split) {
            System.out.println(str);
        }
        String path = "E:\\aaa\\bb";
        String[] split1 = path.split("\\\\");//对于特殊字符，需要转义字符
        for (String str: split1) {
            System.out.println(str);
        }
        // 6.toCharArray() 转换成字符数组
        System.out.println("========6.toCharArray() 转换成字符数组=========");
        s = "happy";
        char[] chs = s.toCharArray();
        for(char ch:chs){
            System.out.println(ch);
        }
        // 7.compareTo() 比较两个字符串大小
        // 如果前者大，返回整数，后者大，则返回负数，相等则返回0
        // 如果前面部分都相同，返回str1.length()-str2.length()
        System.out.println("========7.compareTo() 比较两个字符串大小=========");
        String a = "jchn";
        String b = "jack";
        System.out.println(a.compareTo(b));// 返回值是'c'-'a' = 2
        // 8.format 格式字符串
        /*占位字符有: %s %c %d %.2f会进行四舍五入的处理*/
        System.out.println("========8.format 格式字符串=========");
        String name = "jack";
        int age = 10;
        double score = 98.3 / 3;
        char gender = '男';
        String info =
                "我的名字是" + name + "年龄是" + age + ",成绩是" + score + "性别是" + gender;
        String info1 = String.format("我的名字是%s年龄是%d,成绩是%.2f性别是%c", name, age, score, gender);
        System.out.println(info);
        System.out.println(info1);
    }
}

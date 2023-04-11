package com.hspedu.regexp;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @ClassName RegTheory
 * @Description 分析java的正则表达式的底层实现
 * @Author zephyr
 * @Date 2022/6/17 23:01
 * @Version 1.0
 */
public class RegTheory {
    public static void main(String[] args) {
        String content = "1990年" +
                "代初开发Java语言的雏形，最初被命名为Oak，目标设定在家" +
                "用电器等小型系统的程式语言，应用在电视机、电话、闹钟、烤" +
                "面包机等家用电器的控制和通讯。由于这些智慧型家电的市场需" +
                "求没有预期的高，升阳电脑放弃了该项计划。随着1990年代网" +
                "际网路的发展，升阳电脑看见Oak在网际网路上应用的前景，于" +
                "是改造了Oak，于1995年5月以Java的名称正式释出。Java伴" +
                "随着网际网路的迅猛发展而发展，逐渐成为重要的网路程式语言。";

        //目标：匹配所有四个数字连一起的

        //1. \\d表示任意一个数字
        String regStr = "(\\d\\d)(\\d\\d)";
        //2. 创建模式对象[即正则表达式]
        Pattern pattern = Pattern.compile(regStr);
        //3. 创建匹配器
        Matcher matcher = pattern.matcher(content);
        //4. 开始匹配
        /**
         * matcher.find() 完成的任务
         * 1. 根据指定的规则，定位满足条件的子字符串（比如1990）
         * 2. 找到后将子字符串的开始的索引记录在matcher对象的属性中 int[] groups
         *      groups[0]=0 , 把该子字符串的 结束的索引+1 值 记录到 group[1] = 4
         *
         * 源码：
         * public String group(int group) {
         *         if (first < 0)
         *             throw new IllegalStateException("No match found");
         *         if (group < 0 || group > groupCount())
         *             throw new IndexOutOfBoundsException("No group " + group);
         *         if ((groups[group*2] == -1) || (groups[group*2+1] == -1))
         *             return null;
         *         return getSubSequence(groups[group * 2], groups[group * 2 + 1]).toString();
         *     }
         *
         * matcher对象里面有一个groups属性，当检测到第一串符合条件的数字，就记录 group[0]=0 group[1]=4
         * 调用matcher.group(0)，里面有一个getSubSequence,是去截取content的字串(group[0],group[1])
         * 也就是(0,4), 即content里的 "1990"
         */
        while(matcher.find()){
            System.out.println("matcher.group(0) = " + matcher.group(0));
            System.out.println("matcher.group(1) = " + matcher.group(1));
            System.out.println("matcher.group(2) = " + matcher.group(2));
            System.out.println("-----------------------------------");
        }
    }
}

package com.hspedu.date_;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @ClassName Date01
 * @Description TODO
 * @Author Jing Yilin
 * @Date 2021/12/2 13:47
 * @Version 1.0
 **/
public class Date01 {
    public static void main(String[] args) throws ParseException {
        //使用java.util.Date;
        //实现了比较、可串行化、克隆
        //默认输出格式是国外的，因此通常需要格式转换
        Date d1 = new Date();//获取当前系统时间
        Date d2 = new Date(9234567);//通过指定毫秒数得到时间
        System.out.println(d1.getTime());//获取某个时间对应的毫秒数//1638424963461
        System.out.println("d1 = " + d1);//d1 = Thu Dec 02 14:02:43 CST 2021
        System.out.println("d2 = " + d2);//d2 = Thu Jan 01 10:33:54 CST 1970

        //这里的字母是规定好的
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日 hh:mm:ss E");
        String format = sdf.format(d1);
        System.out.println(format);//2021年12月02日 02:02:43 周四

        //可以把一个格式化的字符串转成对应的Date
        String s = "1996年01月01日 10:20:30 星期一";
        //得到的Date还是国外的格式，需要指定格式输出
        //再把String -> Date时，String格式需要和你指定的一样，否则会抛出转换异常
        Date parse = sdf.parse(s);
        System.out.println("parse = " + sdf.format(parse));//parse = 1996年01月01日 10:20:30 周一
    }
}

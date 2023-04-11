package com.hspedu.date_;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

/**
 * @ClassName LocalDate_
 * @Description TODO
 * @Author Jing Yilin
 * @Date 2021/12/2 14:44
 * @Version 1.0
 **/
public class LocalDate_ {
    public static void main(String[] args) {
        //第三代日期

        //1. 使用now()返回表示当前日期时间的 对象
        LocalDateTime ldt = LocalDateTime.now();// LocalDate.now // LocalTime.now()
        System.out.println(ldt);//2021-12-02T14:48:19.001017

        //2. 使用DateTimeFormatter 对象来格式化
        //创建DateTimeFormatter对象
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy年MM月dd日 HH小时mm分钟ss秒");
        String format = dtf.format(ldt);
        System.out.println(format);


        System.out.println(ldt.getYear());//2021
        System.out.println(ldt.getMonth());//DECEMBER
        System.out.println(ldt.getMonthValue());//12
        System.out.println(ldt.getDayOfMonth());//2
        System.out.println(ldt.getHour());//14
        System.out.println(ldt.getMinute());//51
        System.out.println(ldt.getSecond());//10

        LocalDate now = LocalDate.now();//获取年月日
        LocalTime now1 = LocalTime.now();//获取时分秒

        //提供 plus 和 minus 方法可以对当前时间进行加和减
        //看看890天后时什么时候，打印年月日-时分秒
        LocalDateTime after890days = ldt.plusDays(890);
        System.out.println("890天后是 "+dtf.format(after890days));

        //看看3456分钟前是什么时候
        LocalDateTime before3456sec = ldt.minusMinutes(3456);
        System.out.println("3456分钟前是 "+dtf.format(before3456sec));

        //更多的方法自己查看API


    }
}

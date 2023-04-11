package com.hspedu.date_;

import jdk.swing.interop.SwingInterOpUtils;

import java.util.Calendar;

/**
 * @ClassName Calendar_
 * @Description TODO
 * @Author Jing Yilin
 * @Date 2021/12/2 14:09
 * @Version 1.0
 **/
public class Calendar_ {
    public static void main(String[] args) {

        //1. Calendar时一个抽象类，并且构造器是private
        //2. 通过getInstance()获取实例
        //3. 提供了大量的方法和字段给程序员
        Calendar c = Calendar.getInstance();//创建日历对象，比较简单
        //打印出了大量的字段
        System.out.println("c = " + c);

        //获取日历对象的某个日历字段
        System.out.println("YEAR = " + c.get(Calendar.YEAR));
        //因为Calendar在返回月的时候是按照0开始编号的，所以要+1
        System.out.println("MONTH = " + (c.get(Calendar.MONTH) + 1));
        System.out.println("DAY = " + c.get(Calendar.DAY_OF_MONTH));
        //如果要用24小时进制，使用 Calendar.HOUR_OF_DAY
        System.out.println("HOUR = " + c.get(Calendar.HOUR));//默认12小时进制
        System.out.println("MINUTE = " + c.get(Calendar.MINUTE));
        System.out.println("SECOND = " + c.get(Calendar.SECOND));
        System.out.println("AM = " + c.get((Calendar.AM_PM)));

        //Calendar没有专门的格式化方法，所以需要程序员自己组合
        System.out.println(c.get(Calendar.YEAR) + "年" + (c.get(Calendar.MONTH) + 1) + "月" +
                c.get(Calendar.DAY_OF_MONTH) + "日 " + ((Calendar.AM == c.get(Calendar.AM_PM))?"上午":"下午") +
                c.get(Calendar.HOUR) + ":" +  c.get(Calendar.MINUTE) + ":" + c.get(Calendar.SECOND));

    }
}

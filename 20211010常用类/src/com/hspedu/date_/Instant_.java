package com.hspedu.date_;

import java.time.Instant;
import java.util.Date;

/**
 * @ClassName Instant_
 * @Description TODO 演示 Instant 时间戳
 * @Author Jing Yilin
 * @Date 2021/12/2 15:05
 * @Version 1.0
 **/
public class Instant_ {
    public static void main(String[] args) {

        //1. 通过静态方法now() 获取表示当前时间戳的对象
        Instant now = Instant.now();
        System.out.println("now = " + now);//now = 2021-12-02T07:08:58.978759600Z
        //2. 通过 from 可以把 Instance 转换成 Date
        Date date = Date.from(now);
        System.out.println("date = " + date);//date = Thu Dec 02 15:08:58 CST 2021
        //3. 通过 date 的 toInstant() 可以把 date 转换成 Instant对象的
        Instant instant = date.toInstant();
        System.out.println("instant = " + instant);//instant = 2021-12-02T07:08:58.978Z

    }
}

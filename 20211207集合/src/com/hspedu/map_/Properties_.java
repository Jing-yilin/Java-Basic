package com.hspedu.map_;

import java.util.Properties;

/**
 * @ClassName Properties_
 * @Description TODO
 * @Author Jing Yilin
 * @Date 2022/1/19 15:19
 * @Version 1.0
 **/
@SuppressWarnings("all")
public class Properties_ {
    public static void main(String[] args) {
        Properties properties = new Properties();
        //增加
        properties.put("程隰", 100);//k-v
//        properties.put(null, 100);//不能放null键
//        properties.put("cx", null);//不能放null值
        properties.put("cilixx", 100);
        properties.put("zephyr", 100);
        properties.put("zephyr", 80);//替换
        System.out.println("Properties = " + properties);

        //通过k获取对应的值
        properties.get("程隰");//88

        //删除
        properties.remove("cilixx");

        //修改
        properties.put("程隰", 99);

        //查
        properties.get("程隰");
        properties.getProperty("程隰");
    }
}

package com.hspedu.enum_;

/**
 * @ClassName Enumeration02
 * @Description 使用class来自定义枚举
 * @Author Jing Yilin
 * @Date 2021/10/5 13:05
 * @Version 1.0
 **/
public class Enumeration02 {
    public static void main(String[] args) {
        System.out.println(Season2.AUTUMN);
        System.out.println(Season2.SPRING);
        System.out.println(Season2.SUMMER);
        System.out.println(Season2.WINTER);
    }
}

//演示自定义枚举
class Season2{

    /*在内部直接在创建固定对象*/

    private String name;
    private String desc;//描述

    //定义了四个对象
    //枚举对象名通常大写
    public static final Season2 SPRING = new Season2("spring", "warm");
    public static final Season2 WINTER = new Season2("winter", "cold");
    public static final Season2 SUMMER = new Season2("summer", "hot");
    public static final Season2 AUTUMN = new Season2("autumn", "cool");


    private Season2(String name, String desc) {
        this.name = name;
        this.desc = desc;
    }

    public String getName() {
        return name;
    }

    public String getDesc() {
        return desc;
    }

    @Override
    public String toString() {
        return "Season2{" +
                "name='" + name + '\'' +
                ", desc='" + desc + '\'' +
                '}';
    }
}
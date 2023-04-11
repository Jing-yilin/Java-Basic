package com.hspedu.enum_;

/**
 * @ClassName Enumeration03
 * @Description TODO 使用枚举类enum
 * @Author Jing Yilin
 * @Date 2021/10/5 21:12
 * @Version 1.0
 **/
public class Enumeration03 {
    public static void main(String[] args) {
        System.out.println(Season3.AUTUMN);
        System.out.println(Season3.SPRING);
        System.out.println(Season3.SUMMER);
        System.out.println(Season3.WINTER);
    }

}

enum Season3{//枚举类

//    public static final Season3 SPRING = new Season3("spring", "warm");
//    public static final Season3 WINTER = new Season3("winter", "cold");
//    public static final Season3 SUMMER = new Season3("summer", "hot");
//    public static final Season3 AUTUMN = new Season3("autumn", "cool");

    //1.使用关键字enum代替class
    //2.直接使用SPRING("spring", "warm");
    //代替 public static final Season3 SPRING = new Season3("spring", "warm");
    //常量名(实参列表)
    //3.如果有多个常量，使用逗号间隔
    //4.枚举常量必须写在最前面
    SPRING("spring", "warm"), WINTER("winter", "cold"),
    AUTUMN("autumn", "cool"), SUMMER("summer", "hot");

    private String name;
    private String desc;//描述

    private Season3(String name, String desc) {
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
        return "Season3{" +
                "name='" + name + '\'' +
                ", desc='" + desc + '\'' +
                '}';
    }
}

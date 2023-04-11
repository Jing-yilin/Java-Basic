package com.hspedu.enum_;

/**
 * @ClassName EnumMethod
 * @Description TODO 演示enum类各种方法的使用
 * @Author Jing Yilin
 * @Date 2021/10/5 22:06
 * @Version 1.0
 **/
public class EnumMethod {
    public static void main(String[] args) {
        //使用Season3枚举类演示各种方法
        Season3 autumn = Season3.AUTUMN;

        //name(),输出枚举对象的名称
        System.out.println(autumn.name());

        //ordinal(),输出该枚举常量的次序,从0开始编号
        System.out.println(autumn.ordinal());

        //values(),返回Season3的一个数组
        Season3[] values = Season3.values();
        for (Season3 season: values){//增强for循环
            System.out.println(season);
        }

        //valueOf(),根据输入的枚举名称返回枚举对象
        Season3 autumn1 = Season3.valueOf("AUTUMN");
        System.out.println("autumn1 = " + autumn1);
        System.out.println(autumn == autumn1);

        //compareTo(),比较两个枚举常量，比较的是编号，返回编号相减的差值
        //AUTUMN编号2,SUMMER编号3，2-3=-1
        System.out.println(Season3.AUTUMN.compareTo(Season3.SUMMER));

        //toString()
        System.out.println(Season3.AUTUMN.toString());


    }
}

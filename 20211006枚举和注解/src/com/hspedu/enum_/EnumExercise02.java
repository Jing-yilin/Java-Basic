package com.hspedu.enum_;

/**
 * @ClassName EnumExercise02
 * @Description TODO
 * @Author Jing Yilin
 * @Date 2021/10/6 10:41
 * @Version 1.0
 **/
public class EnumExercise02 {
    public static void main(String[] args) {
        System.out.println("===所有星期的信息如下===");
        for (Week day:Week.values()) {
            System.out.println(day);
        }
    }
}

enum Week{
    MONDAY("星期一"), TUESDAY("星期二"),
    WEDNESDAY("星期三"), THURSDAY("星期四"),
    FRIDAY("星期五"), SATURDAY("星期六"), SUNDAY("星期日");

    public String name;
    Week(String name){
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }
}

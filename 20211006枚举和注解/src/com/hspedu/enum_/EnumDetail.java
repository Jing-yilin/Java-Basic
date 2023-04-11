package com.hspedu.enum_;

/**
 * @ClassName EnumDetail
 * @Description TODO
 * @Author Jing Yilin
 * @Date 2021/10/6 13:11
 * @Version 1.0
 **/
public class EnumDetail {
    public static void main(String[] args) {
        Season4.SPRING.hi();
    }
}

interface A{
    public void hi();
}

//enum不能继承其他类但是可以实现接口
enum Season4 implements A{
    SPRING, SUMMER, AUTUMN, WINTER;

    @Override
    public void hi() {
        System.out.println("Hi!");
    }
}
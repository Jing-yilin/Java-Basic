package com.hspedu.homework;

/**
 * @ClassName Homework05
 * @Description TODO
 * @Author Jing Yilin
 * @Date 2021/10/6 22:48
 * @Version 1.0
 **/
public class Homework05 {
    public static void main(String[] args) {
        A.B b = (new A()).new B();
        b.show();
    }


}

class A{
    private String name = "李四";

    class B{
        private final String name = "张三";

        void show(){
            System.out.println(name);
            System.out.println(A.this.name);
        }
    }
}

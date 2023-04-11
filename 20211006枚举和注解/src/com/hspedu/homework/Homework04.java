package com.hspedu.homework;

/**
 * @ClassName Homework04
 * @Description TODO
 * @Author Jing Yilin
 * @Date 2021/10/6 22:42
 * @Version 1.0
 **/
@SuppressWarnings("all")
public class Homework04 {
    public static void main(String[] args) {
        Cellphone.testWork(new Computer() {
            @Override
            public void work() {
                System.out.print("Working!");
            }
        });
    }

}

interface Computer{
    void work();
}

class Cellphone{
    public static void testWork(Computer computer){
        computer.work();
    }
}

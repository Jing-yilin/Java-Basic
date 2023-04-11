package com.hspedu.homework;

/**
 * @ClassName Homework02
 * @Description TODO
 * @Author Jing Yilin
 * @Date 2022/1/23 15:23
 * @Version 1.0
 **/
public class Homework02 {
    public static void main(String[] args) {
        A a = new A();
        //创建两个线程，操作的是同一个对象，可以做到同一把锁
        Thread thread01 = new Thread(a);
        Thread thread02 = new Thread(a);
        thread01.start();
        thread02.start();
    }
}

class A implements Runnable {
    public static int money = 10000;
    @Override
    public void run() {
        do {
            takeMoney();
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        } while(money>1000);
    }
    //拿的是this的对象锁
    public synchronized void takeMoney(){
        if (money > 1000) {
            money -= 1000;
            System.out.println(Thread.currentThread().getName() + "取走了1000元,还剩下" + money + "元");
        }
    }
}
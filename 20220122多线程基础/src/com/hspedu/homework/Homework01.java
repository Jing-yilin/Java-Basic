package com.hspedu.homework;

import java.io.IOException;
import java.util.Scanner;

/**
 * @ClassName Homework01
 * @Description
 * @Author Jing Yilin
 * @Date 2022/1/23 14:49
 * @Version 1.0
 **/
public class Homework01 {
    public static void main(String[] args) {
        T1 t1 = new T1();
        T2 t2 = new T2(t1);
        t2.setDaemon(true);
        t1.start();
        t2.start();
    }
}

class T1 extends Thread {
    private boolean loop = true;

    public T1() {
    }

    @Override
    public void run() {
        while (loop) {
            printRand();
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void printRand() {
        System.out.println(100 * Math.random() + 1);
    }

    public boolean isLoop() {
        return loop;
    }

    public void setLoop(boolean loop) {
        this.loop = loop;
    }
}

class T2 extends Thread {
    private T1 t1;
    private static final Scanner scanner = new Scanner(System.in);

    public T2(T1 t1) {
        this.t1 = t1;
    }

    @Override
    public void run() {
        while (true) {
            controlT1();
        }
    }
    public void controlT1() {
        System.out.println("输入Q以关闭程序:");
        char c = scanner.next().toUpperCase().charAt(0);
        if (c == 'Q'){
            t1.setLoop(false);
        }
    }
}

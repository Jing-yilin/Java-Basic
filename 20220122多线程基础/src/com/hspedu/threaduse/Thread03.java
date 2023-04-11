package com.hspedu.threaduse;

import javax.swing.plaf.TableHeaderUI;

/**
 * @ClassName Thread03
 * @Description TODO
 * @Author Jing Yilin
 * @Date 2022/1/22 17:13
 * @Version 1.0
 **/
public class Thread03 {
    public static void main(String[] args) throws InterruptedException{

        Thread thread01 = new Thread(new Runnable() {
            int cnt = 0;
            @Override
            public void run() {
                do {
                    System.out.println("hello world! " + (++cnt) + Thread.currentThread().getName());
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                } while (cnt != 50);
            }
        });

        Thread thread02 = new Thread(new Runnable() {
            int cnt = 0;
            @Override
            public void run() {
                do {
                    System.out.println("hi " + (++cnt) + Thread.currentThread().getName());
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                } while (cnt != 20);
            }
        });

        thread01.start();//启动第一个线程
        thread02.start();//启动第二个线程

        T3 t3 = new T3();
        Thread thread_01 = new Thread(t3);
        Thread thread_02 = new Thread(t3);
        thread_01.start();
        thread_02.start();

        T4 t4 = new T4();
        t4.start();

    }
}

class T3 implements Runnable {

    @Override
    public void run() {

    }
}
class T4 extends Thread {
    @Override
    public void run() {
        super.run();
    }
}

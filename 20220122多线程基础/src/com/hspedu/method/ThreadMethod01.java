package com.hspedu.method;

import jdk.jfr.Threshold;

/**
 * @ClassName ThreadMethod01
 * @Description TODO
 * @Author Jing Yilin
 * @Date 2022/1/22 22:54
 * @Version 1.0
 **/
public class ThreadMethod01 {
    public static void main(String[] args) throws InterruptedException {
        T t = new T();
        t.setName("景风眠");
        t.setPriority(Thread.MIN_PRIORITY);
        System.out.println("线程名称 = " + t.getName());
        System.out.println(t.getName() + " 线程的优先级为" + t.getPriority());
        t.start();

        //主线程打印5个hi，然后就中断子线程的休眠
        for (int i = 0; i < 5; i++) {
            Thread.sleep(1000);
            System.out.println("hi " + i);
        }
        //中断线程休眠状态，提前结束休眠
        t.interrupt();
    }
}

class T extends Thread {
    @Override
    public void run() {
        while (true) {
            for (int i = 0; i < 100; i++) {
                System.out.println(Thread.currentThread().getName() + "吃包子" + i);
            }
            try {
                System.out.println(Thread.currentThread().getName() + "开始休眠");
                Thread.sleep(20*1000);
            } catch (InterruptedException e) {
                //InterruptedException是捕获一个中断异常（不是中止）
                System.out.println(Thread.currentThread().getName() + "被interrupt了");
            }
        }
    }
}

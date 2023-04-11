package com.hspedu.method;

/**
 * @ClassName ThreadMethodExercise
 * @Description TODO
 * @Author Jing Yilin
 * @Date 2022/1/23 0:01
 * @Version 1.0
 **/
public class ThreadMethodExercise {
    public static void main(String[] args) throws InterruptedException {
        ChildThread01 childThread01 = new ChildThread01();
        Thread thread = new Thread(childThread01);
        for (int i = 1; i <= 10; i++) {
            System.out.println("hi " + i);
            if (i == 5) {
                thread.start();
                thread.join();
                System.out.println("子线程结束...");
            }
            Thread.sleep(1000);
        }
        System.out.println("主线程结束...");
    }
}

class ChildThread01 implements Runnable {
    private int cnt_hello = 0;
    @Override
    public void run() {
        while (true) {
            System.out.println("Hello " + (++cnt_hello));
            if (cnt_hello == 10) {//当输出10次就退出线程
                break;
            }
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

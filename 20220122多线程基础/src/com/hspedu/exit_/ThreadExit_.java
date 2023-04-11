package com.hspedu.exit_;

/**
 * @ClassName ThreadExit_
 * @Description TODO
 * @Author Jing Yilin
 * @Date 2022/1/22 22:39
 * @Version 1.0
 **/
public class ThreadExit_ {
    public static void main(String[] args) {
        T t1 = new T();
        t1.start();

        //希望main线程去控制t1线程的终止
        //main休息5s
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //通知t1线程关闭
        t1.setLoop(false);
        System.out.println("t1线程被关闭...");
    }
}

class T extends Thread {
    private int cnt = 0;
    private boolean loop = true;//控制循环
    @Override
    public void run() {
        while (loop) {
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("T 还在运行中 " + (++cnt));
        }
    }

    public boolean isLoop() {
        return loop;
    }

    public void setLoop(boolean loop) {
        this.loop = loop;
    }
}

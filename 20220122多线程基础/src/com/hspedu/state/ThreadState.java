package com.hspedu.state;

/**
 * @ClassName ThreadState
 * @Description 演示线程周期的状态
 * @Author Jing Yilin
 * @Date 2022/1/23 13:34
 * @Version 1.0
 **/
public class ThreadState {
    public static void main(String[] args) throws InterruptedException {
        T t = new T();
        System.out.println(t.getName() + " state = " + t.getState());// NEW
        t.start();//RUNNABLE
        while (Thread.State.TERMINATED != t.getState()) {
            System.out.println(t.getName() + " state = " + t.getState());
            Thread.sleep(500);
        }
        System.out.println(t.getName() + " state = " + t.getState());//TERMINATED
    }
}
class T extends Thread {
    @Override
    public void run() {
        while (true) {
            for (int i = 0; i < 10; i++) {
                System.out.println("hi " + i);
            }
            try {
                Thread.sleep(1000);//TIMED_WAITING
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            break;
        }
    }
}

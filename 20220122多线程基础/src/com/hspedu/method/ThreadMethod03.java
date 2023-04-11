package com.hspedu.method;

/**
 * @ClassName ThreadMethod03
 * @Description TODO
 * @Author Jing Yilin
 * @Date 2022/1/23 0:14
 * @Version 1.0
 **/
public class ThreadMethod03 {
    public static void main(String[] args) throws InterruptedException {
        MyDaemonThread myDaemonThread = new MyDaemonThread();
        //把myDaemonThread设置成守护线程
        myDaemonThread.setDaemon(true);
        myDaemonThread.start();
        for (int i = 1; i <= 10; i++) {
            System.out.println("早晨的阳光是你");
            Thread.sleep(1000);
        }
    }
}

//Daemon -- 守护
//把这个线程设置成守护线程，那么当所有用户线程结束后，守护线程会自动结束
class MyDaemonThread extends Thread {
    @Override
    public void run() {
        for(;;) {
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("晚风是你，星星也是你");
        }
    }
}

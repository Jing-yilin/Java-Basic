package com.hspedu.method;

/**
 * @ClassName ThreadMethod02
 * @Description
 * @Author Jing Yilin
 * @Date 2022/1/22 23:52
 * @Version 1.0
 **/
public class ThreadMethod02 {
    public static void main(String[] args) throws InterruptedException {
        T2 t2 = new T2();
        t2.start();
        for (int i = 0; i < 20; i++) {
            if (i == 4) {
//                t2.join();//线程插队，会让t2先运行完

                Thread.yield();//线程礼让，不一定成功

                System.out.println("程隰开始回应>>>>>>>>>>");
            }
            Thread.sleep(1000);
            System.out.println(Thread.currentThread().getName() + "景奕林我也想你" + i);
        }
    }
}

class T2 extends Thread {
    @Override
    public void run() {
        for (int i = 0; i < 20; i++) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + "程隰我想你" + i);
        }
    }
}

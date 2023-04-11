package com.hspedu.sellticket;

import java.util.Random;

/**
 * @ClassName SellTicket
 * @Description 使用多线程模拟三个窗口同时售票,共售票100张
 * @Author Jing Yilin
 * @Date 2022/1/22 22:15
 * @Version 1.0
 **/
public class SellTicket {
    public static void main(String[] args) {
//        SellTicket01 sellTicket01_1 = new SellTicket01();
//        SellTicket01 sellTicket01_2 = new SellTicket01();
//        SellTicket01 sellTicket01_3 = new SellTicket01();
//        sellTicket01_1.start();
//        sellTicket01_2.start();
//        sellTicket01_3.start();

        SellTicket02 sellTicket02_1 = new SellTicket02();
        Thread thread_1 = new Thread(sellTicket02_1);
        Thread thread_2 = new Thread(sellTicket02_1);
        Thread thread_3 = new Thread(sellTicket02_1);
        thread_1.start();
        thread_2.start();
        thread_3.start();
    }
}

//使用Thread方式
//会发现出现线程冲突售出超过100的票
class SellTicket01 extends Thread{
    private  int ticketNum = 100;//让多个线程共享
    @Override
    synchronized public void run() {
        do {
            //休眠50毫秒
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            ticketNum--;
            System.out.println(Thread.currentThread().getName() + "进行了一次售票, 已售出" + (100-ticketNum) + "/" + "100");
        } while (ticketNum > 0);
    }
}

@SuppressWarnings("all")
class SellTicket02 implements Runnable {
    private static int ticketNum = 100;
    @Override
    public void run() {
        do{
            //休眠50毫秒
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            ticketNum--;
            System.out.println(Thread.currentThread().getName() + "进行了一次售票, 已售出" + (100-ticketNum) + "/" + "100");
        } while (ticketNum > 0);
    }
}

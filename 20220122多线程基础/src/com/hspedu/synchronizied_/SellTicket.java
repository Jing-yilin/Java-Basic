package com.hspedu.synchronizied_;

/**
 * @ClassName SellTicket
 * @Description 使用多线程模拟三个窗口同时售票, 共售票100张
 * @Author Jing Yilin
 * @Date 2022/1/22 22:15
 * @Version 1.0
 **/
@SuppressWarnings("all")
public class SellTicket {
    public static void main(String[] args) {
        SellTicket03 SellTicket03_1 = new SellTicket03();
        SellTicket03 SellTicket03_2 = new SellTicket03();
        SellTicket03 SellTicket03_3 = new SellTicket03();
        SellTicket03_1.start();
        SellTicket03_2.start();
        SellTicket03_3.start();
    }
}

//使用同步方法Synchronized实现线程同步
class SellTicket03 extends Thread {
    private static int ticketNum = 100;//让多个线程共享

    @Override
    public void run() {
        do {
            //休眠50毫秒
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            sell();
        } while (ticketNum > 0);
    }

    //public synchronized static void sell() {} 是一个同步方法
    //这时锁在 this对象
    public synchronized static void sell() {//同步方法，同一时刻，只能由一个线程执行sell()方法
        if (ticketNum > 0) {
            ticketNum--;
            System.out.println(Thread.currentThread().getName() + "进行了一次售票, 已售出" + (100 - ticketNum) + "/" + "100");
        }
    }


    public void sell01() {
        //此时传入什么对象，拿的就是什么对象的锁
        synchronized (this) {
            if (ticketNum > 0) {
                ticketNum--;
                System.out.println(Thread.currentThread().getName() + "进行了一次售票, 已售出" + (100 - ticketNum) + "/" + "100");
            }
        }
    }

    public static void sell02() {
        //此时传入什么对象，拿的就是什么对象的锁
        synchronized (SellTicket03.class) {
            if (ticketNum > 0) {
                ticketNum--;
                System.out.println(Thread.currentThread().getName() + "进行了一次售票, 已售出" + (100 - ticketNum) + "/" + "100");
            }
        }
    }
}



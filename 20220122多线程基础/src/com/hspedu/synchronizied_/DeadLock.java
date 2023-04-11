package com.hspedu.synchronizied_;

/**
 * @ClassName DeadLock
 * @Description 模拟线程死锁
 * @Author Jing Yilin
 * @Date 2022/1/23 14:31
 * @Version 1.0
 **/
public class DeadLock {
    public static void main(String[] args) {
        DeadLockDemo deadLockDemo01 = new DeadLockDemo(true);
        DeadLockDemo deadLockDemo02 = new DeadLockDemo(false);
        deadLockDemo01.start();
        deadLockDemo02.start();
    }
}

@SuppressWarnings("all")
class DeadLockDemo extends Thread {
    static Object o1 = new Object();
    static Object o2 = new Object();
    boolean flag;

    public DeadLockDemo(boolean flag) {
        this.flag = flag;
    }

    //1. 如果flag == true，线程A会先获取o1的对象锁
    //2. 如果线程A拿不到o2的对象锁，就会Blocked
    //3. 如果flag == false，线程B会先获取o1的对象锁
    //4. 如果线程B拿不到o1的对象锁，就会Blocked
    //5. 蚌埠住了
    @Override
    public void run() {
        if (flag) {
            synchronized (o1) {
                System.out.println(Thread.currentThread().getName() + "获取o1的对象锁");
                synchronized (o2) {
                    System.out.println(Thread.currentThread().getName() + "获取o2的对象锁");
                }
            }
        } else {
            synchronized (o2) {
                System.out.println(Thread.currentThread().getName() + "获取o2的对象锁");
                synchronized (o1) {
                    System.out.println(Thread.currentThread().getName() + "获取o1的对象锁");
                }
            }
        }
    }
}

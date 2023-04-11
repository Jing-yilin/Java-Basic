package com.hspedu.threaduse;

/**
 * @ClassName Thread01
 * @Description TODO 通过继承Thread类创建线程
 * @Author Jing Yilin
 * @Date 2022/1/21 14:58
 * @Version 1.0
 **/
public class Thread01 {
    public static void main(String[] args) throws InterruptedException{
        Cat cat = new Cat();
        //启动线程
        cat.start();//会调用run方法
        //说明：当main线程启动一个子线程 Thread-0, 主线程不会堵塞，会继续执行
        //这是, 主线程和子线程交替执行
        System.out.println("主线程执行" + Thread.currentThread().getName());
        for (int i = 0; i < 60; i++) {
            System.out.println("主线程 i =" + i);
            Thread.sleep(1000);
        }
    }
}


//说明：
//1. 当一个类继承了Thread，该类就可以当成线程使用
//2. 往往要重写run方法
//3. Thread的run() 实现来自 Runnable接口的run()
/*
* @Override
    public void run() {
        if (target != null) {
            target.run();
        }
    }
* */
class Cat extends Thread {

    int times = 0;
    //Thread的run()来自Runnable接口
    @Override
    public void run() {//重写run方法,写自己的逻辑
        do {
            //每隔一秒输出：“喵喵喵，我是小猫咪~”\
            times++;
            System.out.println("喵喵喵，我是小猫咪~" + times + " 线程名称 = " + Thread.currentThread().getName());
            //让该线程休眠1秒
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            //当输出5次，则退出线程
        } while (times != 80);
    }
}

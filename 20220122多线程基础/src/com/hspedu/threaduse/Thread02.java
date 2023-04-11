package com.hspedu.threaduse;

/**
 * @ClassName Thread02
 * @Description TODO 通过实现接口Runnable开发线程
 * @Author Jing Yilin
 * @Date 2022/1/22 16:49
 * @Version 1.0
 **/
public class Thread02 {
    public static void main(String[] args) {
        Dog dog = new Dog();
        //不能调用start dog.start()
        Thread thread = new Thread(dog);
        thread.start();
    }
}

//模拟一个简单的Thread
class ThreadProxy implements Runnable {//线程代理
    private Runnable target = null;
    @Override
    public void run() {
        if (target != null) {
            target.run();
        }
    }
    public ThreadProxy(Runnable target) {
        this.target = target;
    }

    public void start() {
        start0();
    }

    public void start0() {
        run();
    }
}

class Dog implements Runnable {

    int count = 0;
    @Override
    public void run() {
        do {
            System.out.println("摇滚不死！" + (++count) + Thread.currentThread().getName());
            //休眠1s
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        } while (count != 10);
    }

}
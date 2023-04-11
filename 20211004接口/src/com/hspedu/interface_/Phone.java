package com.hspedu.interface_;

//Phone类 实现UsbInterface
//1.Phone类需要实现UsbInterface声明的方法
public class Phone implements UsbInterface{
    @Override
    public void start() {
        System.out.println("手机开始工作!");
    }

    @Override
    public void stop() {
        System.out.println("手机停止工作!");
    }

    public void call(){
        System.out.println("打了个电话!");
    }
}

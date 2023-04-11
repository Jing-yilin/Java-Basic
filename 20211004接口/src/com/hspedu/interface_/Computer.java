package com.hspedu.interface_;

public class Computer {
    //方法的形参是接口
    //这个方法可以接受实现了这个接口的类的实例
    public void work(UsbInterface usbInterface){
        //通过接口调用方法
        usbInterface.start();
        usbInterface.stop();
    }
}

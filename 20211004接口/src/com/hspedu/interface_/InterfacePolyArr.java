package com.hspedu.interface_;

public class InterfacePolyArr {
    public static void main(String[] args) {

        //多态数组->接口类型
        Usb[] usbs = new Usb[2];
        usbs[0] = new MyCamera();
        usbs[1] = new MyPhone();

        for (int i = 0; i < usbs.length; i++) {
            usbs[i].work();
            //类型判断
            if(usbs[i] instanceof Phone){
                ((Phone) usbs[i]).call();
            }
        }
    }
}

interface Usb{
    void work();
}

class MyPhone implements Usb {
    public void call(){
        System.out.println("手机打电话！");
    }

    @Override
    public void work() {
        System.out.println("手机工作中!");
    }
}

class MyCamera implements Usb{

    @Override
    public void work() {
        System.out.println("相机工作中!");
    }
}

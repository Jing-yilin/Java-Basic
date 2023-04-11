package com.hspedu.homework;

/**
 * @ClassName Homwork02
 * @Description TODO
 * @Author Jing Yilin
 * @Date 2021/10/6 22:29
 * @Version 1.0
 **/
public class Homework02 {
}

class Frock{
    private static int currentNum = 100000;
    private int serialNumber;

    Frock(){
        this.serialNumber = getNextNum();
    }

    public int getSerialNumber() {
        return this.serialNumber;
    }

    public static int getNextNum(){
        currentNum += 100;
        return currentNum;
    }

}

class TestFrock{
    public static void main(String[] args) {
        Frock frock1 = new Frock();
        Frock frock2 = new Frock();
        Frock frock3 = new Frock();

        System.out.println(frock1.getSerialNumber());
        System.out.println(frock2.getSerialNumber());
        System.out.println(frock3.getSerialNumber());
    }
}
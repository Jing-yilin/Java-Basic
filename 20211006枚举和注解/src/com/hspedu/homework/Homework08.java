package com.hspedu.homework;

/**
 * @ClassName Homework08
 * @Description TODO
 * @Author Jing Yilin
 * @Date 2021/10/6 23:22
 * @Version 1.0
 **/
public class Homework08 {
    public static void main(String[] args) {
        for(Color color:Color.values()){
            color.show();
        }
    }
}

interface haha{
    void show();
}

enum Color implements haha{
    RED(255,0,0),
    BLUE(0,0,255),
    BLACK(0,0,0),
    YELLOW(255,255,0),
    GREEN(0,255,0);

    private int redValue;
    private int greenValue;
    private int blueValue;

    Color(int redValue, int greenValue, int blueValue) {
        this.redValue = redValue;
        this.greenValue = greenValue;
        this.blueValue = blueValue;
    }

    @Override
    public void show() {
        System.out.println("===="+this.name()+"====");
        System.out.printf("R:" + this.redValue + "\t");
        System.out.printf("G:" + this.greenValue + "\t");
        System.out.printf("B:" + this.blueValue + "\n");
    }
}

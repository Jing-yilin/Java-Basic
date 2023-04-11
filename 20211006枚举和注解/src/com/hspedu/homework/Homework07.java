package com.hspedu.homework;

/**
 * @ClassName Homework07
 * @Description TODO
 * @Author Jing Yilin
 * @Date 2021/10/6 23:13
 * @Version 1.0
 **/
public class Homework07 {
    public static void main(String[] args) {
        Car car1 = new Car(60);
        Car car2 = new Car(-6);
        Car car3 = new Car(24);
        car1.new Air().flow();
        car2.new Air().flow();
        car3.new Air().flow();
    }

}

class Car{
    private double temperature;

    class Air{
         void flow(){
            if(temperature > 40){
                System.out.println("吹冷气");
            } else if (temperature < 0){
                System.out.println("吹暖气");
            } else {
                System.out.println("空调已关闭!");
            }
        }
    }

    public Car(double temperature) {
        this.temperature = temperature;
    }
}

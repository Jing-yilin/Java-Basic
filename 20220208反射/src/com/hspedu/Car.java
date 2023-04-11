package com.hspedu;

/**
 * @ClassName Car
 * @Description TODO
 * @Author Jing Yilin
 * @Date 2022/2/9 11:52
 * @Version 1.0
 **/
public class Car {
    public String brand = "BMW";
    public int price = 500000;
    public String color = "white";

    @Override
    public String toString() {
        return "Car{" +
                "brand='" + brand + '\'' +
                ", price=" + price +
                ", color='" + color + '\'' +
                '}';
    }
}

package com.hspedu.homeworks;

import java.util.ArrayList;
import java.util.Objects;

/**
 * @ClassName Homework02
 * @Description TODO
 * @Author Jing Yilin
 * @Date 2022/1/19 19:16
 * @Version 1.0
 **/
@SuppressWarnings("all")
public class Homework02 {
    public static void main(String[] args) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new Car("Model S", 29999));
        arrayList.add(new Car("Model X", 19999));
        arrayList.add(new Car("Model Y", 59999));
        arrayList.remove(new Car("Model S", 29999));

    }
}
class Car{
    private String name;
    private double price;

    public Car(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return Objects.equals(name, car.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, price);
    }
}

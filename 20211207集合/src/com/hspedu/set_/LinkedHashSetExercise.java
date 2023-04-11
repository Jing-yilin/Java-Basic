package com.hspedu.set_;

import java.util.LinkedHashSet;
import java.util.Objects;

/**
 * @ClassName LinkedHashSetExercise
 * @Description TODO
 * @Author Jing Yilin
 * @Date 2021/12/20 20:21
 * @Version 1.0
 **/
@SuppressWarnings("all")
public class LinkedHashSetExercise {
    public static void main(String[] args) {
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        System.out.println(linkedHashSet.add(new Car("法拉利", 330000)));//true
        System.out.println(linkedHashSet.add(new Car("保时捷", 630000)));//true
        System.out.println(linkedHashSet.add(new Car("奥迪", 330000)));//true
        System.out.println(linkedHashSet.add(new Car("法拉利", 730000)));//true
        System.out.println(linkedHashSet.add(new Car("法拉利", 330000)));//false
    }
}
@SuppressWarnings("all")
class Car{
    private String name;
    private double price;

    public Car(String name, double price) {
        this.name = name;
        this.price = price;
    }

    /*
    * 名字和价格一样则认为是相同元素，不能再添加
    * */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return Double.compare(car.price, price) == 0 && Objects.equals(name, car.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, price);
    }
}
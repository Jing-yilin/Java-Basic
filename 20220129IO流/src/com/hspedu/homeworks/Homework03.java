package com.hspedu.homeworks;

import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

/**
 * @ClassName Homework03
 * @Description TODO
 * @Author Jing Yilin
 * @Date 2022/2/1 20:33
 * @Version 1.0
 **/
@SuppressWarnings("all")
public class Homework03 {
    public static void main(String[] args) throws IOException {
        String fileName = "src\\dog.properties";
        Properties properties = new Properties();
        Dog dog = new Dog("旺财", 5, "Yellow");
        properties.setProperty("name", dog.name);
        properties.setProperty("age", new Integer(dog.age).toString());
        properties.setProperty("color", dog.color);
        properties.store(new FileOutputStream(fileName), null);
        System.out.println("存储成功~");
    }

}
class Dog {
    String name;
    int age;
    String color;

    public Dog(String name, int age, String color) {
        this.name = name;
        this.age = age;
        this.color = color;
    }

    @Override
    public String toString() {
        return "Dog{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", color='" + color + '\'' +
                '}';
    }
}

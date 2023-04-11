package com.hspedu.homeworks;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

/**
 * @ClassName Homework04
 * @Description TODO
 * @Author Jing Yilin
 * @Date 2022/2/1 20:59
 * @Version 1.0
 **/
public class Homework04 {
    public static void main(String[] args) throws IOException {
        String fileName = "src\\dog.properties";
        Properties properties = new Properties();
        properties.load(new FileReader(fileName));
        String name = properties.getProperty("name");
        int age = Integer.parseInt(properties.getProperty("age"));
        String color = properties.getProperty("color");

        Dog dog = new Dog(name, age, color);
        System.out.println(dog);
    }
}

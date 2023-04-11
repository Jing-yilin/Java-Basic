package com.hspedu.reflection.class_;

import com.hspedu.Car;

/**
 * @ClassName GetClass
 * @Description 演示得到Class对象的各种方式
 * @Author Jing Yilin
 * @Date 2022/2/9 12:28
 * @Version 1.0
 **/
public class GetClass {
    public static void main(String[] args) throws Exception{
        //1. Class.forName()
        String classFullPath = "com.hspedu.Car";
        Class<?> cls = Class.forName(classFullPath);

        //2. 类名.class
        Class<Car> carClass = Car.class;
        System.out.println(carClass);//class com.hspedu.Car

        //3. 实例.getClass
        Car car = new Car();
        System.out.println(car.getClass());//class com.hspedu.Car

        //4. 通过类加载器获取
        //(1) 先得到Cat的类加载器
        ClassLoader classLoader = car.getClass().getClassLoader();
        //(2) 通过类加载器得到Class对象
        Class<?> cls4 = classLoader.loadClass(classFullPath);
        System.out.println(cls4);//class com.hspedu.Car

        //5. 基本数据类型(int, char, boolean, float, double, byte, long, short)
        Class<Integer> integerClass = int.class;
        Class<Character> characterClass = char.class;
        Class<Boolean> booleanClass = boolean.class;
        System.out.println(integerClass);//int
        System.out.println(characterClass);//char
        System.out.println(booleanClass);//boolean

        //6. 基本数据类型对应的包装类，可以通过 .TYPE 得到Class对象
        Class<Integer> integerType = Integer.TYPE;
        System.out.println(integerType);//int

    }
}

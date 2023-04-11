package com.hspedu.reflection;

import java.lang.reflect.Constructor;

/**
 * @ClassName ReflectionCreateInstance
 * @Description 演示通过反射创建实例
 * @Author Jing Yilin
 * @Date 2022/2/9 14:53
 * @Version 1.0
 **/
public class ReflectionCreateInstance {
    public static void main(String[] args) throws Exception{
        //1. 先获取到User的Class对象
        Class<?> cls = Class.forName("com.hspedu.reflection.User");
        //2. 通过public的无参构造器创建实例
        Object o = cls.newInstance();
        System.out.println(o);
        //3. 通过public的有参构造器创建实例
        Constructor<?> constructor = cls.getConstructor(String.class);
        Object o1 = constructor.newInstance("jyl");
        System.out.println(o1);
        //4. 通过非public的有参构造器创建实例
        Constructor<?> constructor1 = cls.getDeclaredConstructor(int.class, String.class);
        constructor1.setAccessible(true);//爆破
        Object o2 = constructor1.newInstance(11, "jyl");
        System.out.println(o2);
    }
}


class User{
    private int age;
    private String name;
    public User(){

    }

    public User(String name) {
        this.name = name;
    }

    private User(int age, String name) {
        this.age = age;
        this.name = name;
    }

    @Override
    public String toString() {
        return "User{" +
                "age=" + age +
                ", name='" + name + '\'' +
                '}';
    }

}
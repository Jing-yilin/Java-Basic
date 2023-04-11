package com.hspedu.reflection;

import java.io.FileInputStream;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Properties;

/**
 * @ClassName Reflection01
 * @Description TODO
 * @Author Jing Yilin
 * @Date 2022/2/9 11:06
 * @Version 1.0
 **/
@SuppressWarnings("all")
public class Reflection01 {
    public static void main(String[] args) throws Exception {
        //读取properties的内容
        Properties properties = new Properties();
        properties.load(new FileInputStream("src\\re.properties"));
        String classFullPath = properties.getProperty("classFullPath");//类的全路径
        String method = properties.getProperty("method");

        //使用反射机制
        //(1) 加载类
        Class cls = Class.forName(classFullPath);
        //(2) 通过 cls 得到加载类的对象实例
        Object o = cls.newInstance();
        System.out.println("o的运行时类型为" + o.getClass());
        //(3) 通过 cls得到加载类的 的 hi 的方法对象
        Method method1 = cls.getMethod(method);
        //(4) 通过 method1 调用方法：即通过方法对象来实现调用方法
        method1.invoke(o);

        //java.lang.reflect.Field
        //getField不能得到私有属性
        Field ageField = cls.getField("age");
        System.out.println("ageField.get(o) = " + ageField.get(o));

        //getConstructor
        Constructor constructor = cls.getConstructor();//返回无参构造器
        System.out.println("constructor = " + constructor);

        //这个构造器可以帮我们获取实例
        Object o1 = constructor.newInstance();

        Constructor constructor1 = cls.getConstructor(String.class);//返回一个有参构造器
        System.out.println("constructor1 = " + constructor1);
    }
}

package com.hspedu.reflection.question;

import java.io.FileInputStream;
import java.lang.reflect.Method;
import java.util.Properties;

/**
 * @ClassName ReflectionQuestion
 * @Description 引入反射
 * @Author Jing Yilin
 * @Date 2022/2/9 10:28
 * @Version 1.0
 **/
@SuppressWarnings("all")
public class ReflectionQuestion {
    public static void main(String[] args) throws Exception{
        //读取properties的内容
        Properties properties = new Properties();
        properties.load(new FileInputStream("src\\re.properties"));
        String classFullPath = properties.getProperty("classFullPath");//类的全路径
        String method = properties.getProperty("method");
        System.out.println("classFullPath = " + classFullPath);
        System.out.println("method = " + method);

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

    }
}

package com.hspedu.reflection;

import com.hspedu.Cat;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Constructor;

/**
 * @ClassName Reflection02
 * @Description 比较传统方法和反射的性能
 * @Author Jing Yilin
 * @Date 2022/2/9 11:16
 * @Version 1.0
 **/
public class Reflection02 {
    public static void main(String[] args) {
    }

    //传统方法调用hi()
    @Test
    public void m1(){
        long l1 = System.currentTimeMillis();
        Cat cat = new Cat();
        for (int i = 0; i < 900000000; i++) {
            cat.addAge();
        }
        long l2 = System.currentTimeMillis();
        System.out.println("传统方法耗时" + (l2-l1) + "ms");
        //传统方法耗时75ms
    }

    //使用反射机制
    @Test
    @SuppressWarnings("all")
    public void m2() throws Exception{
        Class cls = Class.forName("com.hspedu.Cat");
        Object o = cls.newInstance();
        Method addAge = cls.getMethod("addAge");
        long l1 = System.currentTimeMillis();
        for (int i = 0; i < 900000000; i++) {
            addAge.invoke(o);
        }
        long l2 = System.currentTimeMillis();
        System.out.println("使用反射耗时" + (l2-l1) + "ms");
        //使用反射耗时2699ms
    }

    //反射调用优化
    @Test
    @SuppressWarnings("all")
    public void m3() throws Exception{
        Class cls = Class.forName("com.hspedu.Cat");
        Object o = cls.newInstance();
        Method addAge = cls.getMethod("addAge");
        addAge.setAccessible(true);//取消访问检查
        long l1 = System.currentTimeMillis();
        for (int i = 0; i < 900000000; i++) {
            addAge.invoke(o);
        }
        long l2 = System.currentTimeMillis();
        System.out.println("使用反射耗时" + (l2-l1) + "ms");
        //使用反射耗时2263ms
    }


}

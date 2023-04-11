package com.hspedu.reflection;

import java.lang.reflect.Field;

/**
 * @ClassName ReflectionAccessProperty
 * @Description 演示反射操作属性
 * @Author Jing Yilin
 * @Date 2022/2/9 15:25
 * @Version 1.0
 **/
public class ReflectionAccessProperty {
    public static void main(String[] args) throws Exception{
        //1. 得到Class对象
        Class<?> cls = Class.forName("com.hspedu.reflection.Student");
        //2. 创建对象
        Object o = cls.newInstance();
        System.out.println(o.getClass());
        //3. 使用反射得到age
        Field age = cls.getField("age");
        age.set(o, 88);
        System.out.println(o);//Student{age=88,name=null}
        //4. 使用反射操作私有静态属性
        Field name = cls.getDeclaredField("name");
        name.setAccessible(true);
        name.set(null, "jyl");
        System.out.println(o);//Student{age=88,name=jyl}
        System.out.println(name.get(o));
        System.out.println(name.get(null));//静态属性可以用null
    }
}
class Student{
    public int age;
    private static String name;

    public Student(){

    }

    @Override
    public String toString() {
        return "Student{" +
                "age=" + age + ","+
                "name=" + name +
                '}';
    }
}
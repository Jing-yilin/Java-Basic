package com.hspedu.reflection.class_;

import java.lang.reflect.Field;

/**
 * @ClassName Class02
 * @Description 演示Class类的常用方法
 * @Author Jing Yilin
 * @Date 2022/2/9 11:52
 * @Version 1.0
 **/
public class Class02 {
    public static void main(String[] args) throws Exception {
        String classFullPath = "com.hspedu.Car";
        //1. 获取Car类对应的class对象
        //<?>表示不确定的Java类型
        Class<?> cls = Class.forName(classFullPath);
        //2. 输出cls
        System.out.println(cls);//class com.hspedu.Car
        System.out.println( cls.getClass());//class java.lang.Class
        //3. 得到包名
        System.out.println(cls.getPackage().getName());//com.hspedu
        //4. 得到类名
        System.out.println(cls.getName());//com.hspedu.Car
        //5. 通过cls创建对象实例
        Object o = cls.newInstance();
        System.out.println(o);//Car{brand='BMW', price=500000, color='white'}
        //6. 通过反射获取属性
        Field brand = cls.getField("brand");
        System.out.println(brand.get(o));//BMW
        //7. 通过反射给属性赋值
        brand.set(o, "奔驰");
        System.out.println(brand.get(o));//奔驰
        //8. 拿到所有的字段属性
        Field[] fields = cls.getFields();
        for (int i = 0; i < fields.length; i++) {
            System.out.print(fields[i] + "\t");//public java.lang.String com.hspedu.Car.brand	public int com.hspedu.Car.price	public java.lang.String com.hspedu.Car.color
        }
    }
}

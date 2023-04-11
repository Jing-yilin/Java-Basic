package com.hspedu.reflection.class_;

import com.hspedu.Cat;

/**
 * @ClassName Class01
 * @Description 梳理Class类的特点
 * @Author Jing Yilin
 * @Date 2022/2/9 11:35
 * @Version 1.0
 **/
public class Class01 {
    public static void main(String[] args) throws Exception {
        //Class类对象不是new出来的，而是系统创建的
        //(1) 传统创建
        /**
         * public Class<?> loadClass(String name) throws ClassNotFoundException {
         *         return loadClass(name, false);
         *     }
         */
        Cat cat = new Cat();

        //(2) 反射方式创建
        /**
         * public static Class<?> forName(String className)
         *                 throws ClassNotFoundException {
         *         Class<?> caller = Reflection.getCallerClass();
         *         return forName0(className, true, ClassLoader.getClassLoader(caller), caller);
         *     }
         *
         * public Class<?> loadClass(String name) throws ClassNotFoundException {
         *         return loadClass(name, false);
         *     }
         */
        Class<?> cls = Class.forName("com.hspedu.Cat");
        Object o = cls.newInstance();

        //可以发现传统方法和反射方式都会去调用loadClass()
        System.out.println("cat.getClass().hashCode() = " + cat.getClass().hashCode());//1554874502
        System.out.println("cls.hashCode() = " + cls.hashCode());//1554874502
        //因此得出结论==>只会生成一个class对象
    }
}

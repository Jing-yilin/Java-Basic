package com.hspedu.reflection.class_;

import java.io.Serializable;

/**
 * @ClassName AllTypeClass
 * @Description 演示哪些类型有Class对象
 * @Author Jing Yilin
 * @Date 2022/2/9 12:47
 * @Version 1.0
 **/
public class AllTypeClass {
    public static void main(String[] args) {
        Class<String> stringClass = String.class;//外部类
        Class<Serializable> serializableClass = Serializable.class;//接口
        Class<Integer[]> aClass1 = Integer[].class;//一维数组
        Class<Integer[][]> aClass2 = Integer[][].class;//二位数组
        Class<Integer[][][]> aClass3 = Integer[][][].class;//三维数组
        Class<Deprecated> deprecatedClass = Deprecated.class;//注解
        Class<Thread.State> stateClass = Thread.State.class;//枚举
        Class<Long> longClass = long.class;
        Class<Void> voidClass = void.class;//void
        Class<Class> classClass = Class.class;//Class类的class对象
        System.out.println(Class.class.getClass().getClass().getClass());//class java.lang.Class
    }
}

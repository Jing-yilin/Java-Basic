package com.hspedu.reflection;

import java.lang.reflect.Method;

/**
 * @ClassName ReflectionAccessMethod
 * @Description TODO
 * @Author Jing Yilin
 * @Date 2022/2/9 15:38
 * @Version 1.0
 **/
public class ReflectionAccessMethod {
    public static void main(String[] args) throws Exception{
        //1.得到Class对象
        Class<?> cls = Class.forName("com.hspedu.reflection.Boss");

        //2. 创建对象
        Object o = cls.newInstance();

        //3. 调用public的hi()
//        Method hi = cls.getMethod("hi", String.class);
        Method hi = cls.getDeclaredMethod("hi", String.class);
        hi.invoke(o, "景风眠");//hi景风眠

        //4. 调用私有静态方法
        Method say = cls.getDeclaredMethod("say", int.class, String.class, char.class);
        say.setAccessible(true);//爆破
        System.out.println(say.invoke(null, 2, "jyl", 'u'));//2 jyl u


    }
}

class Boss{
    public int age;
    private static String name;

    public Boss(){

    }
    //静态私有
    private static String say(int n, String s, char c){
        return n + " " + s + " " + c;
    }
    //public普通
    public void hi(String s){
        System.out.println("hi" + s);
    }
}
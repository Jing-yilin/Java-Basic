package com.hspedu.customgeneric;

import java.util.ArrayList;

/**
 * @ClassName CustomMethodGenric
 * @Description TODO
 * @Author Jing Yilin
 * @Date 2022/1/20 13:52
 * @Version 1.0
 **/
public class CustomMethodGeneric {
    public static void main(String[] args) {
        Car car = new Car();
        car.fly("宝马",100);//泛型方法是在调用的时候根据传入参数确定的
        //class java.lang.String
        //class java.lang.Integer

        //ArrayList<Object> strings = new ArrayList<String>();//错误
    }
}

//泛型方法，可以定义在普通类中，也可以定义在泛型类中

//普通类
class Car {
    ///普通方法
    public void run() {

    }
    //泛型方法
    public <T, R> void fly(T t, R r){
        System.out.println(t.getClass());
        System.out.println(r.getClass());
    }


}

//泛型类
class Fish<T, R>{
    public void run() {

    }
    //泛型方法
    public <U, M> void eat(U u, M m) {

    }

    //这不是一个泛型方法，而是一个使用了类的泛型的方法
    public void hi(T t)
    {

    }
    //泛型方法，同时使用了类的泛型
    public <K> void hello(R r, K k){

    }
}
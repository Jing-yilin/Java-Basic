package com.hspedu.customgeneric;

/**
 * @ClassName CustomGeneric_
 * @Description TODO
 * @Author Jing Yilin
 * @Date 2022/1/20 13:10
 * @Version 1.0
 **/
public class CustomGeneric_ {
    public static void main(String[] args) {

    }
}

//1. 普通成员可以使用泛型（属性方法）
//2. 使用泛型的数组，不能初始化
//3. 静态方法、静态属性中不能有类的泛型
//4. 泛型类的类型，是在创建对象时确定的
//5. 如果在创建对象时没有确定默认为Object
class Tiger<T, R, M> {
    String name;
    //static R r2; //会报错
    R r; // 属性可以使用泛型
    M m;
    T t;

    //不能实例化泛型数组，因为不知道T的类型就不确定开辟空间大小
    //R[] list = new R[8];
    R[] list;//这样是可以的

    public Tiger(String name, R r, M m, T t) {
        this.name = name;
        this.r = r;
        this.m = m;
        this.t = t;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public R getR() {
        return r;
    }
    //方法使用泛型
    public void setR(R r) {
        this.r = r;
    }

    public M getM() {
        return m;// 返回类型可以使用泛型
    }

    public void setM(M m) {
        this.m = m;
    }

    public T getT() {
        return t;
    }

    public void setT(T t) {
        this.t = t;
    }
}
package com.hspedu.annotation_;

/**
 * @ClassName Deprecated_
 * @Description TODO
 * @Author Jing Yilin
 * @Date 2021/10/6 21:18
 * @Version 1.0
 **/
public class Deprecated_ {
    public static void main(String[] args) {
        A a = new A();
        a.hi();
    }
}

//@Deprecated修饰某个类表示给元素已经过时了
//即不再推荐使用，但仍然可以使用
//可以做版本升级过渡使用
@Deprecated
class A{
    public int n1 = 10;
    @Deprecated
    public void hi(){

    }
}

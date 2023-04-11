package com.hspedu.throws_;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

/**
 * @ClassName ThrowsDetail
 * @Description TODO
 * @Author Jing Yilin
 * @Date 2021/10/8 12:00
 * @Version 1.0
 **/
public class ThrowsDetail {
    public static void main(String[] args) {

    }
    public static void f1() throws FileNotFoundException{
        //发现直接调用f3()会报错，因为f3()里面的是编译异常,编译异常必须处理！
        //f3()的编译异常抛给上级函数f1()，需要f1()显示地处理异常
        //要么使用try-catch,要么继续throws编译异常
        f3();
    }

    public static void f3() throws FileNotFoundException {
        FileInputStream fis = new FileInputStream("dd.txt");
    }

    public static void f4() {
        //在f4()调用f5()是OK的
        //因为f5里是运行异常，不是编译异常
        //java里，对于编译异常，并不要求程序员显式处理，有默认处理机制
        f5();
    }

    public static void f5() throws ArithmeticException {

    }
}

class Father {
    public void method() throws RuntimeException{

    }
}

class Son extends Father {
    //子类重写父类的方法时，对抛出异常的规定：
    // 子类重写的方法所抛出的异常类型要么和父类抛出的一致，
    // 要么为父类抛出异常类型的子类型。
    @Override
    public void method() throws NullPointerException {

    }
}

package com.hspedu.customexception_;

/**
 * @ClassName ThrowException
 * @Description TODO 对throws和throw有更深的理解
 * @Author Jing Yilin
 * @Date 2021/10/9 22:48
 * @Version 1.0
 **/
public class ThrowException {
    public static void main(String[] args) {
        try {
            ReturnExceptionDemo.methodA();
        } catch (Exception e){
            System.out.println(e.getMessage());
        }
        ReturnExceptionDemo.methodB();
    }
}

class ReturnExceptionDemo{
    static void methodA(){
        try {
            System.out.println("进入方法A");
            throw new RuntimeException("制造异常");
        } finally {
            System.out.println("用A的finally方法");
        }
    }
    static void methodB(){
        try {
            System.out.println("进入方法B");
        } finally {
            System.out.println("调用B的方法的finally");
        }
    }
}

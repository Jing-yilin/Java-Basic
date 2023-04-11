package com.hspedu.exception_;

/**
 * @ClassName Exception01
 * @Description TODO:异常处理
 * @Author Jing Yilin
 * @Date 2021/10/7 7:32
 * @Version 1.0
 **/
public class Exception01 {
    public static void main(String[] args) {
        try{
            int n1 = 10;
            int n2 = 0;
            // n1 / n2 => 10 / 0
            int res = n1/n2;
        } catch (Exception e){
            //TODO:handle exception
            //e.printStackTrace();//打印异常堆栈，即将异常出错的代码和信息输出
            System.out.println("异常信息=" + e.getMessage());
        }
        System.out.println("程序继续运行……");
    }
}

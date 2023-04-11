package com.hspedu.exception_;

/**
 * @ClassName NumberFormatException_
 * @Description TODO
 * @Author Jing Yilin
 * @Date 2021/10/7 8:14
 * @Version 1.0
 **/
public class NumberFormatException_ {
    public static void main(String[] args) {
        String name = "Jack";
        //将 String 解析成 int
        int num = Integer.parseInt(name);

        try{
            //代码/可能有异常
        } catch (Exception e) {
            //捕获异常,只有当异常发生时执行
            //1.当异常发生时
            //2.系统将异常封装成Exception对象e,，传递给catch
            //3.得到异常对象后，程序员自己处理
        } finally {
            //不管有没有异常，finally一定要执行
        }
    }
}

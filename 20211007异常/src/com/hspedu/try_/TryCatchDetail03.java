package com.hspedu.try_;

/**
 * @ClassName TryCatchDetail03
 * @Description TODO
 * @Author Jing Yilin
 * @Date 2021/10/7 9:03
 * @Version 1.0
 **/
public class TryCatchDetail03 {
    public static void main(String[] args) {
        try{
            int n1 = 10;
            int n2 = 0;
            System.out.println(n1 / n2);
        } finally {
            System.out.println("执行了finally...");
        }

        //不会继续运行，程序运行完finally后直接崩溃
        System.out.println("程序继续运行...");
    }
}

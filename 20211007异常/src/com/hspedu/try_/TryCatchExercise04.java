package com.hspedu.try_;

import java.util.Scanner;

/**
 * @ClassName TryCatchExercise04
 * @Description TODO
 * @Author Jing Yilin
 * @Date 2021/10/7 11:08
 * @Version 1.0
 **/
public class TryCatchExercise04 {
    /* 1.创建Scanner
     * 2.使用无限循环去接受一个输入
     * 3.然后将输入的值转化为int
     * 4.如果在转化时抛出异常，则说明输入内容不能转化为int
     * 5.如果没有抛出，则break该循环*/
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num = 0;
        while (true) {
            System.out.println("请输入一个整数：\n");
            try {
                num = Integer.parseInt(scanner.next());
                break;
            } catch (NumberFormatException e) {
                System.out.println("输入有误，请重新输入！\n");
            }
        }
        System.out.printf("您的输入为: " + num);
    }
}

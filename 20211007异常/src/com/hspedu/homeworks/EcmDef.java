package com.hspedu.homeworks;

import java.io.InputStream;
import java.util.Scanner;

/**
 * @ClassName EcmDef
 * @Description TODO
 * @Author Jing Yilin
 * @Date 2021/10/9 23:00
 * @Version 1.0
 **/
public class EcmDef {
    public static double cal(int n1, int n2){
        if (n2 == 0){
            throw new ArithmeticException();
        }
        return (double) n1 / n2;
    }
}

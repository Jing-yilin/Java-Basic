package com.hspedu.bignum_;

import java.math.BigInteger;

/**
 * @ClassName BigInteger_
 * @Description TODO
 * @Author Jing Yilin
 * @Date 2021/12/2 9:44
 * @Version 1.0
 **/
public class BigInteger_
{
    public static void main(String[] args) {
        //当编程中需要很大的数,long不够用
        //可以使用BigInteger类
//        long l= 123123199999999992312l;
//        System.out.println("l = " + l);

        BigInteger bigInteger = new BigInteger("12423511234315345678123");
        BigInteger bigInteger2 = new BigInteger("100");
        System.out.println(bigInteger);
        //1. 在对BigInteger进行加减乘除时，需要使用对应的方法
        //2. 可以创建一个 要操作的 BigInteger 然后进行相应操作
        System.out.println("========add========");
        BigInteger add = bigInteger.add(bigInteger2);
        System.out.println(add);
        System.out.println("========subtract========");
        BigInteger subtract = bigInteger.subtract(bigInteger2);
        System.out.println(subtract);
        System.out.println("========multiply========");
        BigInteger multiply = bigInteger.multiply(bigInteger2);
        System.out.println(multiply);
        System.out.println("========divide========");
        BigInteger divide = bigInteger.divide(bigInteger2);
        System.out.println(divide);
    }
}

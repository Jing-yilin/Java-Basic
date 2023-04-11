package com.hspedu.bignum_;

import java.math.BigDecimal;

/**
 * @ClassName BigDecimal
 * @Description TODO
 * @Author Jing Yilin
 * @Date 2021/12/2 9:52
 * @Version 1.0
 **/
public class BigDecimal_ {
    public static void main(String[] args) {
        double d = 199.11111111111111111111111;
        System.out.println("=========使用double=========");
        System.out.println(d);//199.11111111111111

        System.out.println("=========使用BigDecimal=========");
        BigDecimal bigDecimal = new BigDecimal("199.11111111111111111111111");
        BigDecimal bigDecimal2 = new BigDecimal("1.111");
        System.out.println(bigDecimal);

        //如果对BigDecimal进行运算，需要使用对应的方法
        System.out.println("===========add==========");
        System.out.println(bigDecimal.add(bigDecimal2));
        System.out.println("===========subtract==========");
        System.out.println(bigDecimal.subtract(bigDecimal2));
        System.out.println("===========multiply==========");
        System.out.println(bigDecimal.multiply(bigDecimal2));
        System.out.println("===========divide==========");
//        System.out.println(bigDecimal.divide(bigDecimal2));//可能抛出异常，无限循环小数
        //在调用divide方式时指定精度即可
        System.out.println(bigDecimal.divide(bigDecimal2, BigDecimal.ROUND_CEILING));//

    }
}

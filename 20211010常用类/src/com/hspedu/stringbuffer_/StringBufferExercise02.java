package com.hspedu.stringbuffer_;

import java.util.Scanner;

/**
 * @ClassName StringBufferExercise02
 * @Description TODO
 * @Author Jing Yilin
 * @Date 2021/10/20 8:19
 * @Version 1.0
 **/
public class StringBufferExercise02 {
    public static void main(String[] args) {
        /*1.定义一个Scanner对象，接受用户输入的价格
          2.希望使用StringBuffer的insert，需要将String转成StringBuffer
          3.然后使用相关方法进行字符串的处理
        * */

        String price = "123569.59";
        StringBuffer sb = new StringBuffer(price);
        //先转换成123,564.59
        //找到小数点的索引，然后在该位置的前三位，插入都好即可
        for (int i = sb.lastIndexOf(".")-3; i > 0; i-=3) {
            sb = sb.insert(i, ",");
        }
        System.out.println(sb);
    }
}

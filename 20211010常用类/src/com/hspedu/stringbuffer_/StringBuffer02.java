package com.hspedu.stringbuffer_;

/**
 * @ClassName StringBuffer02
 * @Description TODO
 * @Author Jing Yilin
 * @Date 2021/10/14 10:21
 * @Version 1.0
 **/
public class StringBuffer02 {
    public static void main(String[] args) {
        //构造器的使用
        // 1.创建一个大小为16的 char[]，用于存放字符序列
        StringBuffer stringBuffer = new StringBuffer();

        // 2.通过构造器指定char[]容量的大小
        StringBuffer stringBuffer1 = new StringBuffer(100);

        // 3.通过给一个String 创建StringBuffer
        //   容量为5+16 = 21
        StringBuffer stringBuffer2 = new StringBuffer("Hello");
    }
}

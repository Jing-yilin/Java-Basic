package com.hspedu.stringbuffer_;

/**
 * @ClassName StringAndStringBuffer
 * @Description TODO
 * @Author Jing Yilin
 * @Date 2021/10/14 10:26
 * @Version 1.0
 **/
public class StringAndStringBuffer {
    public static void main(String[] args) {

        //String-->StringBuffer
        String str = "hello tom";

        // 方式1：使用构造器。返回String值，对str本身没有影响
        StringBuffer stringBuffer = new StringBuffer(str);

        // 方式2：使用append方法
        StringBuffer stringBuffer1 = new StringBuffer();
        StringBuffer append = stringBuffer1.append(str);

        //StringBuffer-->String
        StringBuffer stringBuffer2 = new StringBuffer("景风眠");

        // 方式1：使用toString()
        String s = stringBuffer2.toString();

        // 方式2：使用构造器直接构造
        String s1 = new String(stringBuffer2);


    }
}

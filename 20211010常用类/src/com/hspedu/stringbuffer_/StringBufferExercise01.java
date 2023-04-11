package com.hspedu.stringbuffer_;

/**
 * @ClassName StringBufferExercise01
 * @Description TODO
 * @Author Jing Yilin
 * @Date 2021/10/14 10:49
 * @Version 1.0
 **/
public class StringBufferExercise01 {
    public static void main(String[] args) {
        String str = null;
        StringBuffer sb = new StringBuffer();
        sb.append(str);//调用appendNull()
        System.out.println(sb.length());//4
        System.out.println(sb);//null

        //下面的构造器会抛出空指针异常NullPointerException
        StringBuffer sb1 = new StringBuffer(str);//传入空值.会使用String.length(),但是String为空
        System.out.println(sb1);//
    }
}

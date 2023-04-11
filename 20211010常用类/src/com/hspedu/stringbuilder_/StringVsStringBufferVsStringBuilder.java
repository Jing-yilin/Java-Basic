package com.hspedu.stringbuilder_;

/**
 * @ClassName StringVsStringBufferVsString
 * @Description TODO
 * @Author Jing Yilin
 * @Date 2021/10/20 8:51
 * @Version 1.0
 **/
public class StringVsStringBufferVsStringBuilder {
    public static void main(String[] args) {
        String text = "";
        long startTime = 0L;
        long endTime = 0L;
        StringBuffer buffer = new StringBuffer();
        StringBuilder builder = new StringBuilder();

        ///////////////////////////////////////
        startTime = System.currentTimeMillis();
        for (int i = 0; i < 20000; i++) {
            buffer.append(String.valueOf(i));
        }
        endTime = System.currentTimeMillis();
        System.out.println("StringBuffer执行时间: " + (endTime-startTime));

        ///////////////////////////////////////
        startTime = System.currentTimeMillis();
        for (int i = 0; i < 20000; i++) {
            builder.append(String.valueOf(i));
        }
        endTime = System.currentTimeMillis();
        System.out.println("StringBuilder执行时间: " + (endTime-startTime));

        ///////////////////////////////////////
        startTime = System.currentTimeMillis();
        for (int i = 0; i < 20000; i++) {
            text += i;
        }
        endTime = System.currentTimeMillis();
        System.out.println("String执行时间: " + (endTime-startTime));
    }
}

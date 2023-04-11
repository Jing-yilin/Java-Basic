package com.hspedu.stringbuffer_;

/**
 * @ClassName StringBufferMethod
 * @Description TODO
 * @Author Jing Yilin
 * @Date 2021/10/14 10:32
 * @Version 1.0
 **/
public class StringBufferMethod {
    public static void main(String[] args) {
        //StringBuffer的常用方法

        StringBuffer s = new StringBuffer("hello");

        //增，返回的还是StringBuffer
        s.append(',');
        s.append("张三丰");
        s.append("景风眠").append(100).append(true).append(10.5);
        System.out.println(s);//hello,张三丰景风眠100true10.5

        //删
        /*
        * 删除索引为>=start && <end 处的字符
        */
        s.delete(12,23);
        System.out.println(s);//hello,张三丰景风眠

        //改
        s.replace(6,9,"程隰");
        System.out.println(s);//hello,程隰景风眠

        //查
        int indexOf = s.indexOf("程隰");
        System.out.println(indexOf);//6

        //插
        s.insert(8, "喜欢");
        System.out.println(s);//hello,程隰喜欢景风眠

        //长度
        System.out.println(s.length());//13
        System.out.println(s);//hello,程隰喜欢景风眠

    }
}

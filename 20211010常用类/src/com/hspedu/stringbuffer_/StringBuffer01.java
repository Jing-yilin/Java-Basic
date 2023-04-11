package com.hspedu.stringbuffer_;

/**
 * @ClassName StringBuffer01
 * @Description TODO
 * @Author Jing Yilin
 * @Date 2021/10/14 10:03
 * @Version 1.0
 **/
public class StringBuffer01 {
    public static void main(String[] args) {
        // 1.StringBuffer 的直接父类是 AbstractStringBuilder
        // 2.StringBuffer 实现了 Serializable，即可串行化
        // 3.在父类中 AbstractStringBuilder 有属性 char[] value,不是final，存放字符串内容，放在堆中
        // 4.StringBuffer 也是 final 类,不能被继承
        StringBuffer stringBuffer = new StringBuffer();
    }
}

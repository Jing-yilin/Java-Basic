package com.hspedu.string_;

/**
 * @ClassName String01
 * @Description TODO
 * @Author Jing Yilin
 * @Date 2021/10/10 20:09
 * @Version 1.0
 **/
public class String01 {
    public static void main(String[] args) {

        //String类型用于保存字符串
        //"jack"是字符串常量，双引号括起的字符序列
        //字符串的字符使用Unicode字符编码，一个字符（不管字母还是汉字）占两个字节
        //String有很多构造器
        //String类实现了Serializable【可串行化，可以在网络传输】
        //String类实现了Comparable【可比较】
        //String是final修饰的，不可以被继承
        //String有一个属性 private final char value[];用于存放字符串内容
        //value是一个final类型，（地址）不可以修改
        String name1 = "10"; //byte[2]:[49, 48] ; coder=0
        String name2 = "yl"; //byte[2]:[121, 108] ; coder=0
        String name3 = "景yl"; //byte[6]:[111, 102, 121, 0, 108, 0] ; coder=1

        //创建String两种构造方式
        //方式1：
        //先从常量池查看是否有"jyl"数据空间，如果有，则直接指向，如果没有，则创建再指向
        String s1 = "jyl";//s1 --> 0x99   {byte[3]@816} [106, 121, 108]
        String s2 = "jyl";//s1 --> 0x99   {byte[3]@816} [106, 121, 108]
        //方式2：
        //现在堆中创建对象，里面维护了value属性，指向常量池的"jyl"空间，如果常量池没有"jyl"，则重新创建
        //如果有，则通过value指向。最终指向的是堆中的空间地址
        String s3 = new String("jyl");//s3 --> 0x106  //s3.value --> 0x99 {byte[3]@816} [106, 121, 108]
    }
}

package com.hspedu.stringbuilder_;

/**
 * @ClassName StringBuilder01
 * @Description TODO
 * @Author Jing Yilin
 * @Date 2021/10/20 8:37
 * @Version 1.0
 **/
public class StringBuilder01 {
    public static void main(String[] args) {
        //1.继承了AbstractStringBuilder类
        //2.实现了Serializable说明可以串行化，既可以网络传输，也可以保存在文件
        //3.final,不可以被继承
        //4.StringBuilder对象字符序列仍然是存放在其父类，AbstractStringBuilder的char[] value;
        // 因此，字符序列存放在堆中
        //5.StringBuilder的方法没有互斥处理，即没有synchronized关键字，因此在单线程情况下使用
        StringBuilder stringBuilder = new StringBuilder();

    }
}

package com.hspedu.homeworks;

/**
 * @ClassName Homework04
 * @Description TODO
 * @Author Jing Yilin
 * @Date 2022/1/19 19:32
 * @Version 1.0
 **/
public class Homework04 {
    public static void main(String[] args) {
        //简答题：试分析HashSet和TreeSet是如何去重的
        //回答：两者都实现了Comparator接口，通过compare变量
        //若compare结果为0,则表示Key相同，则直接替换Value

        //正解：
        //（1）HashSet的去重机制：hashCode()+equals()，底层现存入对象，进行运算得到hash值
        //通过hash值得到对应的索引，如果发现table的索引位置没有数据，则直接存放
        //如果有数据，就进行equals比较[遍历比较]，如果比较后不相同，就加入，否则不加入
        //（2）TreeSet的去重机制：如果传入了匿名Comparator对象，就是用实现的compare去重，
        //如果返回0，就认为元素相同，就不添加；如果没有传入Comparator匿名对象，则以你添加的
        //对象的实现的Comparable接口的CompareTo去重
    }
}

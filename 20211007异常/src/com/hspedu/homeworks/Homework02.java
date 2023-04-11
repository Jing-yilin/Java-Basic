package com.hspedu.homeworks;

/**
 * @ClassName Homework02
 * @Description TODO
 * @Author Jing Yilin
 * @Date 2021/10/9 23:17
 * @Version 1.0
 **/
public class Homework02 {
    public static void main(String[] args) {
        try {
            //1.可能出现数组越界异常
            if (args[4].equals("john")){
                System.out.println("AA");
            } else {
                System.out.println("BB");
            }
            //args[2]是string类型的字符串，向上转型成Object
            Object o = args[2];
            //一定出现类型转换异常
//            int i = Integer.parseInt(o.toString());
            Integer i = (Integer)o;//一定会抛出ClassCastException
        } catch (Exception e){
            System.out.println(e.getMessage());
        }
        finally {
            System.out.println("运行完毕！");
        }
    }
}

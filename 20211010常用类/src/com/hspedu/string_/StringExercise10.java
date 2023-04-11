package com.hspedu.string_;

/**
 * @ClassName StringExercise10
 * @Description TODO
 * @Author Jing Yilin
 * @Date 2021/10/11 21:37
 * @Version 1.0
 **/
public class StringExercise10 {
}

class Test1 {
    String str = new String("hsp");
    final char[] ch = {'j', 'a', 'v', 'a'};
    public void change(String str, char ch[]){
        str = "java";
        ch[0] = 'h';
    }
    public void change2(int ints[])
    {
        ints[0] = 9;
    }

    public void change3(String strs[])
    {
        strs[0] = "Hello!";
    }

    public static void main(String[] args) {
        Test1 ex = new Test1();
        ex.change(ex.str, ex.ch);
        System.out.print(ex.str + " and ");
        System.out.println(ex.ch);

        int[] a = {1, 2, 4};
        ex.change2(a);
        System.out.println(a[0]);

        String[] strs = {"I", "love", "you"};
        ex.change3(strs);
        System.out.println(strs[0]);
    }
}

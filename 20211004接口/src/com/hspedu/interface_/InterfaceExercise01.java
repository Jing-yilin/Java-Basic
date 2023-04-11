package com.hspedu.interface_;

public class InterfaceExercise01 {
    public static void main(String[] args) {
        BB bb = new BB();
        System.out.println(bb.a);
        System.out.println(AA.a);
        System.out.println(BB.a);

    }

}

interface AA{
    //public static final int a = 10;
    int a = 10;

}

class BB implements AA {
    //实现了AA，
    //相当于已经有了
    //public static final int a = 10;
}
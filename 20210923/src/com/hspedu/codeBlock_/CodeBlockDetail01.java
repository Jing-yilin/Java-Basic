package com.hspedu.codeBlock_;

public class CodeBlockDetail01 {

    public static void main(String[] args) {

        AA aa = new AA();

        //使用静态成员变量时，执行静态代码块，只执行一回
        System.out.println(Cat.n1);
        System.out.println(Cat.n1);
    }
}

class Cat {

    public static int n1 = 999;
    static {
        System.out.println("Cat的静态代码块1被执行!");
    }
}


class BB {

    static {
        System.out.println("BB的静态代码块1被执行!");
    }
}

class AA extends BB{
    static {
        System.out.println("AA的静态代码块!");
    }
}

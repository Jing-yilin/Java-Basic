package com.hspedu.codeBlock_;

public class CodeBlockDetail02 {
    /*静态代码块和静态属性调用的优先级一样，
    * 如果有多个静态代码块和多个静态变量初始化，
    * 则按照他们定义的顺序调用*/

    /*普通代码块和普通属性调用的优先级一样，
     * 如果有多个普通代码块和多个普通变量初始化，
     * 则按照他们定义的顺序调用*/
    public static void main(String[] args) {
        A a = new A();
        A a1 = new A();
    }
}

class A {
    /*以下三者优先级相同，按照正常顺序调用*/

    private static int n1 = getN1();

    {
        System.out.println("A普通代码块!");
    }

    static {
        System.out.println("A静态代码块01");
    }

    public static int getN1() {
        System.out.println("getN1()被调用了");
        return 100;
    }
}

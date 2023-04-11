package com.hspedu.inner_class;

public class AnonymousInnerClassDetail {
    public static void main(String[] args) {
        /*语法上看，既有类的特征，也有对象的特征*/
        new Outer05().f1();
    }
}

class Outer05 {
    private int n1 = 99;
    public void f1(){
        Person p = new Person(){
            private int n1 = 88;
            @Override
            public void hi() {
                System.out.println("匿名内部类重写了！");
                System.out.println("Outer05.this.n1 = " + Outer05.this.n1);
                System.out.println("n1 = " + n1);
            }
        };
        p.hi(); //动态绑定，运行类型是Outer05$1

        //也可以直接调用
        new Person(){
            @Override
            public void hi() {
                System.out.println("匿名内部类重写了！");
                //可以直接使用外部类的私有属性
                System.out.println("n1 = " + n1);
            }
        }.hi();


        new Person(){
            public void haha() {
                System.out.println("haha！");
            }
        }.ok();


    }
}

class Person {
    int n2 = 100;
    public void hi(){
        System.out.println("Person hi()");
    }
    public void ok(){
        System.out.println("OK!");
    }
}

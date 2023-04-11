package com.hspedu.inner_class;

/*
* 演示局部内部类的使用
* */

public class LocalInnerClass {
    public static void main(String[] args) {
        Outer02 outer02 = new Outer02();
        System.out.println("outer02 hashcode = " + outer02);
        outer02.m1();
    }


}

class Outer02{

    Outer02(){
        System.out.println("Outer02构造器被调用！");
    }
    private int n1 = 100;
    private void m2(){};
    public void m1(){
        //局部内部类定义在外部类的局部位置，通常是在方法里
        //不能添加访问修饰符,但是可以用final修饰(final修饰不能被继承)
        //作用域仅在方法体中
        final class Inner02 { // 局部内部类(本质仍然是一个类)
            private int n1 = 800;
            Inner02(){
                System.out.printf("Inner02构造器被使用！");
            }

            //局部内部类可以访问外部类的所有成员
            public void fi()
            {
                //访问私有属性
                System.out.println("\nn1 = " + n1 + "\n外部类的n1 = " + Outer02.this.n1);
                System.out.println("Outer02.this hashcode = " + Outer02.this);
                //访问方法
                m2();
            }

        }
        //外部类在方法中可以创建Inner02对象，然后调用方法即可
        new Inner02().fi();

/*        class Inner03 extends Inner02 {

        }*/
    }

    {//代码块
        //代码块内也可以定义类
        class Inner03{

        }
    }
}

package com.hspedu.inner_class;

public class StaticInnerClass01 {
    public static void main(String[] args) {

        Outer10 outer10 = new Outer10();

        //静态内部类可以通过外部类名直接访问，但是要满足访问权限
        Outer10.Inner10 inner10 = new Outer10.Inner10();
        inner10.say();

        //编写一个方法，返回一个实例
        Outer10.Inner10 inner101 = outer10.getInner10();
        inner101.say();

        //使用静态方法返回示例
        Outer10.Inner10 inner10_ = Outer10.getInner10_();


    }
}

class Outer10 {
    private int n1 = 10;
    private  static String name = "张三";

    static class Inner10 {
        public void say(){
            //静态类中只能访问非静态成员。
            System.out.println(name);
        }
    }

    public Inner10 getInner10 (){
        return new Inner10();
    }

    public static Inner10 getInner10_ (){
        return new Inner10();
    }
}
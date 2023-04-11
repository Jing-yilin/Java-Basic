package com.hspedu.inner_class;

/*
* 演示匿名内部类的使用
* */

public class AnonymousInnerClass {
    public static void main(String[] args) {
        new Outer04().method();

    }
}

class Outer04 {//外部类
    private int n1 = 10;//属性
    public void method(){//方法
        //基于接口的匿名内部类
        //1.需求：想使用接口A,但是只使用一次
        //2.可以使用匿名类来简化开发
        //3.tiger的编译类型? IA
        //4.tiger的运行类型? 匿名内部类
        /*
        * 底层
        * class XXXX implements IA {
        *
        * @Override
        *   public void cry(){
        *       System.out.println("老虎叫唤！");
        *   }
        * }
        * */
        IA tiger = new IA(){
            @Override
            public void cry(){
                System.out.println("老虎叫唤！");
            }
        };
        System.out.println("tiger的运行类型 = " + tiger.getClass());
        tiger.cry();

        //演示基于类的匿名内部类
        //分析
        //1.father 编译类型 Father
        //2.father运行类型 Outer01$2
        //3.Outer01$02 extends Father
        Father father = new Father("Jack"){
            @Override
            public void test() {
                System.out.println("匿名内部类重写了test()方法");
            }
        };
        System.out.println("father对象的运行类型 = " + father.getClass());

        Animal cat = new Animal() {
            @Override
            void cry() {
                System.out.println("喵喵喵~");
            }
        };
        cat.cry();
    }
}

interface IA {
    public void cry();
}

class Father {
    public Father(String name ){//构造器
        System.out.println("名字是:" + name);
    }

    public void test(){

    }
}

abstract class Animal {
    abstract void cry();
}


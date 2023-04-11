package com.hspedu.final_;

public class Final01 {
    public static void main(String[] args){
        E e = new E();
        e.TAX_RATE = 0.09;
    }

}
/*// final class A{} ,如此，A就不能被B继承
class A{

}

class B extends A{

}

class C {
    //public final void hi() {},则不能被覆写
    public void hi(){
    System.out.println("Hello!");
    }
}

class D extends C{
    @Override
    public void hi(){
    System.out.printf("我重写了hi()");
    };
}*/

class E{
    public double TAX_RATE = 0.08;
}

class F{
    public void cry(){
//        final double NUM = 0.01;
        double NUM = 0.01;
        NUM = 0.9;
        System.out.printf("NUM = " + NUM);
    }
}

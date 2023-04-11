package com.hspedu.final_;

public class FinalDetail01 {
}

class AA{
    //final修饰对象不给初值会报错
    //(1)定义时赋值
    public final double TAX_RATE1 = 0.08 ;

    //(2)构造器中赋值
    public final double TAX_RATE2;
    public AA()
    {
        //但是如果在构造器里给final对象赋值是认可的
        TAX_RATE2 = 1.1;
    }

    //(3)在代码块中赋值
    public final double TAX_RATE3;
    {
        //也可以在静态代码块中赋值
        TAX_RATE3 = 8.8;
    }

}

class BB{
    //(1)如果final修饰的属性是静态的，则初始化的位置只能是定义时
    public static final double TAX_RATE1 = 0.01;

    //(2)或者在静态代码块中，不能在构造器中
    public static final double TAX_RATE2;
    static {
        //但是如果在构造器里给final对象赋值是认可的
        TAX_RATE2 = 1.1;
    }
}

//final类不能继承，但可以实例化对象
final class CC{}

class DD{
    //final修饰的方法可以调用，但是不能覆写
    public final void cal(){
    System.out.println("cal() is running!");
    }
}

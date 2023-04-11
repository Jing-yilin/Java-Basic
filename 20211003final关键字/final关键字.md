# final关键字

## 以下情况需要使用final

1. 当不希望被类继承，可以用final
2. 当不希望父类的某个方法被子类覆盖/重写（override）时，可以用final关键字修饰
3. 当不希望类的某个属性的值被修改，可以用final
4. 当不希望某个局部变量被修改，可以用final

## 不被子类继承

![image-20211003171738403666](https://img.jing10.top/uPic/20230307image-20211003171738403666.png)

## 方法不被覆写

![image-20211003172102300666](https://img.jing10.top/uPic/20230307image-20211003172102300666.png)

![image-20211003172225303666](https://raw.githubusercontent.com/Jing-yilin/pic/master/uPic/image-20211003172225303666.png)

## 类的某个属性不被修改

![image-20211003172611987666](https://img.jing10.top/uPic/20230307image-20211003172611987666.png)

![image-20211003172642989666](https://raw.githubusercontent.com/Jing-yilin/pic/master/uPic/image-20211003172642989666.png)

## 局部变量不被修改

![image-20211003172903250666](https://img.jing10.top/uPic/20230307image-20211003172903250666.png)

![image-20211003172921820666](https://img.jing10.top/uPic/20230307image-20211003172921820666.png)

![image-20211003172944990666](https://img.jing10.top/uPic/20230307image-20211003172944990666.png)

# 示例代码

## FinalDetail01.java

1. final修饰的属性一般叫常量，一般用XX_XX_XX来命名
2. final定义的属性必须赋予初值，以后不可再修改
3. 如果final修饰的属性是静态的，则初始化的位置只能是
   1. 定义时
   2. 在静态代码块
4. final类不能继承，但可以实例化对象
5. 如果类不是final类，但是含有final方法，则该方法虽然不能重写，但是可以被继承

![image-20211003173918290666](https://img.jing10.top/uPic/20230307image-20211003173918290666.png)

![image-20211003221344519666](https://img.jing10.top/uPic/20230307image-20211003221344519666.png)

![image-20211003221556839666](https://img.jing10.top/uPic/20230307image-20211003221556839666.png)

![image-20211003222000293666](https://img.jing10.top/uPic/20230307image-20211003222000293666.png)

```java
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
```

## FinalDetail02.java

5. 一般来说，如果一个类已经是final类了，就没必要将它修饰成final方法
6. final不能修饰构造方法
7. final和static往往搭配使用，不会导致类的加载
8. 包装类(Integer, Double, Float, Boolean等都是final), String也是final类型

```java
package com.hspedu.final_;

public class FinalDetail02 {
  public static void main(String[] args) {
    //不会导致类的加载,BBB类的静态代码块不会被执行
    System.out.println(BBB.num);
    
    //包装类，String是final类
  }
}

class BBB {
    public final static int num = 1000;
    static {
    System.out.println("BBB 静态代码块执行!");
    }
}
```


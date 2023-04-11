package com.hspedu.customexception_;

/**
 * @ClassName CustomExpection
 * @Description TODO
 * @Author Jing Yilin
 * @Date 2021/10/9 22:29
 * @Version 1.0
 **/
@SuppressWarnings("all")
public class CustomException {
    public static void main(String[] args) {
        int age = 800;
        //要求年龄在18-120之间1，否则抛出一个异常
        if (!(age >= 18 && age <= 120))
        {
            throw new AgeException("年龄需要在18~120之间！");
        }
        System.out.println("你的年龄范围正确！");
    }
}

//自定义的一个异常
//1.一般情况，自定义异常都是继承RuntimeException，即运行时异常
//2.好处是，我们可以使用默认的处理机制
class AgeException extends RuntimeException {
    //构造器
    public AgeException(String message) {
        super(message);
    }
}

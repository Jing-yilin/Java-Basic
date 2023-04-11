package com.hspedu.inner_class;

public class MemberInnerClass01 {
    public static void main(String[] args) {
        Outer08 outer08 = new Outer08();

        //第一种方式
        Outer08.Inner08 inner08 = outer08.new Inner08();

        //第二种，通过方法返回Inner08对象
        Outer08.Inner08 inner08Instance = outer08.getInner08Instance();
        inner08Instance.say();

        //第三种方式
        Outer08.Inner08 inner081 = new Outer08().new Inner08();

    }
}

class Outer08 {
    private int n1 = 10;
    public String name = "Jack";

    class Inner08 {//这是一个成员内部类
        public void say(){
            System.out.println("n1 = " +  n1 + "\n" + "name = " + name);
        }
    }

    public void t1(){
        //直接使用内部类创建对象
        Inner08 inner08 = new Inner08();
        inner08.say();
    }

    //返回一个Inner08的实例
    public Inner08 getInner08Instance(){
        return new Inner08();
    }
}

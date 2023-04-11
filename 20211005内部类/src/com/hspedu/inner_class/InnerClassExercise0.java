package com.hspedu.inner_class;

public class InnerClassExercise0 {
    public static void main(String[] args) {
        //直接在参数里覆写函数
        f1(new IL() {
            @Override
            public void show() {
                System.out.println("直接调用匿名类");
            }
        });
    }
    //静态
    public static void f1(IL il){
        il.show();
    }
}

//接口
interface IL{
    void show();
}
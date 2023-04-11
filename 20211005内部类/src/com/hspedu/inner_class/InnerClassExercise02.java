package com.hspedu.inner_class;

public class InnerClassExercise02 {
    public static void main(String[] args) {
        //传递接口的匿名内部类
        new CellPhone().alarmClock(new Bell() {
            @Override
            public void ring() {
                System.out.println("懒猪起床了！");
            }
        });
        //传递接口的匿名内部类
        new CellPhone().alarmClock(new Bell() {
            @Override
            public void ring() {
                System.out.println("小伙伴们上课了！");
            }
        });
    }
}

interface Bell{
    void ring();
}

class CellPhone{
    //编译类型是bell,运行类型会变化的
    public void alarmClock(Bell bell){
        bell.ring();
    }
}

package com.hspedu.interface_;

public class InterfaceExercise02 {
}
interface A{
    int x = 0;
}

class B{
    int x = 1;
}

class C extends B implements A {
    public void pX(){
        System.out.println(A.x);
        System.out.println(super.x);
//        System.out.println(B.x);
    }
    public static void main(String[] args) {
        new C().pX();
    }
}

package com.hspedu.final_;

public class FinalExercise01 {

}

class Circle1{
    private double radius;
    private final double PI = 3.1416;

}
class Circle2{
    private double radius;
    private final double PI;
    {
        PI = 3.1416;
    }

}
class Circle3{
    private double radius;
    private final double PI;
    Circle3(){
        PI = 3.1516;
    }

}
class Circle4{
    private double radius;
    private final static double PI = 3.1416;

}

class Circle5{
    private double radius;
    private final static double PI;
    static {
        PI = 3.1416;
    }

}


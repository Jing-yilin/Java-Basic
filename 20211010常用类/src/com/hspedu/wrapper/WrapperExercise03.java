package com.hspedu.wrapper;

/**
 * @ClassName WrapperExercise03
 * @Description TODO
 * @Author Jing Yilin
 * @Date 2021/10/10 19:50
 * @Version 1.0
 **/
@SuppressWarnings("all")
public class WrapperExercise03 {
    public static void main(String[] args) {
        //1
        Integer i1 = new Integer(127);
        Integer i2 = new Integer(127);
        System.out.printf("1: ");
        System.out.println(i1 == i2);//false

        //2
        Integer i3 = new Integer(128);
        Integer i4 = new Integer(128);
        System.out.printf("2: ");
        System.out.println(i3 == i4);//false

        //3
        Integer i5 = 127;
        Integer i6 = 127;
        System.out.printf("3: ");
        System.out.println(i5 == i6);//true

        //4
        Integer i7 = 128;
        Integer i8 = 128;
        System.out.printf("4: ");
        System.out.println(i7 == i8);//false

        //5
        Integer i9 = 127;
        Integer i10 = new Integer(127);
        System.out.printf("5: ");
        System.out.println(i9 == i10);//false

        //6
        Integer i11 = 127;
        int i12 = 127;
        System.out.printf("6: ");
        //i11 == i12 比较时，会使用i11.intValue() {return value}
        //相当于i11.intValue() == i12
        System.out.println(i11 == i12);//false

        //7
        Integer i13 = 128;
        int i14 = 128;
        System.out.printf("7: ");
        //相当于i13.intValue() == i14
        System.out.println(i13 == i14);//false


    }
}

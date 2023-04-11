package com.hspedu.exception_;

/**
 * @ClassName ArrayIndexOutOfBoundsException_
 * @Description TODO
 * @Author Jing Yilin
 * @Date 2021/10/7 8:11
 * @Version 1.0
 **/
public class ArrayIndexOutOfBoundsException_ {
    public static void main(String[] args) {
        int[] arr = {1, 2, 4};
        for (int i = 0; i <= arr.length; i++) {
            System.out.println(arr[i]);
        }
    }
}

package com.hspedu.arrays_;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @ClassName ArraysSortCustom
 * @Description TODO 使用传入匿名接口实现订制排序
 * @Author Jing Yilin
 * @Date 2021/12/1 23:57
 * @Version 1.0
 **/
public class ArraysSortCustom {
    public static void main(String[] args) {
        int[] arr = {1, -2 , 12, 0, 92, 17};
//        bubbleSort01(arr);
        bubbleSort02(arr, new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                int i1 = (Integer) o1;
                int i2 = (Integer) o2;
                return i1-i2;
            }
        });
        System.out.println("==i1-i2排序后==");
        System.out.println(Arrays.toString(arr));

        bubbleSort02(arr, new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                int i1 = (Integer) o1;
                int i2 = (Integer) o2;
                return i2-i1;
            }
        });
        System.out.println("==i2-i1排序后==");
        System.out.println(Arrays.toString(arr));
    }

    //使用传统冒泡完成排序
    public static void bubbleSort01(int[] arr)
    {
        int tmp = 0;
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - 1 - i; j++) {
                //从小到大排序
                if (arr[j] > arr[j+1])
                {
                    tmp = arr[i];
                    arr[i] = arr[j+1];
                    arr[j+1] = tmp;
                }
            }
        }
    }

    //结合冒泡定制排序
    public static void bubbleSort02(int[] arr, Comparator c){
        int tmp = 0;
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - 1 - i; j++) {
                //数组的排序由c.compare()返回的值决定
                if (c.compare(arr[j], arr[j+1]) > 0)
                {
                    tmp = arr[i];
                    arr[i] = arr[j+1];
                    arr[j+1] = tmp;
                }
            }
        }
    }
}

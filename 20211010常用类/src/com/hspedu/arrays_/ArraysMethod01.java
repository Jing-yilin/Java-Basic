package com.hspedu.arrays_;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Comparator;

/**
 * @ClassName ArraysMethod01
 * @Description TODO
 * @Author Jing Yilin
 * @Date 2021/11/30 9:25
 * @Version 1.0
 **/
public class ArraysMethod01 {
    public static void main(String[] args) {
        Integer[] integers = {1, 20, 90};

        //遍历数组
//        for (int i = 0; i < integers.length; i++) {
//            System.out.println(integers[i]);
//        }
        //直接使用Arrays.toString()方法
        System.out.println(Arrays.toString(integers));

        //演示sort方法的使用
        Integer arr[] = {1, 0, -1, 89, 20};
        //进行排序
        //1.可以直接使用冒泡排序，也可以使用Array提供的sort方法排序
        //2.因为数字是引用类型，所以通过sort排序后，会直接影响 实参 arr
        //3.sort重载了，也可以通过传入一个接口Comparator实现定制排序

        //默认排序
//        System.out.printf("排序前：");
//        System.out.println(Arrays.toString(arr));
//        Arrays.sort(arr);
//        System.out.printf("排序后：");
//        System.out.println(Arrays.toString(arr));//从小到大

        //定制排序
        //传入两个参数(1)排序的数组(2)Comparator接口的匿名内部类
        //最终使用binarySort()
        /*调用compare()的部分：
        * while (left < right) {
                int mid = (left + right) >>> 1;
                if (c.compare(pivot, a[mid]) < 0)
                    right = mid;
                else
                    left = mid + 1;
            }
        * */
        //充分体现了接口编程的好处
        Arrays.sort(arr, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1 - o2;//从小到大
            }
        });
        System.out.println(Arrays.toString(arr));

        Arrays.sort(arr, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;//从大到小
            }
        });
        System.out.println(Arrays.toString(arr));

    }
}

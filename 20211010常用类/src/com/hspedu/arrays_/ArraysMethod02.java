package com.hspedu.arrays_;

import java.util.Arrays;
import java.util.List;

/**
 * @ClassName ArraysMethod02
 * @Description TODO
 * @Author Jing Yilin
 * @Date 2021/12/2 8:47
 * @Version 1.0
 **/
public class ArraysMethod02 {
    public static void main(String[] args) {

        Integer arr[] = {1, 2, 6, 12, 54, 99};

        //1. 使用binarySearch二分查找
        //2. 要求改数组是有序的，如果是无序的则不能使用binarySearch
        //3. 如果数组中不存在改元素则返回-(low + 1) //key not found
        int index = Arrays.binarySearch(arr, 12);
        System.out.println("index = " + index);

        //copyOf 数组元素的复制
        //1. 从arr中拷贝arr.length个元素到newArr
        //2. 如果拷贝的长度 > arr.length则在末尾添加null
        Integer[] newArr = Arrays.copyOf(arr, arr.length);
        System.out.println("=====执行了拷贝之后=====");
        System.out.println(Arrays.toString(arr));

        //ill 数组元素的填充
        Integer[] num = new Integer[]{9, 3, 2};
        System.out.println("=====num填充前=====");
        System.out.println(Arrays.toString(num));//[9, 3, 2]
        //1. 替换所有元素为99
        Arrays.fill(num, 99);
        System.out.println("=====num填充后=====");
        System.out.println(Arrays.toString(num));//[99, 99, 99]

        //equals 比较两个数组的元素是否完全一致
        Integer arr2[] = {1, 2, 6, 12, 54, 99};
        boolean equals = Arrays.equals(arr, arr2);
        //1. 如果arr和arr2数组的元素一样则返回true1
        System.out.println("equals = " + equals);

        //asList 将一组数，转化为list
        //1. asList方法，会将(2, 3, 4, 5, 6, 1)数据变成一个List集合
        //2. 返回 asList 编译类型 List(接口)
        //3. asList 的运行类型为java.util.Arrays$ArrayList， 是Arrays的一个静态内部类
        List<Integer> asList = Arrays.asList(2, 3, 4, 5, 6, 1, 2, 6);
        System.out.println("asList = " + asList);
        System.out.println("asList的运行类型是" + asList.getClass());

    }
}

package 断点调试;

import java.util.Arrays;

public class test3 {
//    演示debug过程中追源码
public static void main(String[] args) {


    // debug源码
    int[] arr = {8,-1, 199, 70, 10};
    // 排序，追入sort源码
    Arrays.sort(arr);
    for (int i = 0; i < arr.length; i++) {
        System.out.println(arr[i] + "\t");
    }
}
}

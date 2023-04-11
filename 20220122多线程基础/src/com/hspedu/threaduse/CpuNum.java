package com.hspedu.threaduse;

/**
 * @ClassName CpuNum
 * @Description 查看电脑CPU数目
 * @Author Jing Yilin
 * @Date 2022/1/21 14:48
 * @Version 1.0
 **/
public class CpuNum {
    public static void main(String[] args) {
        Runtime runtime = Runtime.getRuntime();
        int cpuNums = runtime.availableProcessors();
        System.out.println("当前有CPU个数 = " + cpuNums);
        //当前有CPU个数 = 8
    }
}

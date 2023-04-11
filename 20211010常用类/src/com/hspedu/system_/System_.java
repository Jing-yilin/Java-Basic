package com.hspedu.system_;

import java.sql.SQLOutput;
import java.util.Arrays;

/**
 * @ClassName System_
 * @Description TODO
 * @Author Jing Yilin
 * @Date 2021/12/2 9:35
 * @Version 1.0
 **/
public class System_ {
    public static void main(String[] args) {

        //exit 退出当前程序
//        System.out.println("ok1");
//        System.exit(0);
//        System.out.println("ok2");

        //arraycopy: 复制数组元素，比较适合底层调用
        //一半使用Array.copyOf完成复制数组
        int[] src = {1, 2, 3};
        int[] dest = new int[3];//dest当前是{0, 0, 0}
        System.arraycopy(src, 0, dest, 0, 2);
        System.out.println("dest = " + Arrays.toString(dest));

        //System.currentTimeMillis()
        System.out.println(System.currentTimeMillis());
    }
}

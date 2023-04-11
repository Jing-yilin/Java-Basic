package com.hspedu;

/**
 * @ClassName Test
 * @Description TODO
 * @Author zephyr
 * @Date 2022/7/3 22:44
 * @Version 1.0
 */
public class Test {
    public static void main(String[] args) {
        int i = 1;
        i = i++;
        System.out.println(i);
        i = 1;
        i = ++i;
        System.out.println(i);

        int n = 1;
        char a = (char)('A' + n);
    }
}

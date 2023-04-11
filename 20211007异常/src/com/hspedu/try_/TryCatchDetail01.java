package com.hspedu.try_;

/**
 * @ClassName TryCatch01
 * @Description TODO
 * @Author Jing Yilin
 * @Date 2021/10/7 8:41
 * @Version 1.0
 **/
public class TryCatchDetail01 {
    public static void main(String[] args) {

        try {
            String str = "Jack";
            int a = Integer.parseInt(str);
            System.out.println("数字：" + a);
        } catch (NumberFormatException e) {
            System.out.println("异常信息 = " + e.getMessage());
        }

        System.out.println("程序继续......");
    }
}

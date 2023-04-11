package com.hspedu.homeworks;

/**
 * @ClassName Homework01
 * @Description TODO
 * @Author Jing Yilin
 * @Date 2021/10/9 22:59
 * @Version 1.0
 **/
public class Homework01 {
    public static void main(String[] args) {
        try {
            if (args.length != 2){
                throw new ArrayIndexOutOfBoundsException("参数个数不正确！");
            }
            int n1 = Integer.parseInt(args[0]);
            int n2 = Integer.parseInt(args[1]);

            double res = EcmDef.cal(n1, n2);//该操作可能抛出算数异常
            System.out.println("计算结果是：" + res);

        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.printf(e.getMessage());
        } catch (NumberFormatException e){
            System.out.printf("参数格式不正确！需要输入整数！");
        } catch (ArithmeticException e){
            System.out.printf("出现除0的异常！");
        }
    }
}

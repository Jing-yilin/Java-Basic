package com.hspedu.homeworks;

/**
 * @ClassName Homework04
 * @Description TODO
 * @Author Jing Yilin
 * @Date 2021/12/7 10:06
 * @Version 1.0
 **/
public class Homework04 {
    /**
     * 输入字符串，判断里面有多少大写字母、小写字母、数字
     *
     */
    public static void func(String s)
    {
        int numOfUpper =0, numOfLower = 0, numOfLetter = 0;
        char[] chars = s.toCharArray();
        for (int i = 0; i < s.length(); i++) {
            if (chars[i] >= 'A' && chars[i] <= 'Z')
            {
                numOfUpper++;
            } else if (chars[i] >= 'a' && chars[i] <= 'z')
            {
                numOfLower++;
            } else if (chars[i] >= '0' && chars[i] <= '9')
            {
                numOfLetter++;
            }
        }
        System.out.println(String.format("%s 中有%d个大写字母, %d个小写字母, %d个数字。", s, numOfUpper, numOfLower, numOfLetter));
    }

    public static void main(String[] args) {
        func("12d98h18wdg71bw19wjdwihdi81bhhdhh(Hh99h9h99h9h9j9j9j9J9J9H9H9");
    }
}

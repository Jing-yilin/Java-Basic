package com.hspedu.homeworks;

/**
 * @ClassName Homework02
 * @Description TODO
 * @Author Jing Yilin
 * @Date 2021/12/6 14:31
 * @Version 1.0
 **/
public class Homework02 {
    public static void userRegister(String username, String password, String email)
    {
        //要求三者都不为空
        if (!(username != null && password != null && email != null))
        {
            throw new RuntimeException("不能输入空！");
        }

        //校验username
        int ul = username.length();
        if (!(ul >= 2 && ul <= 4))
        {
            throw new RuntimeException("用户名长度必须为2或3或4！");
        }

        //校验password
        if (!(password.length() == 6 && isDigital(password)))
        {
            throw new RuntimeException("密码的长度必须为6且必须都为数字！");
        }

        //校验email
        int idOfLabel = email.indexOf('@');
        int idOfDot = email.indexOf('.');
        if (!(idOfLabel > 0 && idOfDot > idOfLabel))
        {
            throw new RuntimeException("邮箱中必须包含@和. 并且@要在.前面");
        }

        System.out.println("创建对象成功！");
    }

    public static boolean isDigital(String s)
    {
        char[] chars = s.toCharArray();
        for (int i = 0; i < s.length(); i++) {
            if(!Character.isDigit(chars[i]))
            {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        try {
            userRegister("jyl", "123456", "1154896650@qq.com");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}

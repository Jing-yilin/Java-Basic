package com.hspedu.mhl.utils;

import java.sql.Connection;

/**
 * @ClassName Test
 * @Description 测试类
 * @Author zephyr
 * @Date 2022/6/16 21:15
 * @Version 1.0
 */
public class Test {
    public static void main(String[] args) {

//        // 测试Utility 工具类
//        System.out.println("请输入一个整数");
//        int i = Utility.readInt();
//        System.out.println("i = " + i);

        try {
            Connection connection = JDBCUtilsByDruid.getConnection();
            System.out.println(connection);// com.mysql.jdbc.JDBC4Connection@45c8e616
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }
}

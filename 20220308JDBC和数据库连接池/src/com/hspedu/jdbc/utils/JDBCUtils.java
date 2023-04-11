package com.hspedu.jdbc.utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.*;
import java.util.Properties;

/**
 * @ClassName JDBCUtils
 * @Description 这是一个JDBC工具类，实现MYSQL的连接和关闭资源
 * @Author Jing Yilin
 * @Date 2022/3/9 11:12
 * @Version 1.0
 **/
public class JDBCUtils {
    //定义相关属性
    private static String user;//用户名
    private static String password;//密码
    private static String url;//url
    private static String driver;//驱动名

    //在静态代码块里初始化
    static {
        try {
            Properties properties = new Properties();
            properties.load(new FileInputStream("src\\mysql.properties"));
            //读取属性
            user = properties.getProperty("user");
            password = properties.getProperty("password");
            url = properties.getProperty("url");
            driver = properties.getProperty("driver");

        } catch (Exception e) {
            //实际开发中
            //1. 将编译异常转成运行时异常
            //2. 这是调用者可以捕获该异常，也可以默认处理
            throw new RuntimeException(e);
        }
    }

    /**
     * 连接数据库，返回Connection
     * @return
     */
    public static Connection getConnection() {
        try {
            return DriverManager.getConnection(url, user, password);
        } catch (SQLException e) {
            //将编译异常转成运行时异常
            throw new RuntimeException(e);
        }
    }

    /*
    关闭相关资源：
        1. ResultSet 结果集
        2. Statement 或者 PreparedStatement
        3. Connection
     */

    /**
     * 关闭连接，如果需要关闭就传入，不需要关闭就传入null
     * @param set
     * @param statement
     * @param connection
     */
    public static void close(ResultSet set, Statement statement, Connection connection){
        //判断是否为null
        try {
            if (set != null){
                set.close();
            }
            if (statement != null){
                statement.close();
            }
            if (connection != null){
                connection.close();
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

}

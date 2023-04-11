package com.hspedu.jdbc.resultset_;

import java.io.FileInputStream;
import java.sql.*;
import java.util.Properties;

/**
 * @ClassName ResultSet_
 * @Description 演示 SELECT 语句返回 ResultSet 结果
 * @Author Jing Yilin
 * @Date 2022/3/8 11:23
 * @Version 1.0
 **/
@SuppressWarnings("all")
public class ResultSet_ {
    public static void main(String[] args) throws Exception{
        //加载配置文件
        String path = "src\\mysql.properties";
        Properties properties = new Properties();
        properties.load(new FileInputStream(path));
        String user = properties.getProperty("user");
        String url = properties.getProperty("url");
        String password = properties.getProperty("password");
        String driver = properties.getProperty("driver");
        //1. 注册驱动
        Class.forName(driver);
        //2. 得到连接
        Connection connection = DriverManager.getConnection(url, user, password);
        //3. 得到statement
        Statement statement = connection.createStatement();
        //4. 组织 sql 语句
        String sql = "SELECT id, `name`, sex, borndate FROM actor";
        ResultSet resultSet = statement.executeQuery(sql);
        /*
        id  name   sex  borndate
        1	景风眠	男	2002-03-30 00:00:00
        2	jack	男	1991-01-01 00:00:00
        3	mike	男	1993-12-14 00:00:00
        */
        //5. 使用while循环取出数据
        while (resultSet.next()){
            int id = resultSet.getInt(1);//获取改行的第一列数据
            String name = resultSet.getString(2);
            String sex = resultSet.getString(3);
            Date date = resultSet.getDate(4);
            System.out.println(id + "\t" + name + "\t" + sex + "\t" + date);
        }
        /*
        以下为输出结果：
        1	景风眠	男	2002-03-30
        2	jack	男	1991-01-01
        3	mike	男	1993-12-14
        */
        //6. 关闭连接
        statement.close();
        connection.close();

    }
}

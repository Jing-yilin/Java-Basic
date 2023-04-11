package com.hspedu.jdbc.preparedstatement;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.*;
import java.util.Properties;

/**
 * @ClassName Homework01
 * @Description TODO
 * @Author Jing Yilin
 * @Date 2022/3/9 10:35
 * @Version 1.0
 **/
public class Homework01 {
    public static void main(String[] args) throws IOException, SQLException, ClassNotFoundException {
        //读取配置文件
        String path = "src\\mysql.properties";
        Properties properties = new Properties();
        properties.load(new FileInputStream(path));
        String user = properties.getProperty("user");
        String password = properties.getProperty("password");
        String url = properties.getProperty("url");
        String driver = properties.getProperty("driver");

        //注册驱动
        Class.forName(driver);//可以不写,建议写上

        //获得连接
        Connection connection = DriverManager.getConnection(url, user, password);

        //写sql语句
        //DML操作
//        String sql1 = "CREATE TABLE admin (name VARCHAR(32), pwd VARCHAR(32));" +
//                "INSERT INTO admin VALUES(?, ?), (?, ?), (?, ?), (?, ?), (?, ?);" +
//                "UPDATE admin SET name = 'king' WHERE name = 'tom';" +
//                "DELETE FROM admin WHERE name = 'jack';";
        String sql1 = "DELETE FROM admin WHERE name = 'jack';";
        String sql2 = "SELECT * FROM admin";
        //获得预处理语句
        PreparedStatement preparedStatement = connection.prepareStatement(sql2);
//        preparedStatement.setString(1, "tom");
//        preparedStatement.setString(2, "123");
//        preparedStatement.setString(3, "jack");
//        preparedStatement.setString(4, "123");
//        preparedStatement.setString(5, "mike");
//        preparedStatement.setString(6, "123");
//        preparedStatement.setString(7, "richard");
//        preparedStatement.setString(8, "123");
//        preparedStatement.setString(9, "rose");
//        preparedStatement.setString(10, "123");
        //执行预处理语句
//        int rows = preparedStatement.executeUpdate();
//        System.out.println(rows > 0 ? "执行成功" : "执行失败");
        ResultSet resultSet = preparedStatement.executeQuery();
        //打印查询
        while (resultSet.next()){
            String name = resultSet.getString(1);
            String pwd = resultSet.getString(2);
            System.out.println(name + "\t" + pwd);
        }
        //关闭连接
        preparedStatement.close();
        connection.close();

    }
}

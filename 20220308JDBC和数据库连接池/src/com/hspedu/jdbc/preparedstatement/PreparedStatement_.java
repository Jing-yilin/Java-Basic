package com.hspedu.jdbc.preparedstatement;


import java.io.FileInputStream;
import java.sql.*;
import java.util.Properties;
import java.util.Scanner;

/**
 * @ClassName PreparedStatement_
 * @Description 演示 PreparedStatement 使用
 * @Author Jing Yilin
 * @Date 2022/3/8 15:31
 * @Version 1.0
 **/
@SuppressWarnings("all")
public class PreparedStatement_ {
    public static void main(String[] args) throws Exception{
        //看PreparedStatement类图
//        PreparedStatement
        //让用户输入管理员名称和密码
        Scanner scanner = new Scanner(System.in);
        System.out.println("输入管理员账号");
        String admin_name = scanner.nextLine();// 1' or
        System.out.println("输入管理员密码");
        String admin_pwd = scanner.nextLine();// or '1'='1
        System.out.println("\n-------------------成功输入-------------------\n");

        //加载配置文件
        String path = "src\\mysql.properties";
        Properties properties = new Properties();
        properties.load(new FileInputStream(path));
        String user = properties.getProperty("user");
        String url = properties.getProperty("url");
        String password = properties.getProperty("password");
        String driver = properties.getProperty("driver");
        //1. 注册驱动
        Class.forName(driver);//可以不写,建议写上
        //2. 得到连接
        Connection connection = DriverManager.getConnection(url, user, password);
        //3. 得到statement
        //3.1 组织 sql 语句
        String sql = "SELECT name, pwd FROM admin WHERE name = ? AND pwd = ? ";
        //3.2 preparedStatement 是一个实现了 PreparedStatement 接口的对象
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        //3.3 给 ? 赋值
        preparedStatement.setString(1, admin_name);
        preparedStatement.setString(2, admin_pwd);
        //这里执行executeQuery不要写sql
        ResultSet resultSet = preparedStatement.executeQuery();
        if (resultSet.next()){//如果查询到记录。则说明登录成功
            System.out.println("登录成功");
//            String name = resultSet.getString(1);
//            String pwd = resultSet.getString(2);
//            System.out.println(name + "\t" + pwd);
        } else {
            System.out.println("登陆失败");
        }
        //关闭连接
        resultSet.close();
        preparedStatement.close();
        connection.close();
    }
}

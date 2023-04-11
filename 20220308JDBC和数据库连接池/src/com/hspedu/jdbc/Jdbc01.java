package com.hspedu.jdbc;

import org.gjt.mm.mysql.Driver;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

/**
 * @ClassName Jdbc01
 * @Description 这是第一个JDBC程序
 * @Author Jing Yilin
 * @Date 2022/3/8 10:03
 * @Version 1.0
 **/
public class Jdbc01 {
    public static void main(String[] args) throws SQLException {
        //前置工作，在项目下创建一个文件夹libs
        //将 mysql.jar 拷贝至目录下，加入到项目中

        //1. 注册驱动
        Driver driver = new Driver();

        //2. 得到连接
        //(1) jdbc:mysql:// 是规定好的协议
        //(2) localhost 主机地址
        //(3) 3306 表示mysql监听端口
        //(4) hsp_db02 表示mysql 的哪一个数据库
        //(5) mysql的连接本质就是 socket连接
        String url = "jdbc:mysql://localhost:3306/hsp_db02";
        //将用户名和密码放入 Properties 对象
        Properties properties = new Properties();
        //user和password是规定好的不要乱写
        properties.setProperty("user", "root");//用户名
        properties.setProperty("password", "jyl");//密码
        //得到连接
        Connection connect = driver.connect(url, properties);

        //3. 执行sql语句
        String sql = "INSERT INTO actor VALUES(NULL, '景风眠', '男', '2002-03-30', '123456')";
        //statement 用于执行静态SQL语句并返回其生战的结果的对象
        Statement statement = connect.createStatement();
        int rows = statement.executeUpdate(sql);//返回受影响的行数

        System.out.println(rows > 0 ? "成功" : "失败");

        //4. 关闭连接资源
        statement.close();
        connect.close();

    }
}

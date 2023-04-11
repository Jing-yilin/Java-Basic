package com.hspedu.jdbc;

import java.io.FileInputStream;
import java.rmi.server.ExportException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.Properties;

/**
 * @ClassName homework01
 * @Description TODO
 * @Author Jing Yilin
 * @Date 2022/3/8 11:05
 * @Version 1.0
 **/
public class homework01 {
    public static void main(String[] args) throws Exception {
        String path = "src\\mysql.properties";
        Properties properties = new Properties();
        properties.load(new FileInputStream(path));
        String user = properties.getProperty("user");
        String url = properties.getProperty("url");
        String password = properties.getProperty("password");
        String driver = properties.getProperty("driver");
        //加载驱动
        Class.forName(driver);
        //得到连接
        Connection connection = DriverManager.getConnection(url, user, password);
        //进行crud操作
        Statement statement = connection.createStatement();
        statement.executeUpdate("CREATE TABLE news(id INT PRIMARY KEY AUTO_INCREMENT, content VARCHAR(32))");
        //添加五条记录
        int rows = statement.executeUpdate("INSERT INTO news VALUES(1, 'new1'), (2, 'new2'),(3, 'new3'),(4, 'new4'),(5, 'new5')");
        System.out.println("添加记录" + (rows>0?"成功":"失败"));
        //修改 id = 1 的记录
        rows = statement.executeUpdate("UPDATE news SET content = '新消息' WHERE id = 1");
        System.out.println("修改 id = 1 的记录" + (rows>0?"成功":"失败"));
        //删除 id = 3 的记录
        rows = statement.executeUpdate("DELETE FROM news WHERE id = 3");
        System.out.println("删除 id = 3 的记录" + (rows>0?"成功":"失败"));

        //关闭连接
        statement.close();
        connection.close();

    }
}

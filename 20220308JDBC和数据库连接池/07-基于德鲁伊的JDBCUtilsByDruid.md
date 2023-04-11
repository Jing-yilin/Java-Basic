```java
package com.hspedu.jdbc.datasource;

import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

/**
 * @ClassName JDBCUtilsByDruid
 * @Description 这是一个基于德鲁伊连接池的JDBC工具类
 * @Author Zephyr
 * @Date 2022/5/8 22:51
 * @Version 1.0
 */
public class JDBCUtilsByDruid {
    private static DataSource ds;

    //在静态代码块完成 ds 的初始化
    static {
        Properties properties = new Properties();
        try {
            properties.load(new FileInputStream("src\\druid.properties"));
            ds = DruidDataSourceFactory.createDataSource(properties);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    //获取连接
    public static Connection getConnection() throws Exception{
        return ds.getConnection();
    }

    //关闭连接（不是真的关闭，只是放回连接池）
    public static void close(ResultSet resultSet, Statement statement, Connection connection){
        try {
            if (resultSet != null){
                resultSet.close();
            }
            if (statement != null){
                statement.close();
            }
            if (connection != null){
                connection.close();//这里的close不是真正关闭连接，而是放回连接池
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
```
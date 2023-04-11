package com.hspedu.jdbc.datasource;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.junit.jupiter.api.Test;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

/**
 * @ClassName C3P0_
 * @Description 演示C3P0数据库连接池
 * @Author Jing Yilin
 * @Date 2022/3/12 10:09
 * @Version 1.0
 **/
@SuppressWarnings("all")
public class C3P0_ {
    /*
    方式1：相关参数在程序中指定
     */
    @Test
    public void testC3P0_1() throws Exception {
        //1. 先创建一个数据源对象
        ComboPooledDataSource comboPooledDataSource = new ComboPooledDataSource();
        //2. 通过配置文件mysql.properties获取相关信息
        Properties properties = new Properties();
        properties.load(new FileInputStream("src\\mysql.properties"));
        //读取相关属性
        String user = properties.getProperty("user");
        String password = properties.getProperty("password");
        String url = properties.getProperty("url");
        String driver = properties.getProperty("driver");

        //给数据源 comboPooledDataSource 设置相关的参数
        //注意：我们连接的管理是由 comboPooledDataSource 来管理的
        comboPooledDataSource.setDriverClass(driver);
        comboPooledDataSource.setJdbcUrl(url);
        comboPooledDataSource.setUser(user);
        comboPooledDataSource.setPassword(password);

        //设置初始化连接数
        comboPooledDataSource.setInitialPoolSize(10);
        comboPooledDataSource.setMaxPoolSize(50);// 最大连接数
        //测试连接池效率
        //连接mysql5000次
        long start = System.currentTimeMillis();
        for (int i = 0; i < 5000; i++) {
            Connection connection = comboPooledDataSource.getConnection();//这个方法就是从DataSource接口实现
//            System.out.println("连接成功！");
            connection.close();
        }
        long end = System.currentTimeMillis();
        System.out.println("C3P0连接5000次数据库耗时" + (end-start) + "ms");
    }

    /*
    方式2：使用配置文件的模板来完成
     */
    //1. 将C3P0提供的 c3p0.config.xml 拷贝到 src 目录下
    //2. 该文件指定了连接数据库和连接池的相关参数
    @Test
    public void testC3P0_2() throws SQLException {
        ComboPooledDataSource comboPooledDataSource = new ComboPooledDataSource("hsp");
        Connection connection = comboPooledDataSource.getConnection();
        System.out.println("连接成功！");
        connection.close();
    }

}

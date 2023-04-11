package com.hspedu.jdbc.datasource;

import com.alibaba.druid.pool.DruidDataSourceFactory;
import org.junit.jupiter.api.Test;

import javax.sql.DataSource;
import java.io.FileInputStream;
import java.sql.Connection;
import java.util.Properties;

/**
 * @ClassName Druid_
 * @Description 测试德鲁伊
 * @Author Zephyr
 * @Date 2022/5/8 22:27
 * @Version 1.0
 */
@SuppressWarnings("all")
public class Druid_ {
    @Test
    public void testDruid() throws Exception{
        //1. 加入 Druid 的 jar 包
        //2. 加入配置文件 druid.properties，拷贝到src目录下
        //3. 创建Properties，读取配置文件
        Properties properties = new Properties();
        properties.load(new FileInputStream("src/druid.properties"));

        //4. 创建一个指定参数的数据库连接池
        DataSource dataSource = DruidDataSourceFactory.createDataSource(properties);

        Connection connection = dataSource.getConnection();
        System.out.println("连接成功！");
        connection.close();
    }
}

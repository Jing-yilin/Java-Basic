package com.hspedu.jdbc;

//import org.gjt.mm.mysql.Driver;
import com.mysql.jdbc.Driver;
import org.junit.jupiter.api.Test;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

/**
 * @ClassName JdbcConn
 * @Description 分析JAVA连接MYSQL的5中方式
 * @Author Jing Yilin
 * @Date 2022/3/8 10:30
 * @Version 1.0
 **/
@SuppressWarnings("all")
public class JdbcConn {
    //方式1
    @Test
    public void connect01() throws SQLException {
        //获取Driver实现类对象
        Driver driver = new Driver();
        String url ="jdbc:mysql://localhost:3306/hsp_db02";
        Properties info = new Properties();
        info.setProperty("user","root");
        info.setProperty("password","jyl");
        Connection conn = driver.connect(url,info);
        System.out.println(conn);
    }
    //方式2使用反射加载driver
    @Test
    public void connect02() throws Exception {
        //动态加载获取driver对象
        Class<?> aClass = Class.forName("com.mysql.jdbc.Driver");
        Driver driver = (Driver) aClass.newInstance();
        String url ="jdbc:mysql://localhost:3306/hsp_db02";
        Properties info = new Properties();
        info.setProperty("user","root");
        info.setProperty("password","jyl");
        Connection conn = driver.connect(url,info);
        System.out.println(conn);
    }
    //方式3 使用DriverManager 替代 Driver
    @Test
    public void connect03() throws Exception {
        //先使用反射加载driver
        Class<?> aClass = Class.forName("com.mysql.jdbc.Driver");
        Driver driver = (Driver) aClass.newInstance();
        //创建url:user和password
        String url ="jdbc:mysql://localhost:3306/hsp_db02";
        String user = "root";
        String password = "jyl";

        DriverManager.registerDriver(driver);
        Connection conn = DriverManager.getConnection(url, user, password);

        System.out.println(conn);
    }
    //方式4 使用Class.forName 自动完成注册驱动，简化代码
    @Test
    public void connect04() throws Exception {
        //在加载 Driver 类时，自动完成注册
        Class<?> aClass = Class.forName("com.mysql.jdbc.Driver");

        String url ="jdbc:mysql://localhost:3306/hsp_db02";
        String user = "root";
        String password = "jyl";

        Connection conn = DriverManager.getConnection(url, user, password);

        System.out.println(conn);
    }
    //方式5 使用配置文件,连接数据库更灵活
    @Test
    public void connect05() throws Exception {
        //通过properties获取对象配置文件信息
        Properties properties = new Properties();
        properties.load(new FileInputStream("src\\mysql.properties"));
        String user = properties.getProperty("user");
        String password = properties.getProperty("password");
        String url = properties.getProperty("url");
        String driver = properties.getProperty("driver");

        //加载驱动
        Class.forName(driver);

        Connection conn = DriverManager.getConnection(url, user, password);

        System.out.println(conn);
    }
}

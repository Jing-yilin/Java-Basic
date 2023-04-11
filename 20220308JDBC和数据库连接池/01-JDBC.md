## 基本介绍

1. JDBC为访问不同的数据库提供了统一的接口，为使用者屏蔽了细节问题。
2. Java程序员使用JDBC,可以连接任何提供了JDBC驱动程序的数据库系统，从而完成对数据库的各种操作。
3. JDBC的基本原理
4. 模拟JDBC com.hspedu.jdbc.myjdbc

![image-20220308094655860](https://s2.loli.net/2022/03/08/8O5EMF3CkqNacpf.png)

![image-20220308094739831](https://s2.loli.net/2022/03/08/mbFwhCY9XHOslqn.png)

# 快速入门

## JDBC程序编写步骤

1. 注册驱动-加载Driver类
2. 获取连接-得到Connection
3. 执行增删改查-发送SQL 给mysq|执行
4. 释放资源-关闭相关连接

## 第一个JDBC程序

现在`hsp_db02`里创建一张表

```mysql
CREATE TABLE actor (-- 演员表 
		id INT PRIMARY KEY AUTO_INCREMENT,
		`name` varchar(32) NOT NULL DEFAULT '',
		sex CHAR(1) NOT NULL DEFAULT '女',
		borndate DATETIME,
		phone VARCHAR(12)
);
```

接下来使用java

![image-20220308100745528](https://s2.loli.net/2022/03/08/omlYWhqCE6r7I9e.png)

```java
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
```

![image-20220308102634405](https://s2.loli.net/2022/03/08/w5O3vhFRZBuVN8X.png)

添加成功

## 连接数据库的5种方式

### 方式1

```java
//获取Driver实现类对象
Driver driver = new Driver();
String url ="jdbc:mysql://localhost:3306/hsp_db02";
Properties info = new Properties();
info.setProperty("user","root");
info.setProperty("password","jyl");
Connection conn = driver.connect(url,info);
System.out.println(conn);
```

### 方式2

使用反射机制

```java
//动态加载获取driver对象
Class<?> aClass = Class.forName("com.mysql.jdbc.Driver");
Driver driver = (Driver) aClass.newInstance();
String url ="jdbc:mysql://localhost:3306/hsp_db02";
Properties info = new Properties();
info.setProperty("user","root");
info.setProperty("password","jyl");
Connection conn = driver.connect(url,info);
System.out.println(conn);
```

### 方式3

使用`DriverManager`

```java
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
```

### 方式4

可以发现Driver底层自动会注册`DriverManager`

![image-20220308104745987](https://s2.loli.net/2022/03/08/dQRkBOClVv1eYif.png)

```java
//在加载 Driver 类时，自动完成注册
Class<?> aClass = Class.forName("com.mysql.jdbc.Driver");

String url ="jdbc:mysql://localhost:3306/hsp_db02";
String user = "root";
String password = "jyl";

Connection conn = DriverManager.getConnection(url, user, password);

System.out.println(conn);
```

甚至`Class<?> aClass = Class.forName("com.mysql.jdbc.Driver");`都可以不用写，因为mysql驱动5.1.6以后会自动注册驱动。



![image-20220308105110382](https://s2.loli.net/2022/03/08/QudBD6JpzXyPFwZ.png)

### 方式5

使用配置文件,连接数据库更灵活

mysql.properties

```properties
user=root
password=jyl
url=jdbc:mysql://localhost:3306/hsp_db02
driver=com.mysql.jdbc.Driver
```

```java
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
```

推荐使用这种方式!!!

## Result的使用

```java
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
        1	景风眠	  男	  2002-03-30 00:00:00
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
        1	景风眠	  男	  2002-03-30
        2	jack	男	1991-01-01
        3	mike	男	1993-12-14
        */
//6. 关闭连接
statement.close();
connection.close();
```

![image-20220308114259427](https://s2.loli.net/2022/03/08/ysRlWMTX3xBmUJA.png)

底层

其实是`ArrayList`

## Statement

![image-20220308123331636](https://s2.loli.net/2022/03/08/ksTzJ8nKFQiUucN.png)

Statement存在SQL注入问题。

### 注入演示SQL

```mysql
-- 演示SQL注入
-- 创建一张表
CREATE TABLE admin(
		name VARCHAR(32) not NULL UNIQUE,
	pwd VARCHAR(32) not null DEFAULT ''	
) CHARACTER SET utf8;

-- 添加数据
INSERT INTO admin VALUES('tom', '123');

-- SQL注入
SELECT *
				FROM admin
				WHERE name = '1' OR 'AND pwd = 'OR '1'='1';
```

### 注入演示JDBC

```java
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
Statement statement = connection.createStatement();
//4. 组织 sql 语句
String sql = "SELECT name, pwd FROM admin WHERE name = '"+admin_name+"' AND pwd = '"+admin_pwd + "'";
ResultSet resultSet = statement.executeQuery(sql);
if (resultSet.next()){//如果查询到记录。则说明登录成功
    System.out.println("登录成功");
    //            String name = resultSet.getString(1);
    //            String pwd = resultSet.getString(2);
    //            System.out.println(name + "\t" + pwd);
} else {
    System.out.println("登陆失败");
}
//关闭连接
statement.close();
connection.close();
```

## 预处理查询

![image-20220308153033757](https://s2.loli.net/2022/03/09/I2zSWFxp3LDsOXo.png)

先看类图

![image-20220308153422332](https://s2.loli.net/2022/03/09/IgY7t8sTp9nWMUX.png)

看看方法

![image-20220308153628223](https://s2.loli.net/2022/03/09/ymSbC459dinK1GO.png)

### 预处理的好处

1. 不使用 + 拼接 sql 语句，减少语法错误
2. 有效解决 sql 注入问题
3. 大大减少编译次数，提高效率

### 预处理代码演示

```java
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
} else {
    System.out.println("登陆失败");
}
//关闭连接
resultSet.close();
preparedStatement.close();
connection.close();
```

### executeQuery

如果要使用查询语句，就要用`preparedStatement.executeQuery()`

### executeUpdate

如果使用 DML 语句，就要用`preparedStatement.executeUpdate()`

### 课堂练习

![image-20220309105950968](https://s2.loli.net/2022/03/09/ZMm8dG6WKwefzsR.png)

## JDBC API小结

![image-20220309110655721](https://s2.loli.net/2022/03/09/IAufdwjPRcYzLXJ.png)

![image-20220309110711525](https://s2.loli.net/2022/03/09/RiOFywSNxoTD7gM.png)

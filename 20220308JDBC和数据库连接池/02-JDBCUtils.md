# JDBC工具类

JDBCUtils完成两件事：

1. 连接
2. 关闭

```mysql
public class JDBCUtils {
    //定义相关属性
    private static String user;//用户名
    private static String password;//密码
    private static String url;//url
    private static String driver;//驱动名

    //在静态代码块里初始化
    static {
        try {
            Properties properties = new Properties();
            properties.load(new FileInputStream("src\\mysql.properties"));
            //读取属性
            user = properties.getProperty("user");
            password = properties.getProperty("password");
            url = properties.getProperty("url");
            driver = properties.getProperty("driver");

        } catch (Exception e) {
            //实际开发中
            //1. 将编译异常转成运行时异常
            //2. 这是调用者可以捕获该异常，也可以默认处理
            throw new RuntimeException(e);
        }
    }

    /**
     * 连接数据库，返回Connection
     * @return
     */
    public static Connection getConnection() {
        try {
            return DriverManager.getConnection(url, user, password);
        } catch (SQLException e) {
            //将编译异常转成运行时异常
            throw new RuntimeException(e);
        }
    }

    /*
    关闭相关资源：
        1. ResultSet 结果集
        2. Statement 或者 PreparedStatement
        3. Connection
     */

    /**
     * 关闭连接，如果需要关闭就传入，不需要关闭就传入null
     * @param set
     * @param statement
     * @param connection
     */
    public static void close(ResultSet set, Statement statement, Connection connection){
        //判断是否为null
        try {
            if (set != null){
                set.close();
            }
            if (statement != null){
                statement.close();
            }
            if (connection != null){
                connection.close();
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

}
```

# 测试JDBC工具类

## 测试DML语句

```java
/*
测试DML操作
 */
@Test
public void testDML() {
    //1. 得到连接
    Connection connection = null;
    //2. 组织sql语句
    String sql = "UPDATE actor SET name = ? WHERE id = ?";
    PreparedStatement preparedStatement = null;
    //3. 创建 preparedStatement
    try {
        ///得到连接
        connection = JDBCUtils.getConnection();
        //得到预处理语句
        preparedStatement = connection.prepareStatement(sql);
        //给占位符赋值
        preparedStatement.setString(1, "景风眠");
        preparedStatement.setInt(2, 3);
        //执行
        preparedStatement.executeUpdate();
    } catch (Exception e) {
        throw new RuntimeException(e);
    } finally {
        //关闭资源
        JDBCUtils.close(null, preparedStatement, connection);
    }
}
```

## 测试SELECT语句

```java
/*
测试查询操作
 */
@Test
public void testSelect(){
    //定义连接
    Connection connection = null;
    //定义preparedStatement
    PreparedStatement preparedStatement = null;
    //定义resultSet
    ResultSet  resultSet = null;
    //组织sql语句
    String sql = "SELECT * FROM actor";
    //接下来是try，里面的内容可能会报错
    try {
        //获取连接
        connection = JDBCUtils.getConnection();
        //获取预处理语句
        preparedStatement = connection.prepareStatement(sql);
        //执行预处理语句
        preparedStatement.executeQuery();
        //获得查询结果
        resultSet = preparedStatement.getResultSet();
        //输出查询结果
        while(resultSet.next()){
            int id = resultSet.getInt(1);
            String name = resultSet.getString(2);
            String sex = resultSet.getString(3);
            Date bornDate = resultSet.getDate(4);
            System.out.println(id + "\t" + name + "\t" + sex + "\t" + bornDate);
        }
    } catch (SQLException e) {
        throw new RuntimeException(e);
    } finally {
        //关闭查询
        JDBCUtils.close(resultSet, preparedStatement, connection);
    }

}
```


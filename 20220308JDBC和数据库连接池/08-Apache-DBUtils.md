# 问题引出

1. 关闭connection后，resultSet结果集无法使用
2. resultSet不利于数据管理
3. 返回信息不方便

# 解决方案——土办法

创建一个类，让它的属性和表中的字段一一对应，形成映射关系。

这个类叫做JavaBean,PoJO,Domain

将结果集装到ArrayList<Actor>中

一个Actor对应一条表记录

定义一个Actor类

```java
public class Actor {
    private Integer id;
    private String name;
    private String sex;
    private Date borndate;
    private String phone;
    public Actor(){ // 需要给一个无参构造器，因为底层可能用到反射

    };

    public Actor(Integer id, String name, String sex, Date borndate, String phone) {
        this.id = id;
        this.name = name;
        this.sex = sex;
        this.borndate = borndate;
        this.phone = phone;
    }

```

查询完结果后把数据放到了ArrayList<Actor>，数据可以复用。

![image-20220509085454993](https://s2.loli.net/2022/05/25/ZwuMGRYmniKApDb.png)

但是还是有很多重复性的工作，我们需要Apache-DBUtils

![image-20220524211657446](https://s2.loli.net/2022/05/25/NykzJ1nZluEFfMp.png)

# Apache-DBUtils

## 基本介绍

commons-dbutils是Apache组织提供的一个开源JDBC工具类库，它是对JDBC的封装使用dbutilsi能极大简化jdbc编码的工作量

## DbUtils类

1. QueryRunnera类：该类封装了SQL的执行，是线程安全的。可以实现增、删、改、查、批处理
2. 使用QueryRunner类实现查询
3. ResultSetHandler接口：该接口用于处理java.sql.ResultSet,将数据按要求转换为另一种形式
4. ![截屏2022-05-24 23.56.50](https://s2.loli.net/2022/05/25/d8WivhBCHM4qK6l.png)

## 应用实例

使用DBUtils和德鲁伊连接池完成对actor表的CRUD

### 使用DBUtils完成多行查询

```Java
public class DBUtils_USE {
    @Test
    public void testQueryMany() throws Exception{ //返回结果是多行数据
        //1. 得到连接 (druid)
        Connection connection = JDBCUtilsByDruid.getConnection();
        //2. 使用DBUtils的类和接口，需要先引入相关的jar包
        //3. 创建 QueryRunner
        QueryRunner queryRunner = new QueryRunner();
        //4. 就可以执行相关方法
        String sql = "select * from actor where id >= ?";
        //解读
        //(1) query方法就是执行一个SQL语句，得到resultSet -> 封装到 -> ArrayList 集合中
        //(2) 返回集合
        //(3) connection: 连接
        //(4) sql: 执行的sql语句
        //(5) new BeanListHandler<>(Actor.class): 再将resultSet -> Actor对象 -> 封装到ArrayList
        //      底层使用反射机制，获取Actor类的属性
        //(6) 1 就是sql语句里面的 ? ，是可变参数，可以有多个
        //(7) 底层得到的resultSet, 会在query 关闭，关闭 prepareStatement
        List<Actor> list = queryRunner.query(connection, sql, new BeanListHandler<>(Actor.class), 1);
        System.out.println("输出集合的信息");
        for (Actor actor: list){
            System.out.println(actor);
        }

        //释放资源
        JDBCUtilsByDruid.close(null, null, connection);
    }
}
```

![image-20220525123550044](https://s2.loli.net/2022/05/25/XtI9kmMnR6vyZAS.png)

#### 追溯源码

以下为`queryRunner.query`方法

```java
public <T> T query(Connection conn, String sql, ResultSetHandler<T> rsh, Object... params) throws SQLException {
    PreparedStatement stmt = null;
    ResultSet rs = null;
    T result = null;

    try {
        stmt = this.prepareStatement(conn, sql); // 使用了预处理
        this.fillStatement(stmt, params); // 把对象数组params里的value赋值给sql的?
        rs = this.wrap(stmt.executeQuery()); // executeQuery，执行sql语句
        result = rsh.handle(rs); // handle里面使用了反射进行封装，对传入的class对象进行分析
    } catch (SQLException var33) {
        this.rethrow(var33, sql, params);
    } finally {
        try {
            this.close(rs); // 关闭结果集
        } finally {
            this.close((Statement)stmt); // 关闭预处理语句
        }
    }

    return result;
}
```

我感觉里面的`handle()`比较重要，我们进去看一下源码，……不理解

```java
public interface ResultSetHandler<T> {
    T handle(ResultSet var1) throws SQLException;
}
```

 

### 使用DBUtils完成单行（单个对象）的查询

和多行查询的区别就是，这里使用的是`BeanHandler`而不是`BeanListHandler`。

```java
/*
演示apache的DBUtils + 返回单行记录（单个对象）
 */
@Test
public void testQuerySingle() throws Exception{
    //得到连接
    Connection connection = JDBCUtilsByDruid.getConnection();
    //创建QueryRunner
    QueryRunner queryRunner = new QueryRunner();
    //sql语句
    String sql = "select * from actor where id = ?";
    Actor actor = queryRunner.query(connection, sql, new BeanHandler<>(Actor.class), 2);
    System.out.println("输出对向的信息");
    System.out.println(actor);

    //释放资源
    JDBCUtilsByDruid.close(null, null, connection);

}
```

如果查询的对象`id=5`不存在，则`actor=null`。

### 使用DBUtils完成单个记录（一个Obect对象）查询

这里获取的结果是Object对象，使用ScalarHandler

```java
/*
演示apache的DBUtils + 返回单行单列（即一个Object对象)
 */
@Test
public void testScalar() throws Exception{
    //得到连接
    Connection connection = JDBCUtilsByDruid.getConnection();
    //创建QueryRunner
    QueryRunner queryRunner = new QueryRunner();
    //sql语句
    String sql = "select name from actor where id = ?";
    Object o = queryRunner.query(connection, sql, new ScalarHandler(), 3);
    System.out.println("输出对象的信息");
    if (o == null){
        System.out.println("未查询到该条记录！");
    } else {
        System.out.println("o = " + o);
    }

    //释放资源
    JDBCUtilsByDruid.close(null, null, connection);

}
```

## 演示DML操作

```java
/*
    演示 apache-DBUtils + druid 完成DML (update, insert, delete)
     */
@Test
public void testDML() throws Exception{
  //得到连接
  Connection connection = JDBCUtilsByDruid.getConnection();
  //创建QueryRunner
  QueryRunner queryRunner = new QueryRunner();

  //组织sql 完成 update, insert, delete
  //        String sql = "update actor set phone = ? where id = ?";
  //        String sql = "insert into actor values(null,  '毛毛', '女', '2003-05-01', '18226741837')";//update也可以执行insert语句
  String sql = "delete from actor where id = ?";
  int affectedRow = queryRunner.update(connection, sql);//返回受影响的行数
  System.out.println(affectedRow > 0 ? "执行成功" : "执行没有影响到表"); 

  //释放资源
  JDBCUtilsByDruid.close(null, null, connection);

}
```

> 这里出现个问题：插入表的中文字符在数据库页面里显示异常。
>
> 借鉴这里：https://blog.csdn.net/sjc7140/article/details/83685749
>
> 在jdbcurl后面加上`?useUnicode=true&characterEncoding=utf8`
>
> 也就是：
>
> ```properties
> url=jdbc:mysql://124.222.234.99:3306/jyl_test?rewriteBatchedStatements=true&useUnicode=true&characterEncoding=utf8
> ```


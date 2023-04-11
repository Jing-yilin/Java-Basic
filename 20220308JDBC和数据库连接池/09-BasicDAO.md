# 问题引出

apache-dbutils+Druid简化了JDBC开发，但还有不足：

1. SQL语句是固定，不能通过参数传入，通用性不好，需要进行改进，更方便执行增删改查
2. 对于select操作，如果有返回值，返回类型不能固定，需要使用泛型
3. 将来的表很多，业务需求复杂，不可能只靠一个Java类完成
4. 引出=》BasicDAO画出示意图

# DAO

## 基本说明

1. DAO:data access object数据访问对象
2. 这样的通用类，称为BasicDao,是专门和数据库交互的，即完成对数据库（表）的crud操作。
3. 在BaiscDao的基础上，实现一张表对应一个Dao,更好的完成功能，比如Customer表-Customer.java(javabean)-CustomerDao.java

![截屏2022-05-25 16.38.23](https://s2.loli.net/2022/05/25/xZHU3lt8GbwqKkg.png)

## 应用实例

简单设计：

com.hspedu.dao

1. com.hspedu.dao_.utils //工具类
2. com.hspedu.dao_.domain //javabean
3. com.hspedu.dao_.dao //存放XxxDAO和BasicDAO
4. com.hspedu.dao_.test //写测试类 

<img src="https://s2.loli.net/2022/05/26/sifuaq7bXFIMmeh.png" alt="截屏2022-05-26 07.59.46" style="zoom:50%;" />

### DAO

先写一个`BasixDAO`作为所有DAO的父类。

使用了泛型，方便对操作的`Actor`等对象具体情况具体修改。

```java
public class BasicDAO<T> { //泛型指定具体类型

    private QueryRunner qr = new QueryRunner();

    //开发通用的dml方法，针对任意的表

    /**
     * 这是一个通用DML操作方法
     * @param sql sql语句，可以有?
     * @param parameters 替换sql语句里的?
     * @return 返回影响的行数
     */
    public int update(String sql, Object... parameters){
        Connection connection = null;
        try {
            connection = JDBCUtilsByDruid.getConnection();
            int update = qr.update(connection, sql, parameters);
            return update;
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            JDBCUtilsByDruid.close(null, null, connection);
        }
    }

    //返回多个对象

    /**
     *
     * @param sql 需要执行的sql语句,可以有?
     * @param clazz 传入一个类的Class对象,比如Actor.class
     * @param parameters 传入?的具体的值，可以有多个
     * @return 根据Class对象返回对应的ArrayList
     */
    public List<T> queryMulti(String sql, Class<T> clazz, Object... parameters){
        /*
         * 谈谈我对Class<T> clazz 的理解：
         * 首先Class类型是所有类都具有的一个属性，表示该类的类型
         * Class<T>则是指定了里面的泛型是T类
         * clazz 是T类的Class类的一个实例，表示T的类型
         */
        Connection connection = null;
        try {
            connection = JDBCUtilsByDruid.getConnection();
            List<T> query = qr.query(connection, sql, new BeanListHandler<T>(clazz), parameters);
            return query; //返回对象数组
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            JDBCUtilsByDruid.close(null, null, connection);
        }

    }


    //返回单行结果的通用方法

    /**
     *
     * @param sql 需要执行的sql语句,可以有?
     * @param clazz 传入一个类的Class对象,比如Actor.class
     * @param parameters 传入?的具体的值，可以有多个
     * @return 根据Class对象返回单行结果
     */
    public T querySingle(String sql, Class<T> clazz, Object... parameters){
        Connection connection = null;
        try {
            connection = JDBCUtilsByDruid.getConnection();
            T query = qr.query(connection, sql, new BeanHandler<T>(clazz), parameters);
            return query;
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            JDBCUtilsByDruid.close(null, null, connection);
        }
    }

    //返回单行结果的通用方法

    /**
     *
     * @param sql 需要执行的sql语句,可以有?
     * @param parameters 传入?的具体的值，可以有多个
     * @return 返回单个值
     */
    public Object queryScalar(String sql, Object... parameters){
        Connection connection = null;
        try {
            connection = JDBCUtilsByDruid.getConnection();
            return qr.query(connection, sql, new ScalarHandler(), parameters);
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            JDBCUtilsByDruid.close(null, null, connection);
        }
    }


}
```

接下来写`ActorDAO`，只要直接继承，再指定对应的泛型为`Actor`就好了

```java
public class ActorDAO extends BasicDAO<Actor>{

}
```

### domain

domain放的是javabean（也叫pojo, domain）

里面的Actor：

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

    @Override
    public String toString() {
        return "Actor{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", sex='" + sex + '\'' +
                ", borndate=" + borndate +
                ", phone='" + phone + '\'' +
                '}' + '\n';
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public void setBorndate(Date borndate) {
        this.borndate = borndate;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getSex() {
        return sex;
    }

    public Date getBorndate() {
        return borndate;
    }

    public String getPhone() {
        return phone;
    }
}
```

### utils

工具类则是使用了JDBCUtilsByDruid，即使用德鲁伊连接池。

完成数据库的**连接**和**关闭**操作。

```java
public class JDBCUtilsByDruid {
    private static DataSource ds;

    //在静态代码块完成 ds 的初始化
    static {
        Properties properties = new Properties();
        try {
            properties.load(new FileInputStream("src/druid.properties"));
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

## 课后作业

![截屏2022-05-26 08.09.15](https://s2.loli.net/2022/05/26/YzogcXWrEL2Dysd.png)

先创建一张goods表，具有id、goods_name、price这三个字段。

```mysql
-- 创建表
create table goods
(
    id       int auto_increment primary key,
    goods_name     varchar(32) default '' not null,
    price integer default 0 not null
)
    charset = utf8;

-- 插入数据
insert into goods values (null, "巧克力", 999);
insert into goods values (null, "牛奶", 666);
insert into goods values (null, "奥利奥", 555);
```

<img src="https://s2.loli.net/2022/05/26/PBqos3GutdCcQH2.png" alt="截屏2022-05-26 08.19.24" style="zoom:50%;" />

再创建一个JavaBean，需要属性与字段一一对应

```java
public class Goods {
    private Integer id;
    private String goods_name;
    private Integer price;
    
    //空构造器
    public Goods(){}

    public Goods(Integer id, String goods_name, Integer price) {
        this.id = id;
        this.goods_name = goods_name;
        this.price = price;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getGoods_name() {
        return goods_name;
    }

    public void setGoods_name(String goods_name) {
        this.goods_name = goods_name;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }
}
```

测试

```java
/*
课后作业，通过DAO完成对goods表的CRUD
 */
@Test
public void testGoodsDAO(){
    GoodsDAO goodsDAO = new GoodsDAO();
    //查询所有记录
    List<Goods> goodsList = goodsDAO.queryMulti("select * from goods", Goods.class);
    for (Goods goods: goodsList){
        System.out.println(goods);
    }
    //插入一条记录
    int update = goodsDAO.update("insert into goods values(null, '抹茶冰淇淋', 281)");
    System.out.println("一共影响了" + update + "行");
}
```

执行成功！

<img src="https://s2.loli.net/2022/05/26/5zre3Smg174Nha8.png" alt="截屏2022-05-26 08.28.36" style="zoom:50%;" />